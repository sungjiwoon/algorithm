package b_23_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B_1043_2 {
    static int n,m;
    static ArrayList<Integer>[] graph, party;
    static LinkedList<Integer> lie;
    static boolean[] liar;
    public void work() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        reset(new StringTokenizer(br.readLine(), " ")); //n,m, graph, party, liar, lie reset
        add_liar(new StringTokenizer(br.readLine(), " ")); //거짓말 아는 사람들 처리.

        for (int i = 0; i < m; i++) {
            make_graph(new StringTokenizer(br.readLine(), " "), i); //그래프 만들어주는 메소드
        }

        /* 초기화 및 그래프 작업 끝 */
        int ans = solve();
        System.out.println(ans);
    }
    private static void reset(StringTokenizer st) {
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<Integer>();

        party = new ArrayList[m];
        liar = new boolean[n+1];
        lie = new LinkedList<>();
    }
    private static void add_liar(StringTokenizer st) {
        int k = Integer.parseInt(st.nextToken()); //진실 아는 사람의 수.
        while (k-- > 0) {
            int kk = Integer.parseInt(st.nextToken());
            liar[kk] = true; //liar[i] = true; -> i는 거짓말인걸 아는 사람.
            lie.offer(kk); //거짓말 아는 사람 모아놓은 큐
        }
    }
    private static void make_graph(StringTokenizer st, int i) {
        party[i] = new ArrayList<>();
        int member = Integer.parseInt(st.nextToken()); //파티에 오는 수.

        int p = Integer.parseInt(st.nextToken()); //기준.
        party[i].add(p);

        while (member-- > 1) { //파티 맴버들
            int q = Integer.parseInt(st.nextToken());
            party[i].add(q);
            graph[p].add(q); //p를 기준으로 파티에 온 모든 인원들이 그래프처럼 이어짐.
            graph[q].add(p);
        }
    }
    private static int solve() {
        boolean[] vis = new boolean[n+1]; //무한반복을 피하기위한 방법.
        while (!lie.isEmpty()) {
            int p = lie.poll(); // 거짓말인걸 아는 사람.
            if (vis[p]) continue;
            for (int q : graph[p]) {
                liar[q] = true;
                if (!vis[q]) lie.offer(q); // 거짓말 아는 사람 추가!
            }
            vis[p] = true; // 더이상 방문하지 않도록 방문표시
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean ok = true;
            for (int p : party[i]) {
                if (liar[p]) { //거짓말을 아는 사람이 있다면, 파티에 포함 x
                    ok = false;
                    break;
                }
            }
            if (ok) ans++;
        }

        return ans;
    }

}
