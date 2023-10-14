package samsung;
import java.io.*;
import java.util.*;
/*
    꼬리잡기 놀이
    골드 1
    구현
*/
public class Samsung_22_01_pm_1 {
    int n, m, k;
    int[][] map, idxMap;
    Group[] groupList;
    long score = 0;
    final int Right = 0, Up = 1, Left = 2, Down = 3;
    int[] dx = {0,-1,0,1}, dy = {1,0,-1,0}; //R U L D
    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Group {
        Pair head, tail;
        Group (Pair head, Pair tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public boolean isRange(int xx, int yy) {
        return (xx >= 0 && yy >= 0 && xx < n && yy < n);
    }

    public void init() {
        //그룹idx 맵 완성.
        int idx = 1;
        idxMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (idxMap[i][j] != 0) continue;
                if (map[i][j] == 0) continue;
                Queue<Pair> qu = new LinkedList<>();
                qu.add(new Pair(i, j));
                while (!qu.isEmpty()) {
                    Pair p = qu.poll();
                    idxMap[p.x][p.y] = idx;
                    for (int k = 0; k < 4; k++) {
                        int xx = p.x + dx[k];
                        int yy = p.y + dy[k];
                        if (isRange(xx, yy) && map[xx][yy] >= 1 && idxMap[xx][yy] == 0) {
                            qu.add(new Pair(xx, yy));
                        }
                    }
                }
                idx++;
            }
        }

        // for (int i = 0; i < n; i++){
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(idxMap[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        groupList = new Group[idx];
        for (int i = 1; i < idx; i++) {
            groupList[i] = new Group(new Pair(0,0), new Pair(0,0));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (idxMap[i][j] == 0) continue;
                if (map[i][j] == 1) {
                    Pair head = new Pair(i, j);
                    groupList[idxMap[i][j]].head = head;
                } else if (map[i][j] == 3) {
                    Pair tail = new Pair(i, j);
                    groupList[idxMap[i][j]].tail = tail;
                }
            }
        }
    }

    public void moveOneStep() {
        for (Group g : groupList) {
            if (g == null) continue;

            int hx = g.head.x, hy = g.head.y, tx = g.tail.x, ty = g.tail.y;
            //System.out.println("head: " + hx+","+hy+" tail: " + tx+","+ty);
            int nhx = -1, nhy = -1, ntx = -1, nty = -1;

            //꼬리의 이동
            for (int k = 0; k < 4; k++) {
                int xx = tx + dx[k];
                int yy = ty + dy[k];
                if (isRange(xx, yy) && map[xx][yy] == 2 && idxMap[xx][yy] == idxMap[tx][ty]) {
                    ntx = xx;
                    nty = yy;
                    break;
                }
            }

            //머리의 이동.
            for (int k = 0; k < 4; k++) {
                int xx = hx + dx[k];
                int yy = hy + dy[k];
                if (isRange(xx, yy) && map[xx][yy] == 4 && idxMap[xx][yy] == idxMap[hx][hy]) {
                    nhx = xx;
                    nhy = yy;
                    break;
                }
            }
            //만약 머리 다음칸이 꼬리인 경우.
            if (nhx == -1 && nhy == -1) {
                for (int k = 0; k < 4; k++) {
                    int xx = hx + dx[k];
                    int yy = hy + dy[k];
                    if (isRange(xx, yy) && map[xx][yy] == 3 && idxMap[xx][yy] == idxMap[hx][hy]) {
                        nhx = xx;
                        nhy = yy;
                        break;
                    }
                }
            }

            // System.out.println("next) head: " + nhx+","+nhy+" tail: " + ntx+","+nty);
            map[ntx][nty] = 3;
            map[tx][ty] = 4;
            map[nhx][nhy] = 1;
            map[hx][hy] = 2;

            g.head = new Pair(nhx, nhy);
            g.tail = new Pair(ntx, nty);

            // g = new Group(new Pair(nhx, nhy), new Pair(ntx, nty));
        }
    }

    public int[] getShootLoc(int round) {
        int stX = -1, stY = -1;
        int dir = -1;

        dir = (round / n ) % 4;
        if (round % n == 0) dir = (dir - 1 + 4) % 4;

        switch (dir) {
            case Right:
                stX = round % n -1;
                if (stX == -1) stX = n - 1;
                stY = 0;
                break;
            case Up:
                stX = n - 1;
                stY = round % n - 1;
                if (stY == -1) stY = n - 1;
                break;
            case Left:
                stX = n - 1 - (round % n - 1);
                if (stX == n) stX = 0;
                stY = n - 1;
                break;
            case Down:
                stX = 0;
                stY = n - 1 - (round % n - 1);
                if (stY == n) stY = 0;
                break;
        }

        return new int[]{stX, stY, dir};

    }

    public int bfs(int x, int y, int idx) {
        //머리까지 거리 구하기.
        Group g = groupList[idx];
        Pair head = g.head;
        if (map[x][y] == 1) return 1;

        Queue<Pair> qu = new LinkedList<>();
        int[][] d = new int[n][n];
        //System.out.println("head: " + head.x+","+head.y);

        d[head.x][head.y] = 1;
        qu.add(new Pair(head.x, head.y));
        int maxLen = 1;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            if (p.x == x && p.y == y) {
                break;
            }

            for (int k = 0; k < 4; k++) {
                int xx = p.x + dx[k];
                int yy = p.y + dy[k];
                if (isRange(xx,yy) && d[xx][yy] == 0 && map[xx][yy] == 2 && idxMap[xx][yy] == idxMap[x][y]) {
                    //System.out.println(xx + "," + yy);
                    qu.add(new Pair(xx, yy));
                    d[xx][yy] = d[p.x][p.y] + 1;
                    maxLen = Math.max(maxLen, d[xx][yy]);
                }
            }
        }
        if (map[x][y] == 3) {
            return maxLen + 1;
        }

        return d[x][y];
    }

    public void change(int idx) {
        Group g = groupList[idx];
        int hx = g.head.x, hy = g.head.y, tx = g.tail.x, ty = g.tail.y;
        groupList[idx] = new Group(new Pair(tx, ty), new Pair(hx, hy));
        map[hx][hy] = 3;
        map[tx][ty] = 1;
    }

    public void shootBall(int round) {
        int[] loc = getShootLoc(round);
        int sx = loc[0], sy = loc[1], dir = loc[2];
        for (int i = 0; i < n; i++) {
            int xx = sx + i * dx[dir];
            int yy = sy + i * dy[dir];
            if (map[xx][yy] >= 1 && map[xx][yy] <= 3) {
                //맞았음.
                //System.out.println("공맞음: " + xx+","+yy);
                int d = bfs(xx, yy, idxMap[xx][yy]);
                score += (d*d);

                int idx = idxMap[xx][yy];
                change(idx);
                return;
            }
        }
    }
    public void solve() {
        init();
        for (int i = 1; i <= k; i++) {
            //1. 머리사람을 따라서 한칸 이동.
            moveOneStep();

            //2. 공 던짐
            //2-1. 공 맞은 최초의 사람 점수 얻음. k번쨰 사람이면 K의 제곱 만큼
            //2-2. 그리고 공을 맞은 팀은 머리 <-> 꼬리 체인지.
            shootBall(i);
        }
        System.out.println(score);
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
//        Main m = new Main();
        Samsung_22_01_pm_1 m = new Samsung_22_01_pm_1();
        m.input();

        m.solve();

    }
    public void input() {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]);
            m = Integer.parseInt(sp[1]);
            k = Integer.parseInt(sp[2]);

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        } catch (Exception e) {}
    }
}

