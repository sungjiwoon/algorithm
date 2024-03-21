package hell_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/** 240321 백준 2578 빙고 실버 4 간단 구현 */
public class B_2578 {
    static Map<Integer, int[]> pair = new HashMap<>();
    static boolean[][] checkMap = new boolean[5][5];

    private static boolean verBingo(int x, int y) {
        //가로 확인
        for (int i = 0; i < 5; i++) {
            if (!checkMap[x][i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean horBingo(int x, int y) {
        //세로 확인
        for (int i = 0; i < 5; i++) {
            if (!checkMap[i][y]) {
                return false;
            }
        }
        return true;
    }

    private static boolean diaBingo(int x, int y) {
        if (x != y) return false;
        for (int i = 0; i < 5; i++) {
            if (!checkMap[i][i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean dia2Bingo(int x, int y) {
        if (x != (5-y-1)) return false;
        for (int i = 0; i < 5; i++) {
            if (!checkMap[i][5-i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < 5; j++) {
                pair.put(map[i][j], new int[]{i,j});
            }
        }

        int res = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                int[] xy = pair.get(num);
                int x = xy[0], y = xy[1];
                checkMap[x][y] = true;

                if (verBingo(x, y)) res++;
                if (horBingo(x, y)) res++;
                if (diaBingo(x, y)) res++;
                if (dia2Bingo(x, y)) res++;

                if (res >= 3) {
                    System.out.println((i*5+j));
                    return;
                }

            }
        }

    }
}
