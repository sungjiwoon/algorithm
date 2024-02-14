package hell_study;

import java.io.*;
import java.util.*;
/** 240214 신나는 함수 실행 메모리제이션 */
public class B_9184 {
    private static int[][][] w = new int[51][51][51];
    private static boolean isRange(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return false;
        return true;
    }
    private static int memo(int a, int b, int c) {

        if (isRange(a,b,c) && w[a][b][c] != 0) return w[a][b][c];

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w[a][b][c] = memo(20, 20, 20);
        }

        if (a < b && b < c) {
            return w[a][b][c] = memo(a, b, c-1) + memo(a, b-1, c-1) - memo(a, b-1, c);
        }

        return w[a][b][c] = memo(a-1, b, c) + memo(a-1, b-1, c) + memo(a-1, b, c-1) - memo(a-1, b-1, c-1);

    }


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int[] arr = input(br);
            int a = arr[0], b = arr[1], c = arr[2];
            if (a == -1 && b == -1 && c == -1) break;

            sb.append(String.format("w(%d, %d, %d) = %d\n", a, b, c, memo(a, b, c)));
        }
        System.out.println(sb);
    }
    private static int[] input(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
