package study_alone;

import java.io.*;
import java.util.*;
/** 240407 코드트리 팩맨 골1 구현 */
public class CT_240407 {
    final int N = 5;
    int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}, dc = {0, -1, -1, -1, 0, 1, 1, 1};
    int[] dr2 = {-1, 0, 1, 0}, dc2 = {0, -1, 0, 1};

    int m, T, t;
    int packC, packR;
    Queue<Monster>[][] monsterMap = new LinkedList[N][N];
    Queue<Monster>[][] eggMap = new LinkedList[N][N];
    int[][] diedMap = new int[N][N];

    class Monster {

        int r, c, d;

        Monster(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public void copyMonster() {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                int size = monsterMap[i][j].size();
                for (int k = 0; k < size; k++) {
                    Monster p = monsterMap[i][j].poll();
                    eggMap[i][j].add(p);
                    monsterMap[i][j].add(p);
                }
            }
        }
    }

    public boolean isRange(int r, int c) {
        return (r >= 1 && c >= 1 && r < N && c < N);
    }

    public boolean isCanMove(int r, int c) {
        if (r < 1 || c < 1 || r >= N || c >= N)
            return false;
        if (r == packR && c == packC)
            return false;
        if (t - diedMap[r][c] <= 2)
            return false;
        return true;
    }

    public void moveMonster() {
        Queue<Monster>[][] newQ = new LinkedList[N][N];
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                newQ[i][j] = new LinkedList<>();
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                Queue<Monster> qu = monsterMap[i][j];
                while (!qu.isEmpty()) {
                    Monster ms = qu.poll();
                    boolean canMove = false;
                    int nr = ms.r, nc = ms.c, nd = ms.d;
                    for (int k = 0; k < 8; k++) {
                        nr = ms.r + dr[nd];
                        nc = ms.c + dc[nd];
                        if (isCanMove(nr, nc)) {
                            canMove = true;
                            break;
                        }
                        nd = (nd + 1) % 8;
                    }
                    if (!canMove) {
                        nr = ms.r;
                        nc = ms.c;
                        nd = ms.d;
                    }
                    newQ[nr][nc].add(new Monster(nr, nc, nd));
                }
            }
        }
        monsterMap = newQ;
    }

    public void movePackMan() {
        int[] finalMove = new int[3];
        int max = -1;

        for (int i = 0; i < 4; i++) {
            boolean[][] vis = new boolean[N][N];
            int ir = packR + dr2[i], ic = packC + dc2[i];
            if (!isRange(ir, ic))
                continue;
            int oneSize = monsterMap[ir][ic].size();
            vis[ir][ic] = true;

            for (int j = 0; j < 4; j++) {

                int jr = ir + dr2[j], jc = ic + dc2[j];
                if (!isRange(jr, jc))
                    continue;
                int twoSize = monsterMap[jr][jc].size();
                if (vis[jr][jc])
                    twoSize = 0;
                vis[jr][jc] = true;

                for (int k = 0; k < 4; k++) {
                    int kr = jr + dr2[k], kc = jc + dc2[k];
                    if (!isRange(kr, kc))
                        continue;
                    int threeSize = monsterMap[kr][kc].size();
                    if (vis[kr][kc])
                        threeSize = 0;

                    if (oneSize + twoSize + threeSize > max) {
                        max = oneSize + twoSize + threeSize;
                        finalMove[0] = i;
                        finalMove[1] = j;
                        finalMove[2] = k;
                    }
                }
            }
        }

        int nr = packR, nc = packC;
        // System.out.print("팩맨 이동 : ");
        for (int i = 0; i < 3; i++) {
            nr += dr2[finalMove[i]];
            nc += dc2[finalMove[i]];
            if (monsterMap[nr][nc].size() > 0) {
                diedMap[nr][nc] = t;
                monsterMap[nr][nc] = new LinkedList<>();
            }

            // System.out.print(String.format("(%d, %d) ->", nr, nc));
        }
        // System.out.println();
        packR = nr;
        packC = nc;

    }

    public void hatchEgg() {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                while (!eggMap[i][j].isEmpty()) {
                    monsterMap[i][j].add(eggMap[i][j].poll());
                }
            }
        }
    }

    public void print() {
        System.out.println(t + "번째 턴");
        System.out.println(String.format("팩맨 위치 : (%d, %d)", packR, packC));
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                System.out.print(monsterMap[i][j].size() + " ");
            }
            System.out.println();
        }

    }

    public void solve() {
        for (t = 1; t <= T; t++) {
            // 1. 몬스터 복제 시도
            copyMonster();

            // 2. 몬스터 이동
            moveMonster();

            // 3. 팩맨 이동
            movePackMan();

            // 4. 몬스터 시체 소멸
            // 5. 몬스터 복제 완성
            hatchEgg();
        }

        int res = 0;
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                res += monsterMap[i][j].size();
            }
        }
        System.out.println(res);
    }


    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
//        Main m = new Main();
        CT_240407 m = new CT_240407();
        m.input();
        m.solve();

    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        packR = Integer.parseInt(st.nextToken());
        packC = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                monsterMap[i][j] = new LinkedList<>();
                eggMap[i][j] = new LinkedList<>();
                diedMap[i][j] = -2;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            monsterMap[r][c].add(new Monster(r, c, d));
        }


    }
}
