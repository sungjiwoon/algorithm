package samsung;
import java.io.*;
import java.util.*;

/*
예술성 (골3)
DFS + 구현
https://www.codetree.ai/training-field/frequent-problems/problems/artistry/description?page=1&pageSize=20
 */
public class  Samsung_22_01_am_02{
    int n;
    int[][] map;
    long ans = 0;
    int idx;
    int[][] idxMap;
    int[][] groupList; //0 : v, 1 : cnt
    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};


    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
        boolean equal(Pair o) {
            if (o.x == this.x && o.y == this.y) return true;
            return false;
        }
    }
    public void divide() {
        //구역 나누기.
        idxMap = new int[n][n];
        idx = 1;
        groupList = new int[n*n+2][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (idxMap[i][j] != 0) continue;

                Queue<Pair> qu = new LinkedList<>();
                qu.add(new Pair(i, j));
                // int cnt = 0;
                int v = map[i][j];

                while (!qu.isEmpty()) {
                    Pair p = qu.poll();
                    idxMap[p.x][p.y] = idx;
                    for (int k = 0; k < 4; k++) {
                        int xx = p.x + dx[k];
                        int yy = p.y + dy[k];
                        if (xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
                        if (idxMap[xx][yy] != 0) continue;
                        if (map[xx][yy] != v) continue;
                        qu.add(new Pair(xx, yy));
                    }
                }
                groupList[idx][0] = v;
                idx++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int indx = idxMap[i][j];
                groupList[indx][1]++;
            }
        }

        // for (int i = 1; i < idx; i++) {
        //     System.out.println("G:"+ i +" " + groupList[i][0] +", " + groupList[i][1]);
        // }

    }
    public int getNear(int idx1, int idx2) {

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (idxMap[i][j] == idx1) {
                    for (int k = 0; k < 4; k++) {
                        int ii = i + dx[k];
                        int jj = j + dy[k];
                        if (ii < 0 || jj < 0 || ii >= n || jj >= n) continue;
                        if (idxMap[ii][jj] == idx2) sum++;
                    }
                }
            }
        }
        return sum;
    }
    public void solveScore() {
        //예술 점수 구하기

        for (int i = 1; i < idx - 1; i++) {
            for (int j = i + 1; j < idx; j++) {
                int near = getNear(i, j); //근접한 면 구하기.
                ans += (groupList[i][1] + groupList[j][1]) * groupList[i][0] * groupList[j][0] * near;
            }
        }

    }
    public void rotateTen90() {
        //십자가 회전. (반시계!)
        int[][] mapTmp = new int[n][n];
        int i = 0, j = 0;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                mapTmp[i][j] = map[i][j];
            }
        }

        for (i = 0; i < n; i++) {
            mapTmp[i][n/2] = map[n/2][n-i-1];
        }

        for (j = 0; j < n; j++) {
            mapTmp[n/2][j] = map[j][n/2];
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                map[i][j] = mapTmp[i][j];
            }
        }

    }

    public void rotate90(int x, int y) {
        int size = n/2;
        int[][] mapTmp = new int[n/2][n/2];
        int[][] mapCpy = new int[n/2][n/2];

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                mapCpy[i][j] = map[x+i][y+j];
            }
        }


        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                mapTmp[i][j] = mapCpy[size-1-j][i];
            }
        }

        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < n/2; j++) {
                map[x+i][y+j] = mapTmp[i][j];
            }
        }

    }
    public void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printIdxMap() {
        System.out.println("= idxMap =");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(idxMap[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void solve() {
        for (int i = 0; i < 4; i++) {
            //1. 구역 나누기.
            divide();

            //2. 예술 점수 구하기.
            solveScore();

            //3. 회전.
            //십자가 회전
            rotateTen90();

            //사각형 회전
            rotate90(0, 0); //1사분면
            rotate90(0, n/2+1); //2사분면
            rotate90(n/2+1, 0); //3사분면
            rotate90(n/2+1, n/2+1); //4사분면

            // printMap();
            // printIdxMap();
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        //Main m = new Main();
        Samsung_22_01_am_02 m = Samsung_22_01_am_02();
        m.input();
        m.solve();
    }
    public void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        } catch (Exception e) {

        }
    }
}

