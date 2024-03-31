package study_alone;

import java.io.*;
import java.util.*;
/** 240331 코드트리 토끼와 거북이 구현+우선순위큐 골드 1 */
public class CT_240331 {
    final int MAX_R = 2001;
    final int MAX_PID = 10000001;
    final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int Q, N, M, P, K, S;
    long totalScore = 0;

    int[] pidToIdx = new int[MAX_PID];
    Rabit[] rabitList = new Rabit[MAX_R]; //토끼 리스트
    long[] scoreList = new long[MAX_R]; // 점수표.

    class Rabit implements Comparable<Rabit> {
        int i, pid, r, c, d, cnt; // cnt = 점프 횟수
        Rabit(int i, int pid, int r, int c, int d, int cnt) {
            this.i = i;
            this.pid = pid;
            this.r = r;
            this.c = c;
            this.d = d;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Rabit o) {
            if (this.cnt != o.cnt) return this.cnt - o.cnt;
            if (this.r + this.c != o.r + o.c) return (this.r+this.c) - (o.r+o.c);
            if (this.r != o.r) return this.r - o.r;
            if (this.c != o.c) return this.c - o.c;
            return this.pid - o.pid;
        }

    }

    private boolean isRange(int r, int c) {
        return (r >= 1 && c >= 1 && r <= N && c <= N);
    }

    private int nxtRC(int dir, int x, int d) {
        //x를 dir방향으로 d만큼 이동.
        if (dir == UP) {
            if (x - d >= 1) return x - d;

            d -= (x - 1);
            int div = d / (N-1);
            if (div % 2 == 0) {
                //짝수면 자리 그대로.
                d %= (N-1);
                x = 1 + d;
            } else {
                d %= (N-1);
                x = N - d;
            }


        } else if (dir == DOWN) {
            if (x + d <= N) return x + d;

            d -= (N - x);
            int div = d / (N-1);
            if (div % 2 == 0) {
                //짝수면 자리 그대로.
                d %= (N-1);
                x = N - d;
            } else {
                d %= (N-1);
                x = 1 + d;
            }


        } else if (dir == LEFT) {
            if (x - d >= 1) return x - d;

            d -= (x-1);
            int div = d / (M-1);
            if (div % 2 == 0) {
                //짝수면 자리 그대로.
                d %= (M-1);
                x = 1 + d;
            } else {
                d %= (M-1);
                x = M - d;
            }

        } else if (dir == RIGHT) {
            if (x + d <= M) return x + d;

            d -= (M - x);
            int div = d / (M-1);
            if (div % 2 == 0) {
                //짝수면 자리 그대로.
                d %= (M-1);
                x = M - d;
            } else {
                d %= (M-1);
                x = 1 + d;
            }

        }
        return x;
    }

    private void run() {

        boolean[] vis = new boolean[MAX_R];

        Comparator<int[]> comparator = (o1, o2) ->
        {
            if (o1[0] + o1[1] != o2[0] + o2[1]) return (o2[0] + o2[1]) - (o1[0] + o1[1]);
            if (o1[0] != o2[0]) return o2[0] - o1[0];
            return o2[1] - o1[1];
        };

        Comparator<Rabit> comparator2 = (o1, o2) ->
        {
            if (o1.r + o1.c != o2.r + o2.c) return (o2.r + o2.c) - (o1.r + o1.c);
            if (o1.r != o2.r) return o2.r - o1.r;
            if (o1.c != o2.c) return o2.c - o1.c;
            return o2.pid - o1.pid;
        };

        PriorityQueue<Rabit> pq = new PriorityQueue<>();
        for (int i = 1; i <= P; i++) {
            pq.add(rabitList[i]);
        }

        // 경주 진행.
        // System.out.println();
        for (int k = 0; k < K; k++) {
            Rabit rabit = pq.poll();

            int pid = rabit.pid;
            int r = rabit.r;
            int c = rabit.c;
            int d = rabit.d;
            int i = rabit.i;
            int cnt = rabit.cnt + 1;

            // System.out.println(String.format("\n%d차례 : %d(%d)번 토끼 뽑힙", k, i, pid));

            vis[i] = true;
            PriorityQueue<int[]> locPq = new PriorityQueue<>(comparator);
            for (int dir = 0; dir < 4; dir++) {
                int nr = r;
                int nc = c;

                if (dir == UP || dir == DOWN) {
                    nr = nxtRC(dir, nr, d);
                } else {
                    nc = nxtRC(dir, nc, d);
                }
                // System.out.print(String.format("%d(%d, %d) -> ", dir, nr, nc));
                locPq.add(new int[]{nr, nc});
            }

            int[] rc = locPq.poll();
            totalScore += (rc[0] + rc[1]);
            scoreList[i] -= (rc[0] + rc[1]);
            // System.out.println(String.format("%d(%d)번 토끼 (%d, %d) 이동", i, pid, rc[0], rc[1]));

            rabitList[i] = new Rabit(i, pid, rc[0], rc[1], d, cnt);
            pq.add(rabitList[i]);
        }

        pq = new PriorityQueue<>(comparator2);
        for (int i = 1; i <= P; i++) {
            pq.add(rabitList[i]);
        }

        Rabit highR = pq.poll();
        while (!vis[highR.i]) {
            highR = pq.poll();
        }
        // System.out.println(String.format("%d(%d)번 토끼 %d점 획득", highR.i, highR.pid, S));
        scoreList[highR.i] += S;

    }

    private void changeD(int pid, int L) {
        Rabit r = rabitList[pidToIdx[pid]];
        r.d *= L;
    }

    private void solve() throws Exception {
        StringTokenizer st = input(br);
        Q = Integer.parseInt(st.nextToken());

        for (int q = 0; q < Q; q++) {
            st = input(br);
            int num = Integer.parseInt(st.nextToken());
            if (num == 100) {
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                P = Integer.parseInt(st.nextToken());

                for (int p = 1; p <= P; p++) {
                    int pid = Integer.parseInt(st.nextToken());
                    int d = Integer.parseInt(st.nextToken());

                    rabitList[p] = new Rabit(p, pid, 1, 1, d, 0);
                    pidToIdx[pid] = p;
                }
            } else if (num == 200) {
                K = Integer.parseInt(st.nextToken());
                S = Integer.parseInt(st.nextToken());
                run();
            } else if (num == 300) {
                int pid_t = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                changeD(pid_t, L);
            } else if (num == 400) {
                long max = Integer.MIN_VALUE;
                for (int i = 1; i <= P; i++) {
                    max = Math.max(max, scoreList[i]);
                }
                totalScore += max;
                System.out.println(totalScore);

            }
        }


    }

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
//        Main m = new Main();
        CT_240331 m = new CT_240331();
        m.solve();
    }

    private StringTokenizer input(BufferedReader br) throws Exception {
        return new StringTokenizer(br.readLine(), " ");
    }
}
