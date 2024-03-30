package study_alone;

import java.io.*;
import java.util.*;

/** 240330 코드트리 루돌프의 반란 골드 2 삼성 하반기 오후 1번 */

public class CT_240330 {
    final int MAX_P = 32;
    final int MAX_N = 52;

    int[][] santaMap = new int[MAX_N][MAX_N];
    int[] santaScore = new int[MAX_P];
    boolean[] santaDie = new boolean[MAX_P];
    int[] santaSleep = new int[MAX_N];

    Pair[] santaLoc = new Pair[MAX_P]; //산타 위치.
    Pair rudolf; // 루돌프 위치.

    int n, m, p, c, d;
    int nowM;

    int[] Rdr = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] Rdc = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] Sdr = {-1, 0, 1, 0};
    int[] Sdc = {0, 1, 0, -1};


    class Pair {
        int r, c;
        Pair (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private boolean isRange(int nr, int nc) {
        return (nr > 0 && nc > 0 && nr <= n && nc <= n);
    }

    private int getD(Pair p1, Pair p2) {
        return (int) Math.pow(p1.r - p2.r, 2) + (int) Math.pow(p1.c - p2.c, 2);
    }

    private int checkNearSanta() {
        int idx = 0;
        int minD = Integer.MAX_VALUE;

        for (int i = 1; i <= p; i++) {
            if (santaDie[i]) continue;
            int iD = getD(rudolf, santaLoc[i]);
            if (iD < minD) {
                minD = iD;
                idx = i;
            } else if (iD == minD) {
                if (santaLoc[idx].r == santaLoc[i].r) {
                    if (santaLoc[i].c > santaLoc[idx].c) {
                        idx = i;
                    }
                } else if (santaLoc[idx].r < santaLoc[i].r) {
                    idx = i;
                }
            }
        }
        return idx;
    }

    private void runToSanta(int idx) {

        int minD = Integer.MAX_VALUE;
        int dir = -1;
        int nr = 0, nc = 0;

        for (int k = 0; k < 8; k++) {
            int rr = rudolf.r + Rdr[k];
            int cc = rudolf.c + Rdc[k];
            int dd = getD(santaLoc[idx], new Pair(rr, cc));
            if (dd < minD) {
                dir = k;
                minD = dd;
                nr = rr;
                nc = cc;
            }
        }

        rudolf = new Pair(nr, nc);
        // System.out.println(String.format("루돌프 위치는 %d번과 가까히, %d방향인 (%d, %d)으로 이동해", idx, dir, nr, nc));

        // 충돌났음.
        if (santaMap[nr][nc] > 0) {
            int cidx = santaMap[nr][nc];
            complictByR(cidx, dir);
            // 기절함.
            santaSleep[cidx] = nowM;
        }


    }

    private void complictByR(int idx, int dir) {
        // 루돌프에 의해 루돌프랑 산타 충돌
        santaScore[idx] += c;
        // System.out.println(String.format("santaScore[%d] = %d", idx, santaScore[idx]));

        // 이동방향 만큼 밀려남.
        int nr = santaLoc[idx].r + (Rdr[dir] * c);
        int nc = santaLoc[idx].c + (Rdc[dir] * c);
        santaMap[santaLoc[idx].r][santaLoc[idx].c] = 0;
        santaLoc[idx] = new Pair(nr, nc);

        if (!isRange(nr, nc)) {
            // 산타 죽음.
            santaDie[idx] = true;
            return;
        }

        int meetIdx = santaMap[nr][nc];
        santaMap[nr][nc] = idx;

        if (meetIdx > 0) {
            // 상호 작용.
            while (true) {
                int nnr = santaLoc[meetIdx].r + Rdr[dir];
                int nnc = santaLoc[meetIdx].c + Rdc[dir];

                santaLoc[meetIdx] = new Pair(nnr, nnc);

                if (!isRange(nnr, nnc)) {
                    santaDie[meetIdx] = true;
                    break;
                }

                int nxtIdx = santaMap[nnr][nnc];
                santaMap[nnr][nnc] = meetIdx;
                if (nxtIdx == 0) break;
                meetIdx = nxtIdx;
            }

        }

    }

    private void complictByC(int idx, int dir) {
        // 루돌프랑 산타 충돌
        santaScore[idx] += d;
        // System.out.println(String.format("santaScore[%d] = %d", idx, santaScore[idx]));
        dir = (dir + 4 - 2) % 4;

        // 이동방향 만큼 밀려남.
        int nr = santaLoc[idx].r + (Sdr[dir] * d);
        int nc = santaLoc[idx].c + (Sdc[dir] * d);

        santaMap[santaLoc[idx].r][santaLoc[idx].c] = 0;
        santaLoc[idx] = new Pair(nr, nc);

        if (!isRange(nr, nc)) {
            // 산타 죽음.
            santaDie[idx] = true;
            return;
        }

        int meetIdx = santaMap[nr][nc];
        santaMap[nr][nc] = idx;
        if (meetIdx > 0) {
            // 상호 작용.
            while (true) {
                int nnr = santaLoc[meetIdx].r + Sdr[dir];
                int nnc = santaLoc[meetIdx].c + Sdc[dir];

                santaLoc[meetIdx] = new Pair(nnr, nnc);

                if (!isRange(nnr, nnc)) {
                    santaDie[meetIdx] = true;
                    break;
                }

                int nxtIdx = santaMap[nnr][nnc];
                santaMap[nnr][nnc] = meetIdx;
                if (nxtIdx == 0) break;
                meetIdx = nxtIdx;
            }

        }
    }


    private void moveSanta() {
        for (int i = 1; i <= p; i++) {
            if (santaDie[i]) continue;
            if (santaSleep[i] > nowM - 2) continue;

            int dir = -1;
            int minD = getD(santaLoc[i], rudolf);
            int nr = 0, nc = 0;
            for (int k = 0; k < 4; k++) {
                int rr = santaLoc[i].r + Sdr[k];
                int cc = santaLoc[i].c + Sdc[k];
                if (!isRange(rr, cc)) continue;
                if (santaMap[rr][cc] > 0) continue;

                int dd = getD(rudolf, new Pair(rr, cc));
                if (minD > dd) {

                    minD = dd;
                    dir = k;
                    nr = rr;
                    nc = cc;
                }

            }
            if (dir == -1) continue;
            // System.out.println(String.format("%d번 산타 (%d, %d)로 이동해", i, nr, nc));
            santaMap[santaLoc[i].r][santaLoc[i].c] = 0;
            santaLoc[i] = new Pair(nr, nc);
            santaMap[nr][nc] = i;

            if (nr == rudolf.r && nc == rudolf.c) {
                // 충돌 & 상호작용.
                // System.out.println(String.format("%d번 산타 루돌프랑 충돌 발생", i));
                complictByC(i, dir);

                // 기절함.
                santaSleep[i] = nowM;
            }

        }
    }


    private void solve() {
        for (int i = 3; i < m + 3; i++) {

            nowM = i;
            // printSantaMap();

            // 1. 루돌프 움직임.
            int runI = checkNearSanta();
            runToSanta(runI);

            // 2. 산타 움직임
            moveSanta();

            // 3. 산타 모두 죽었는지 확인. & 죽지 않는 산타는 +1
            int cnt = 0;
            for (int s = 1; s <= p; s++) {
                if (santaDie[s]) {
                    cnt++;
                    continue;
                }
                santaScore[s]++;
            }

            if (cnt == p) break;
            // printScore();
        }
        printScore();


    }

    private void printScore() {
        // System.out.println("=산타 점수=");
        for (int s = 1; s <= p; s++) {
            System.out.print(santaScore[s] + " ");
        }

    }

    private void printSantaMap() {
        System.out.println("\n\n= " + nowM +"째 산타 맵 =");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(santaMap[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("루돌프 위치 : " + rudolf.r + " " + rudolf.c);
    }


    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        CT_240330 m = new CT_240330();
//        Main m = new Main();
        m.init();
        m.solve();
    }

    private void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int Rr = Integer.parseInt(st.nextToken());
        int Rc = Integer.parseInt(st.nextToken());
        rudolf = new Pair(Rr, Rc);

        for (int i = 1; i <= p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int Si = Integer.parseInt(st.nextToken());
            int Sr = Integer.parseInt(st.nextToken());
            int Sc = Integer.parseInt(st.nextToken());
            santaLoc[Si] = new Pair(Sr, Sc);
            santaMap[Sr][Sc] = Si;
        }

    }
}
