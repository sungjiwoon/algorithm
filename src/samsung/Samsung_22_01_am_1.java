package samsung;
import java.util.*;
import java.io.*;

public class Samsung_22_01_am_1 {
    int n, m, h, k;
    int[][] map;
    Queue<Integer>[][] mapQ;
    int Left = 0, Right = 1, Down = 2, Up = 3;
    int catLoc = 1, runnerLoc = 2;

    Pair[] runList;
    Pair[] catchList = new Pair[105];
    boolean[][] treeMap;
    boolean[] notRunner;

    int[] dx = {0,0,1,-1}, dy = {-1,1,0,0};
    Pair catcher;
    long score = 0;

    class Pair {
        int x, y;
        int dir;
        Pair (int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public int getDisMeAndCatcher(Pair me) {
        return Math.abs(me.x - catcher.x) + Math.abs(me.y - catcher.y);
    }

    public void setCatchList() {
        //술래의 발자취를 미리 보관.
        //left = 0, right = 1, down = 2, up = 3;

        int x = n/2 + 1, y = n/2 + 1;
        int dir = 0;
        int[] nxtForward = {3, 1, 2, 0}; //up->right->down->left

        int i = 0, j = 1;
        catchList[i++] = new Pair(x, y, nxtForward[dir]);
        int newDir = dir;
        while (i <= k + 1) {

            for (int jj = 0; jj < j; jj++) {
                int mv = nxtForward[dir];
                int xx = x + dx[mv];
                int yy = y + dy[mv];
                x = xx;
                y = yy;
                newDir = mv;
                if (jj == j-1) newDir = nxtForward[(dir + 4 + 1) % 4];
                catchList[i++] = new Pair(xx, yy, newDir);

                if (xx == 1 && yy == 1) {
                    catchList[i-1] = new Pair(xx, yy, Down);
                    while (i <= k+1) {
                        for (int l = n*n - 2; l > 0; l--) {
                            Pair p = catchList[l];
                            newDir = catchList[l-1].dir;

                            //newDir = p.dir; //down
                            if (newDir == Up) {
                                newDir = Down;
                            } else if (newDir == Down) {
                                newDir = Up;
                            } else if (newDir == Left) {
                                newDir = Right;
                            } else if (newDir == Right) {
                                newDir = Left;
                            }

                            catchList[i++] = new Pair(p.x, p.y, newDir);
                            if (i > k+1) return;
                        }

                        for (int l = 0; l < n*n; l++) {
                            Pair p = catchList[l];
                            catchList[i++] = new Pair(p.x, p.y, p.dir);
                            if (i > k+1) return;
                        }
                    }
                }
            }

            if (nxtForward[dir] == Left || nxtForward[dir] == Right) {
                j++;
            }

            dir = (dir + 1 + 4) % 4;

        }

    }

    public void printList() {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(Up, "Up");
        hm.put(Down, "Down");
        hm.put(Left, "Left");
        hm.put(Right, "Right");
        int k = 0;
        for (Pair ch : catchList) {
            if (ch == null) break;
            //System.out.print(ch.x + "," + ch.y+ "(" + hm.get(ch.dir) + ")->");
            if (k++ % 10 == 0) System.out.println();
        }
        System.out.println();
    }

    public Pair runUpDown(Pair loc) {
        //위 아래로 이동.
        int x = loc.x, y = loc.y;
        int xx = x;
        int dir = loc.dir;

        if (dir == Down) {
            xx = x + 1;
            if (xx > n) {
                xx = n - 1;
                dir = Up;
            }
        } else if (dir == Up) {
            xx = x - 1;
            if (xx <= 0) {
                xx = 2;
                dir = Down;
            }
        }

        if (map[xx][y] == catLoc) {
            xx = x;
        }

        return new Pair(xx, y, dir);
    }

    public Pair runLeftRight(Pair loc) {
        int x = loc.x, y = loc.y;
        int yy = y;
        int dir = loc.dir;
        if (dir == Right) {
            yy = y + 1;
            if (yy > n) {
                yy = n - 1;
                dir = Left;
            }
        } else if (dir == Left) {
            yy = y - 1;
            if (yy <= 0) {
                yy = 2;
                dir = Right;
            }
        }

        if (map[x][yy] == catLoc) {
            yy = y;
        }

        return new Pair(x, yy, dir);
    }

    public int catchRunner(int dir, int x, int y) {

        int sum = 0; //도망자의 수

        if (!treeMap[x][y] && map[x][y] == runnerLoc) {
            while (!mapQ[x][y].isEmpty()) {
                int idx = mapQ[x][y].poll();
                //System.out.println("catched! " + x + "," + y);
                sum++;
                notRunner[idx] = true; //잡힙
            }
            map[x][y] = 0;
        }

        for (int j = 0; j < 2; j++) {
            x = x + dx[dir];
            y = y + dy[dir];
            //System.out.println("moving.. " + x + "," + y);
            if (x <= 0||y <= 0||x > n||y > n) break;
            if (treeMap[x][y]) continue; //나무

            if (map[x][y] == runnerLoc) {
                while (!mapQ[x][y].isEmpty()) {
                    int idx = mapQ[x][y].poll();
                    //System.out.println("catched! " + x + "," + y);
                    sum++;
                    notRunner[idx] = true; //잡힙
                }
                map[x][y] = 0;
            }

        }
        return sum;
    }

    public void solve() {
        setCatchList();
        //printList();

        for (int i = 1; i <= k; i++) {
            //1. 도망자가 먼저 움직인다.

            for (int j = 0; j < m; j++) {
                if (notRunner[j]) continue;

                Pair run = runList[j];
                int x = run.x, y = run.y;

                if (getDisMeAndCatcher(run) > 3) continue;
                //map[run.x][run.y] = 0;
                mapQ[x][y].poll();
                if (mapQ[x][y].isEmpty()) map[x][y] = 0;

                if (run.dir == Up || run.dir == Down) {
                    run = runUpDown(new Pair(run.x, run.y, run.dir));
                } else {
                    run = runLeftRight(new Pair(run.x, run.y, run.dir));
                }

                map[run.x][run.y] = runnerLoc;
                mapQ[run.x][run.y].offer(j);
                runList[j] = run;
                //System.out.print(run.x + "," + run.y +"/");
            }
            // System.out.println();

            //2. 술래가 움직인다.
            map[catcher.x][catcher.y] = 0;
            catcher = new Pair(catchList[i].x, catchList[i].y, catchList[i].dir);

            int modiDir = catchList[i].dir;
            int x = catcher.x, y = catcher.y;

            // if (modiDir == 3) {
            // 	System.out.println(i + " catcher <" + (x) + "," + (y) +"> Up");
            // } else if (modiDir == 1) {
            // 	System.out.println(i + " catcher <" + (x) + "," + (y) +"> Right");
            // } else if (modiDir == 2) {
            // 	System.out.println(i + " catcher <" + (x) + "," + (y) +"> Down");
            // } else {
            // 	System.out.println(i + " catcher <" + (x) + "," + (y) +"> Left");
            // }

            int sum = catchRunner(modiDir, x, y);
            score += (long) sum * i;
            map[catcher.x][catcher.y] = catLoc;

        }

        System.out.println(score);

    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

//        Main M = new Main();
        Samsung_22_01_am_1 M = new Samsung_22_01_am_1();
        M.input();

        M.solve();

    }
    public void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]);
            m = Integer.parseInt(sp[1]);
            h = Integer.parseInt(sp[2]);
            k = Integer.parseInt(sp[3]);

            runList = new Pair[m];
            notRunner = new boolean[m];
            map = new int[n+1][n+1];
            catcher = new Pair(n/2 + 1, n/2 + 1, Up);
            map[n/2 + 1][n/2 + 1] = catLoc; //술래
            treeMap = new boolean[n+1][n+1];
            mapQ = new LinkedList[n+1][n+1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    mapQ[i][j] = new LinkedList<>();
                }
            }

            for (int i = 0; i < m; i++) {
                sp = br.readLine().split(" ");
                int x = Integer.parseInt(sp[0]);
                int y = Integer.parseInt(sp[1]);
                int dir = Integer.parseInt(sp[2]);
                map[x][y] = runnerLoc; //도망자 있음을 나타냄. (2번 인덱스 부터 시작.)

                mapQ[x][y].offer(i);

                runList[i] = new Pair(x, y, dir);
            }

            for (int i = 0; i < h; i++) {
                sp = br.readLine().split(" ");
                int x = Integer.parseInt(sp[0]);
                int y = Integer.parseInt(sp[1]);
                treeMap[x][y] = true;
            }

        } catch (Exception e) {}
    }
}

