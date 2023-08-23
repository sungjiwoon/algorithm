package group_study;

import java.io.*;
import java.util.*;

public class B_15686 {
    static int[][] d, map;
    static int n,m, res = Integer.MAX_VALUE;
    static ArrayList<Pair> chickens, houses;
    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static void find_min_d(int[] arr) {
        int[] min_d = new int[houses.size()];
        Arrays.fill(min_d, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < houses.size(); j++) {
                min_d[j] = Math.min(d[arr[i]][j], min_d[j]);
            }
        }
        res = Math.min(res, Arrays.stream(min_d).sum());
        return;

    }
    private static void backtracking(int depth, int st, int[] arr, boolean[] vis) {
        if (depth == m) {
            //m갸의 조합 완성.
            find_min_d(arr);
            return;
        }

        for (int i = st; i < chickens.size(); i++) {
            if (!vis[i]) {
                vis[i] = true;
                arr[depth] = i;
                backtracking(depth+1,i+1,arr,vis);
                vis[i] = false;
            }
        }
    }
    private static void solve_d_from_house_to_chicken() {

        d = new int[chickens.size()][houses.size()];
        for (int i = 0; i < chickens.size(); i++) {
            Pair chicken = chickens.get(i);
            for (int j = 0; j < houses.size(); j++) {
                Pair house = houses.get(j);
                //치킨 거리 공식
                int dis = Math.abs(chicken.x-house.x) + Math.abs(chicken.y-house.y);
                d[i][j] = dis;
            }
        }
    }
    private static void locate_places() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == 1) houses.add(new Pair(i,j));
                if (map[i][j] == 2) chickens.add(new Pair(i,j));
            }
        }
    }
    public static void main(String[] args) {
        input();
        //1. 치킨집 및 집 위치 파악
        locate_places();
        //2. 모든 집마다 치킨집 거리 새기.
        solve_d_from_house_to_chicken();
        //3. 백트래킹을 사용하여 모든 치킨집의 M개의 조합 (chickens C m) 구하기.
        //4. 각 조합의 케이스마다 최소 거리 구하고, 배열에 담아, 최솟값 도출.
        backtracking(0,0,new int[m],new boolean[chickens.size()]);

        System.out.println(res);


        /*
        시간 복잡도 ( 최악 n = 50 (집의 갯수 = 237), 치킨집 갯수 : 13,  m = 6 ))
        1) locate_places() : 먼저 모든 집과 치킨집의 위치를 파악하므로 O(n²) 이 걸린다. => O(250)
        2) solve_d_from_house_to_chicken() : O(치킨집의 최대갯수(13)*집의 최대갯수(250-13)) = O(13*237) = O(3081)
        3) backtracking() : 치킨집 최대 갯수 C m -> 13 C 6 = O(1716) : m이 6,7일때 가장 큼
        4) find_min_d() : O(house.size() * 6) = O(237*6) = O(1422)
        각각의 메소드가 움직이는 것이므로 시간 복잡도는 1초를 넘기지 않는다. 최악의 경우에도 1)+2)+3)+4) < 1초


         */

    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            chickens = new ArrayList<>();
            houses = new ArrayList<>();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
