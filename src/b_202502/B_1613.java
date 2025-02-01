package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 250201 역사
public class B_1613 {
    int n, k;
    int[][] front, back;
    final int INF = 400*400*400;


    void solve() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (front[i][k] + front[k][j] < front[i][j]) {
                        front[i][j] = front[i][k] + front[k][j];
                    }
                    if (back[i][k] + back[k][j] < back[i][j]) {
                        back[i][j] = back[i][k] + back[k][j];
                    }
                }
            }
        }

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer token = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(token.nextToken());
            k = Integer.parseInt(token.nextToken());

            front = new int[n+1][n+1];
            back = new int[n+1][n+1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    front[i][j] = INF;
                    back[i][j] = INF;
                }
            }

            for (int i = 0; i < k; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                front[a][b] = 1;
                back[b][a] = 1;
            }

            solve();

            int s = Integer.parseInt(br.readLine());
            for (int i = 0; i < s; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(token.nextToken());
                int b = Integer.parseInt(token.nextToken());
                if (front[a][b] < INF) {
                    System.out.println("-1");
                } else if (back[a][b] < INF) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            }
        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_1613 b = new B_1613();
        b.init();

    }
}
