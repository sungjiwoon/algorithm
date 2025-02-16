package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 250215 스도쿠 골드4
// 어렵다
public class B_2239 {

    int[][] map = new int[9][9];
    boolean[][] width = new boolean[10][10];
    boolean[][] height = new boolean[10][10];
    boolean[][] box = new boolean[10][10];

    List<int[]> zeroList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    private void print(boolean fail) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
    }

    private boolean backTracking(int depth) {
        if (depth == zeroList.size()) {
            return true;
        }

        int[] var = zeroList.get(depth);
        int i = var[0], j = var[1];
        int boxIdx = i/3 * 3 + j/3;
        for (int num = 1; num <= 9; num++) {
            if (!width[i][num] && !height[j][num] && !box[boxIdx][num]) {
                width[i][num] = true;
                height[j][num] = true;
                box[boxIdx][num] = true;
                boolean check = backTracking(depth+1);
                if (check) {
                    map[i][j] = num;
                    return true;
                } else {
                    width[i][num] = false;
                    height[j][num] = false;
                    box[boxIdx][num] = false;
                }
            }
        }
        return false;
    }

    private void solve() {

        zeroList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (map[i][j] != 0) {
                    int var = map[i][j];
                    int boxIdx = i/3 * 3 + j/3;

                    // 문제가 잘못됐을 수도 있음
                    if (width[i][var] || height[j][var] || box[boxIdx][var]) {
                        print(false);
                        return;
                    }

                    width[i][var] = true;
                    height[j][var] = true;
                    box[boxIdx][var] = true;
                } else if (map[i][j] == 0) {
                    zeroList.add(new int[] {i, j});
                }
            }
        }
        print(backTracking(0));
    }

    protected void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            for (int i = 0; i < 9; i++) {
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            solve();

            System.out.println(sb);
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2239 b = new B_2239();
        b.init();
    }
}
