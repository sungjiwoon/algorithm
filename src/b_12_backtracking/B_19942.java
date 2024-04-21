package b_12_backtracking;

import java.io.*;
import java.util.*;

/** 240421 백준 다이어트 골드 4, 백트래킹 */
public class B_19942 {
    final int N = 16;
    int n, mp, mf, ms, mu;
    int[][] map = new int[N][5];
    Ingredients minIg;

    class Ingredients implements Comparable<Ingredients> {
        int cost;
        List<Integer> idxList;
        int sumMp, sumMf, sumMs, sumMu;

        public Ingredients() {
            this.cost = 0;
            this.idxList = new ArrayList<>();
            this.sumMp = 0;
            this.sumMf = 0;
            this.sumMs = 0;
            this.sumMu = 0;
        }

        public void add(int idx) {
            this.idxList.add(idx);
            this.sumMp += map[idx][0];
            this.sumMf += map[idx][1];
            this.sumMs += map[idx][2];
            this.sumMu += map[idx][3];
            this.cost += map[idx][4];
        }

        public void remove(int idx) {
            this.idxList.remove(idxList.indexOf(idx));
            this.sumMp -= map[idx][0];
            this.sumMf -= map[idx][1];
            this.sumMs -= map[idx][2];
            this.sumMu -= map[idx][3];
            this.cost -= map[idx][4];
        }

        public boolean isOk() {
            return sumMp >= mp && sumMu >= mu && sumMs >= ms && sumMf >= mf;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("cost : " + this.cost + "\n");
            for (int idx : idxList) {
                sb.append(idx + " ");
            }
            return sb.toString();
        }

        @Override
        public int compareTo(Ingredients o) {
            if (this.cost != o.cost) return this.cost - o.cost;
            for (int i = 0; i < this.idxList.size() || i < o.idxList.size(); i++) {
                int a = this.idxList.get(i), b = o.idxList.get(i);
                if (a != b) return a - b;
            }
            return 0;
        }
    }

    public Ingredients copy(Ingredients ig) {
        Ingredients newI = new Ingredients();
        for (int idx : ig.idxList) {
            newI.add(idx);
        }
        newI.sumMs = ig.sumMs;
        newI.sumMf = ig.sumMf;
        newI.sumMp = ig.sumMp;
        newI.sumMu = ig.sumMu;
        return newI;
    }

    public void compare(Ingredients ig) {
        if (minIg == null) {
//            System.out.println(String.format("MinIG!! %s", ig.toString()));
            minIg = copy(ig);
            return;
        }

        if (minIg.cost != ig.cost) {
            if (ig.cost < minIg.cost) {
//                System.out.println("Now MingIg " + minIg.toString());
//                System.out.println(String.format("MinIG!! %s", ig.toString()));
                minIg = copy(ig);
                return;
            }
        }

        for (int i = 0; i < minIg.idxList.size() && i < ig.idxList.size(); i++) {
            int a = minIg.idxList.get(i), b = ig.idxList.get(i);
            if (a > b) {
//                System.out.println("Now MingIg " + minIg.toString());
//                System.out.println(String.format("MinIG!! %s", ig.toString()));
                minIg = copy(ig);
                return;
            } else if (a < b) return;

        }

    }

    public void backtracking(int idx, Ingredients ig) {
        if (ig.isOk()) {
            compare(ig);
            return;
        }

        if (idx > n) return;

        for (int i = idx + 1; i <= n; i++) {
            ig.add(i);
            backtracking(i, ig);
            ig.remove(i);
        }
    }
    public void solve() {
        backtracking(0, new Ingredients());
        if (minIg == null) {
            System.out.println("-1");
            return;
        }

        System.out.println(minIg.cost);
        for (int idx : minIg.idxList) {
            System.out.print(idx + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        B_19942 m = new B_19942();
        m.init();
        m.solve();
    }

    public void init() throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mu = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
            map[i][3] = Integer.parseInt(st.nextToken());
            map[i][4] = Integer.parseInt(st.nextToken());
        }

    }
}
