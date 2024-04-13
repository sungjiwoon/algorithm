package study_alone;

import java.io.*;
import java.util.*;
/** 240413 코드트리 삼성 꼬리잡기놀이 골드1 BFS, 구현 */
public class CT_240413 {
    final int N = 21;
    final int M = 6;
    final int HEAD = 1, REMAIN = 2, TAIL = 3;
    int n, m, k;
    int[][] routeMap = new int[N][N];
    int[][] map = new int[N][N];
    int[][] newMap;
    Pair[] headMap = new Pair[M], tailMap = new Pair[M];
    long res = 0;

    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isRange(int x, int y) {
        return (0 < x && x <= n && 0 < y && y <= n);
    }

    public boolean canGo(int x, int y) {
        return isRange(x, y) && map[x][y] != 0 && routeMap[x][y] == 0;
    }

    public void bfs(int x, int y, int idx) {
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(x, y));
        routeMap[x][y] = idx;
        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            if (map[p.x][p.y] == 1) {
                headMap[idx] = new Pair(p.x, p.y);
            } else if (map[p.x][p.y] == 3) {
                tailMap[idx] = new Pair(p.x, p.y);
            }

            for (int d = 0; d < 4; d++) {
                int nx = p.x+dx[d], ny = p.y+dy[d];
                if (canGo(nx, ny)) {
                    routeMap[nx][ny] = idx;
                    qu.add(new Pair(nx, ny));
                }

            }
        }
    }

    public void initRouteMap() {
        int idx = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] > 0 && routeMap[i][j] == 0) {
                    bfs(i, j, idx);
                    idx++;
                }
            }
        }
    }

    public void step(int idx) {
        Pair head = headMap[idx];
        Pair tail = tailMap[idx];
        int hx = head.x, hy = head.y;
        int tx = tail.x, ty = tail.y;

        boolean[][] vis = new boolean[N][N];
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(hx, hy));

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            vis[p.x][p.y] = true;

            for (int d = 0; d < 4; d++) {
                int nx = p.x+dx[d], ny = p.y+dy[d];
                if (!isRange(nx, ny) || routeMap[nx][ny] != idx) continue;

                if (p.x == hx && p.y == hy) {
                    if (map[nx][ny] != REMAIN) {
                        newMap[nx][ny] = HEAD;
                        headMap[idx] = new Pair(nx, ny);
                    } else {
                        qu.add(new Pair(nx, ny));
                    }
                } else if (p.x == tx && p.y == ty) {
                    if (vis[nx][ny]&& !(nx == hx && ny == hy)) {
                        newMap[nx][ny] = TAIL;
                        tailMap[idx] = new Pair(nx, ny);
                    }
                } else {
                    if (!vis[nx][ny]) {
                        qu.add(new Pair(nx, ny));
                        continue;
                    }
                    newMap[nx][ny] = REMAIN;
                }
            }
        }

    }

    public void move() {
        newMap = new int[N][N];
        for (int i = 1; i <= m; i++) {
            step(i);
        }
        map = newMap;
    }

    public void print() {
        System.out.println("MAP");
        for (int i= 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Pair shoot(int round) {
        int dir = (round / n) % 4;
        int st = round % n;

        Pair attack = new Pair(-1, -1);
        if (dir == 0) {
            st++;
            for (int j = 1; j <= n; j++) {
                if (map[st][j] > 0) {
                    attack = new Pair(st, j);
                    break;
                }
            }
        } else if (dir == 1) {
            st++;
            for (int i = n; i >= 1; i--) {
                if (map[i][st] > 0) {
                    attack = new Pair(i, st);
                    break;
                }
            }
        } else if (dir == 2) {
            st = n - st;
            for (int j = n; j >= 1; j--) {
                if (map[st][j] > 0) {
                    attack = new Pair(st, j);
                    break;
                }
            }
        } else if (dir == 3) {
            st = n - st;
            for (int i = 1; i <= n; i++) {
                if (map[i][st] > 0) {
                    attack = new Pair(i, st);
                    break;
                }
            }
        }

        // System.out.println(String.format("round %d : (%d, %d) 공 맞음.", round, attack.x, attack.y));

        return attack;
    }

    public void change(Pair attack) {
        int idx = routeMap[attack.x][attack.y];

        Pair head = headMap[idx];
        Pair tail = tailMap[idx];
        int ax = attack.x, ay = attack.y;
        int hx = head.x, hy = head.y;
        int tx = tail.x, ty = tail.y;

        // 순서 바꿔줌.
        headMap[idx] = new Pair(tx, ty);
        tailMap[idx] = new Pair(hx, hy);

        int[][] dest = new int[N][N];
        dest[hx][hy] = 1;

        if (hx == ax && hy == ay) {
            res += 1;
            return;
        }

        Queue<Pair> qu = new LinkedList<>();
        for (int d = 0; d < 4; d++) {
            int nx = hx + dx[d], ny = hy + dy[d];
            if (!isRange(nx, ny)) continue;
            if (map[nx][ny] == REMAIN) {
                qu.add(new Pair(nx, ny));
                dest[nx][ny] = 2;
                break;
            }
        }

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            if (p.x == ax && p.y == ay) {
                // System.out.println("공격 값 : " + (dest[p.x][p.y] * dest[p.x][p.y]));
                res += dest[p.x][p.y] * dest[p.x][p.y];
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = p.x+dx[d], ny = p.y+dy[d];
                if (!isRange(nx, ny) || map[nx][ny] == 0 || dest[nx][ny] > 0) continue;
                dest[nx][ny] = dest[p.x][p.y] + 1;
                qu.add(new Pair(nx, ny));
            }
        }

    }

    public void solve() {
        initRouteMap();

        for (int r = 0; r < k; r++) {
            //각 팀은 머릿사람을 따라서 이동.
            move();
            // print();

            // 공 던져짐.
            Pair attack = shoot(r);
            if (attack.x == -1) continue;
            change(attack);

        }
        System.out.println(res);
    }
    public static void main(String[] args) throws Exception {
        CT_240413 m = new CT_240413();
        m.init();
        m.solve();
    }
    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
