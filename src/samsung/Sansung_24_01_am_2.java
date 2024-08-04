package samsung;


import java.io.*;
import java.util.*;

/*

코드트리 투어 (24년 상반기 오전 2번)
https://www.codetree.ai/training-field/frequent-problems/problems/codetree-tour/description?page=1&pageSize=5
빡구현
 */
public class Sansung_24_01_am_2 {

    final int MAX_N = 2001;
    final int MAX_M = 10001;
    final int MAX_ID = 30001;
    final int INF = 1000000;

    int Q, n, m;
    int startCity = 0;

    class Goods {
        int idx, rev, dest; // 매출, 도착지

        Goods (int idx, int rev, int dest) {
            this.idx = idx;
            this.rev = rev;
            this.dest = dest;
        }
    }

    int[][] edge = new int[MAX_N][MAX_N];
    boolean[] isSale = new boolean[MAX_ID];
    Goods[] goods = new Goods[MAX_ID];
    int[] costs = new int[MAX_N];

    Queue<Integer> idxQ = new LinkedList<>();
    PriorityQueue<Goods> sortingPQ;

    public void measure() {
        // o1[0] - 정점, o1[1] - 거리
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        Arrays.fill(costs, INF);
        costs[startCity] = edge[startCity][startCity];
        pq.add(new int[]{startCity, costs[startCity]});
        boolean[] vis = new boolean[n];

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int nx = tmp[0], nc = tmp[1];
            if (costs[nx] != nc) continue; // 이미 갱신된 값이므로 continue;
            vis[nx] = true;

            for (int i = 0; i < n; i++) {
                if (edge[nx][i] < INF && !vis[i]) { //간선에 연결됐단 의미임.
                    if (costs[i] > nc + edge[nx][i]) {
                        int cost = nc + edge[nx][i];
                        costs[i] = cost;
                        int[] tmp2 = new int[]{i, cost};
                        pq.add(tmp2);
                    }
                }
            }
        }

//            System.out.println("[costs(" + startCity + ")]");
//            for (int i = 0; i < n; i++) {
//                System.out.print(costs[i] + " ");
//            }
//            System.out.println();

    }


    public void init(StringTokenizer st) {
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i< n; i++) {
            for (int j = 0; j < n; j++) {
                edge[i][j] = INF;
            }
            edge[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (edge[v][u] > w ) {
                edge[v][u] = edge[u][v] = w;
            }
        }

        measure();
        initQ();
    }

    public void initQ() {
        sortingPQ = new PriorityQueue<>((o1, o2) -> {
            int v1 = o1.rev - costs[o1.dest];
            int v2 = o2.rev - costs[o2.dest];

            if (v1 == v2) {
                return o1.idx - o2.idx;
            }
            return v2-v1;
        });
    }

    public void create(StringTokenizer st) {
        int idx = Integer.parseInt(st.nextToken());
        int rev = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        goods[idx] = new Goods(idx, rev, dest);
        isSale[idx] = true;
        idxQ.add(idx);
        if (rev >= costs[dest]) sortingPQ.add(new Goods(idx, rev, dest));

//        System.out.println(String.format("200 isSale[%d] = ture", idx));
    }

    public void remove(StringTokenizer st) {
        int idx = Integer.parseInt(st.nextToken());
        isSale[idx] = false;
        goods[idx] = null;
//        System.out.println(String.format("300 isSale[%d] = false", idx));
    }

    public void ready() {
        // 기준 1) 최단거리(costs[dest], idx)
        initQ();

        Queue<Integer> newIdxQ = new LinkedList<>();

        while (!idxQ.isEmpty()) {
            int idx = idxQ.poll();
            if (!isSale[idx]) continue;
            int rev = goods[idx].rev, dest = goods[idx].dest;
            if (rev >= costs[dest]) sortingPQ.add(new Goods(idx, rev, dest));
            newIdxQ.add(idx);

        }
        idxQ = newIdxQ;
    }

    public void sale() {
//        System.out.println("400 call");
        //cost[id] = 현재 여행상품의 출발지 - 도착지까지의 최단거리
        int best = -1, bestCost = -1;

        // 판매 순위 가장 높은 거 get

        if (sortingPQ.isEmpty()) {
            System.out.println(best);
            return;
        }

        Queue<Goods> readyQ = new LinkedList<>();

        while (!sortingPQ.isEmpty()) {
            Goods goods = sortingPQ.poll();
            int idx = goods.idx, rev = goods.rev, dest = goods.dest;
            int cost = costs[dest];
//            System.out.println(String.format("goods idx: %d, rev : %d, cost: %d, dest: %d", idx, rev, cost, dest));
            if (!isSale[idx]) continue;
            if (cost == INF || cost > rev) {
                readyQ.add(goods);
                continue;
            }
//            System.out.println(String.format("goods idx !!!!!: %d, cost: %d, dest: %d", idx, cost, dest));
            best = idx;
            bestCost = cost;
            break;
        }

        while (!readyQ.isEmpty()) {
            sortingPQ.add(readyQ.poll());
        }

        if (best != -1) {
            isSale[best] = false;
            goods[best] = null;
//            System.out.println(String.format("isSale[%d] = false", best));
        }
        System.out.println(best);
    }


    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
//        Main m = new Main();
        Sansung_24_01_am_2 m = new Sansung_24_01_am_2();
        m.call();
    }

    public void call() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Q = Integer.parseInt(br.readLine());

        for (int q = 0; q < Q; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());

            if (c == 100) {
                init(st);
            } else if (c == 200) {
                create(st);
            } else if (c == 300) {
                remove(st);
            } else if (c == 400) {
                sale();
            } else if (c == 500) {
                startCity = Integer.parseInt(st.nextToken());
                measure();
                ready();
            }

        }

    }
}
