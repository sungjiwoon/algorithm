package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 250201 키순서 플로이드 워샬
public class B_2458 {
    int n, m;
    int[][] arr;
    final int INF = 500*500*500;


    void solve() {

        // 모든 그래프가 이어져있는 정점은, 들어온 정점의 갯수 및 나가는 정점의 수로 알 수 있다.
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        System.out.println(i +","+ +k+","+j+": " + arr[i][j]);
                    }
                }
            }
        }


        int res = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                System.out.print(String.format("%9d", arr[i][j]) + " ");
                if (i == j) continue;
                if (arr[i][j] < INF || arr[j][i] < INF) {
                    cnt++;
                }
            }
            System.out.println();
            if (cnt == n-1) res++;
        }
        System.out.println(res);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = INF;
                }
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a][b] = 1;
            }

            solve();
        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_2458 b = new B_2458();
        b.init();

    }
}
