package samsung;
import java.util.*;
import java.io.*;

//포탑 터뜨리기
//bfs시 경로 저장하는 방법 배움
//정말 어려웠다.
public class Samsung_22_01_1 {
    int n, m, k;
    int[][] map, attackMap;
    boolean[][] stepMap;
    int presentX = 0, presentY = 0, attackScale; //이제 던질 포탑 좌표
    int strongX = 0, strongY = 0;
    PriorityQueue<Pair> attackList;

    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int sum() {
            return this.x + this.y;
        }
    }
    //rec = attackMap (r)
    //borad = map (p)
    public void first(int time) {
        // 공격자 선정
        attackList = new PriorityQueue<>((o1, o2) -> {
            if (map[o1.x][o1.y] != map[o2.x][o2.y])
                return map[o1.x][o1.y] - map[o2.x][o2.y];
            if (attackMap[o1.x][o1.y] != attackMap[o2.x][o2.y])
                return attackMap[o2.x][o2.y] - attackMap[o1.x][o1.y];
            if (o1.sum() != o2.sum())
                return o2.sum() - o1.sum();
            return o2.y - o1.y;
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue;
                attackList.offer(new Pair(i, j));
            }
        }

        Pair at = attackList.poll();
        presentX = at.x;
        presentY = at.y;
        map[presentX][presentY] += (n+m);
        attackScale = map[presentX][presentY];
        attackMap[presentX][presentY] = time;
        //System.out.println("공격 주체 : " + presentX + " , " + presentY);
    }

    public void second() {
        //2. 공격 받을 자 선정.

        //자신을 제외한 가장 강한 포탑을 골라야함.
        PriorityQueue<Pair> strongList = new PriorityQueue<>((o1, o2) -> {
            if (map[o1.x][o1.y] != map[o2.x][o2.y])
                return map[o2.x][o2.y] - map[o1.x][o1.y];
            if (attackMap[o1.x][o1.y] != attackMap[o2.x][o2.y])
                return attackMap[o1.x][o1.y] - attackMap[o2.x][o2.y];
            if (o1.sum() != o2.sum())
                return o1.sum() - o2.sum();
            return o1.y - o2.y;
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) continue;
                if (i == presentX && j == presentY) continue;
                strongList.offer(new Pair(i, j));
            }
        }

        //공격 대상
        Pair st = strongList.poll();
        // while (!attackList.isEmpty()) {
        //     st = attackList.poll();
        // }
        strongX = st.x;
        strongY = st.y;
        //System.out.println("공격 대상 : " + strongX + " , " + strongY);
    }

    public boolean laserBFS() {
        boolean can = false;
        int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
        int[][] nxtX = new int[n][m];
        int[][] nxtY = new int[n][m];
        boolean[][] vis = new boolean[n][m];

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(presentX, presentY));
        vis[presentX][presentY] = true;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            if (p.x == strongX && p.y == strongY) {
                can = true;
                break;
            }

            for (int k = 0; k < 4; k++) {
                // int xx = (p.x + dx[k] + n) % n;
                // int yy = (p.y + dy[k] + m) % m;

                int xx = p.x + dx[k];
                int yy = p.y + dy[k];
                if (xx < 0) xx = n-1;
                if (xx >= n) xx = 0;
                if (yy < 0) yy = m-1;
                if (yy >= m) yy = 0;

                if (map[xx][yy] == 0 || vis[xx][yy]) continue;

                vis[xx][yy] = true;
                qu.add(new Pair(xx,yy));
                nxtX[xx][yy] = p.x;
                nxtY[xx][yy] = p.y;
            }
        }

        if (!can) return false;

        int x = strongX, y = strongY;
        while (!(x == presentX && y == presentY)) {
            //System.out.print(x+","+y+"-> ");
            stepMap[x][y] = true;
            if (x == strongX && y == strongY) {
                map[x][y] -= attackScale;
            } else {
                map[x][y] -= (attackScale / 2);
            }
            int tmpX = x, tmpY = y;
            x = nxtX[tmpX][tmpY];
            y = nxtY[tmpX][tmpY];
        }
        //System.out.println();
        return true;

    }


    public void attack() {

        stepMap = new boolean[n][m];

        if (laserBFS()) {
            return;
        }

        stepMap[strongX][strongY] = true;
        map[strongX][strongY] -= attackScale;
        int[] dx8 = {-1,-1,-1,0,0,1,1,1}, dy8 = {-1,0,1,-1,1,-1,0,1};
        for (int k = 0; k < 8; k++) {
            int xx = strongX + dx8[k];
            int yy = strongY + dy8[k];
            //int xx = (strongX + dx8[k] + n) % n;
            //int yy = (strongY + dy8[k] + m) % m;

            if (xx < 0) xx = n-1;
            if (xx >= n) xx = 0;
            if (yy < 0) yy = m-1;
            if (yy >= m) yy = 0;
            //자기 자신 넘어감.
            if (xx == presentX && yy == presentY) continue;

            map[xx][yy] -= (attackScale/2);
            stepMap[xx][yy] = true;
        }

    }

    public void last() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] < 0) map[i][j] = 0;
                if (map[i][j] == 0 || stepMap[i][j]) continue;
                if (i == presentX && j == presentY) continue;
                map[i][j]++;
            }
        }
    }

    public boolean finish() {
        //부서진 포탑 처리 및 부서지지 않는게 1개 이하인지 아닌지.
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) sum++;
            }
        }
        if (sum <= 1) return true;
        return false;
    }

    public void solve() {
        for (int i = 1; i <= k; i++) {
            // 4가지 액션 수행

            //1. 공격자 선정
            first(i);

            //2. 공격받을 자 선정
            second();

            //3. 공격자의 공격 (레이저 공격 or 포탄 공격)
            attack();

            //3. 포탑 부서짐
            if (finish()) return;

            //4. 포탑 정비 (부서지지 않은 포탑 중 공격과 무관한 공격력이 + 1)
            last();

            //printMap();

        }
    }

    public void printMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void print() {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(map[i][j], max);
            }
        }
        //System.out.println();
        System.out.println(max);
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        //Main m = new Main();
        Samsung_22_01_1 m = new Samsung_22_01_1();
        m.input();
        m.solve();
        m.print();

    }
    public void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]);
            m = Integer.parseInt(sp[1]);
            k = Integer.parseInt(sp[2]);

            map = new int[n][m];
            attackMap = new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            }

        } catch(Exception e) {}
    }
}
