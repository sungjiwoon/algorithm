package samsung;
import java.util.*;
import java.io.*;

public class Samsung_23_01_02 {
    int n, m, k, c;
    int[][] map, spreayMap;
    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    int[] dx2 = {-1,-1,1,1}, dy2 = {-1,1,-1,1};
    long score = 0;
    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void growUp() {
        Queue<Pair> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 1 && spreayMap[i][j] == 0) {
                    qu.add(new Pair(i, j));
                }
            }
        }

        int[][] beforeMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                beforeMap[i][j] = map[i][j];
            }
        }

        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            ArrayList<Pair> newTreeList = new ArrayList<>();
            int nearTree = 0;
            for (int kk = 0; kk < 4; kk++) {
                int xx = p.x + dx[kk];
                int yy = p.y + dy[kk];
                if (xx < 0 || yy < 0 || xx >= n || yy >= n) continue;

                if (beforeMap[xx][yy] == -1) continue;
                if (beforeMap[xx][yy] >= 1 && spreayMap[xx][yy] == 0) nearTree++;
                if (beforeMap[xx][yy] == 0 && spreayMap[xx][yy] == 0) {
                    newTreeList.add(new Pair(xx, yy));
                }
            }

            map[p.x][p.y] += nearTree;
            if (newTreeList.size() == 0) continue;
            int treeNum = map[p.x][p.y] / newTreeList.size();
            for (Pair q : newTreeList) {
                map[q.x][q.y] += treeNum;
            }
        }
    }

    public void removeSpreay() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (spreayMap[i][j] >= 1) {
                    spreayMap[i][j]--;
                }
            }
        }
    }

    public void putSpreay() {
        Queue<Pair> qu = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 1 && spreayMap[i][j] == 0) {
                    qu.add(new Pair(i, j));
                }
            }
        }

        int[][] maxSpreayMap = new int[n][n];

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            int sum = map[p.x][p.y];

            for (int dir = 0; dir < 4; dir++) {
                for (int kk = 1; kk <= k; kk++) {
                    int xx = p.x + kk * dx2[dir];
                    int yy = p.y + kk * dy2[dir];
                    if (xx < 0 || yy < 0 || xx >= n || yy >= n) break;

                    if (map[xx][yy] != -1 && spreayMap[xx][yy] == 0) {
                        sum += map[xx][yy];
                    }

                    if (map[xx][yy] <= 0) break;
                }
            }
            maxSpreayMap[p.x][p.y] = sum;
        }

        removeSpreay();

        int maxX = -1, maxY = -1, max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < maxSpreayMap[i][j]) {
                    maxX = i;
                    maxY = j;
                    max = maxSpreayMap[i][j];
                }
            }
        }

        if (maxX == -1 && maxY == -1) return;

        //제초제 뿌림.
        // System.out.println(maxX + "," + maxY + "=" + max);

        score += max;
        spreayMap[maxX][maxY] = c;
        map[maxX][maxY] = 0;
        for (int dir = 0; dir < 4; dir++) {
            for (int kk = 1; kk <= k; kk++) {
                int xx = maxX + kk * dx2[dir];
                int yy = maxY + kk * dy2[dir];
                if (xx < 0 || yy < 0 || xx >= n || yy >= n) break;
                if (map[xx][yy] < 0) break;
                if (map[xx][yy] == 0) {
                    spreayMap[xx][yy] = c;
                    break;
                }
                map[xx][yy] = 0;
                spreayMap[xx][yy] = c;

            }
        }

    }
    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j]+"  ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(spreayMap[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public void solve() {
        for (int t = 1; t <= m; t++) {
            //1. 기존 나무 성장
            //2. 기존 나무들의 번식
            growUp();
            //4. 제초제 뿌릴 칸 고름 -> 뿌리기 전 제초제 년도 -1 -> 제초제 뿌림.
            putSpreay();

            // System.out.println(t +"초");
            // print();

        }

        System.out.println(score);
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        //Main m = new Main();
        Samsung_23_01_02 m = new Samsung_23_01_02();
        m.input();
        m.solve();
    }
    public void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]); //미로의 크기
            m = Integer.parseInt(sp[1]); //M년
            k = Integer.parseInt(sp[2]); //제초제의 확산 범위
            c = Integer.parseInt(sp[3]); //제초제의 남아있는 년수

            map = new int[n][n];
            spreayMap = new int[n][n]; //제초제 맵.
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        } catch(Exception e) {}
    }
}

