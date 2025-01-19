package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_10703 {
    final int MAX_N = 3001;
    int r, s;
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    char[][] map = new char[MAX_N][MAX_N];

    public void solve() throws Exception {
        input();

        // 모든 유성은 한칸씩 밑으로 하강.
        // 밑에 땅이 1개라도 도달시, 멈춤

        char[][] newMap = new char[r][s];

        // 땅을 기준으로 가장 가까운 유성을 찾아야 함




    }

    void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        r = Integer.parseInt(sp[0]);
        s = Integer.parseInt(sp[1]);

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

    }

    public static void main(String[] args) throws Exception {
        B_10703 b = new B_10703();
        b.solve();
    }
}
