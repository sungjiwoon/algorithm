package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 250127 지뢰찾기 https://www.acmicpc.net/problem/2140
public class B_2140 {
    int n;
    char[][] map = new char[101][101];
    int[][] bombMap = new int[101][101]; // 0 -> 모름, 1 -> 지뢰, -1 -> 지뢰 아님
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    void solve() {

        int res = 0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (map[i][j] == '#') {
                    bombMap[i][j] = 9;
                }
            }
        }

        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < n-1; j++) {
                boolean canBomb = true;
                for (int k = 0; k < 8; k++) {
                    int ni = i + dx[k], nj = j + dy[k];
                    if (ni<0 || nj<0 || ni>=n || nj >= n) continue;
                    if (map[ni][nj] == '0') {
                        canBomb = false;
                        break; // 지뢰가 들어올 수 없는 위치
                    }
                }

                if (canBomb) {
                    // 8면의 숫자를 전부 1씩 감수시킨다. (확신의 지뢰이니까)
                    for (int k = 0; k < 8; k++) {
                        int ni = i + dx[k], nj = j + dy[k];
                        if (ni<0 || nj<0 || ni>=n || nj >= n) continue;
                        map[ni][nj]--;
                    }
                    res++;
                }
            }
        }


        System.out.println(res);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                map[i] = br.readLine().toCharArray();
            }
            solve();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2140 b = new B_2140();
        b.init();
    }
}
