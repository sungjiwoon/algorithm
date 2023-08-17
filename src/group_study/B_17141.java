package group_study;

import java.io.*;
import java.util.*;

public class B_17141 {
    static int n,m;
    static int[][] map;
    static PriorityQueue<Integer> res;
    static ArrayList<Pair> virus;
    static class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static void backtracking(int depth, int st, int[] arr, boolean[] vis) {
        /*
        만들어진 조합을 virus_list에 담아서 bfs로 보내는 역할
         */
        if (depth == m) {
            ArrayList<Integer> virus_list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                virus_list.add(arr[i]);
            }
            bfs(virus_list);
            return;
        }

        for (int i = st; i < virus.size(); i++) {
            if (!vis[i]) {
                vis[i] = true;
                arr[depth] = i;
                backtracking(depth+1, i+1, arr, vis);
                vis[i] = false;
            }
        }
    }
    private static void bfs(ArrayList<Integer> virus_list) {

        /*
        d[][] : 거리 배열, 초기화는 -1, 바이러스 시작점은 0
        add_max_value 메소드 : d 배열에서 최댓값을 찾아줌. 최댓값 : 바이러스가 퍼졌던 최장 시간

         */
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};

        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i],-1);
        }

        Queue<Pair> qu = new LinkedList<>();
        for (int v : virus_list) {
            Pair pv = virus.get(v);
            qu.add(pv);
            d[pv.x][pv.y] = 0;
        }

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            for (int k = 0; k < 4; k++) {
                int xx = p.x + dx[k];
                int yy = p.y + dy[k];
                if (xx < 0 || xx >= n || yy < 0 || yy >= n || map[xx][yy] == 1) continue;
                if (d[xx][yy] == -1) {
                    d[xx][yy] = d[p.x][p.y] + 1;
                    qu.add(new Pair(xx, yy));
                }
            }
        }

        add_max_value(d);

    }
    private static void add_max_value(int[][] d) {
        int max = -1;
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) continue;
                if (d[i][j] == -1) {
                    ok = false;
                    break;
                }
                max = Math.max(d[i][j], max);
            }
            if (!ok) break;
        }
        if (!ok) {
            res.add(Integer.MAX_VALUE);
        } else {
            res.add(max);
        }
    }


    public static void main(String[] args) throws IOException {
        input();
        backtracking(0,0,new int[m], new boolean[virus.size()]);
        if (res.peek() == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res.poll());
        }

        /*

        바이러스가 많은 곳에 뿌려져 있지만, m개 밖에 터뜨리지 못하므로,
        백트래킹을 이용하여 바이러스을 터뜨릴 수 있는 조합을 모두 구해 bfs를 돌렸다.
        Pair 클래스 : 2차원 배열이므로, (x,y) 좌표를 나타내는 클래스
        virus : 바이러스들 있는 위치를 모두 담는 리스트
        PriorityQueue res : 각 조합마다 최대 수를 담는 우선순위 큐, 단 바이러스가 모두 퍼지지 않았을 경우 Integer.MAX_VALUE을 넣어줌.

         */

    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = new PriorityQueue<>();

        virus = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 2) {
                    virus.add(new Pair(i,j));
                }
            }
        }

    }
}
