package hell_study;

import java.io.*;
import java.util.*;
/** 240320 백준 1041 주사위 그리디, Long 처리 */
public class B_1041 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Integer.parseInt(br.readLine());
        int[] dice = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (n == 1L) {
            Arrays.sort(dice);
            long res = Arrays.stream(dice).sum() - dice[5];
            System.out.println(res);
            return;
        }

        long sum3 = Math.min(dice[0], dice[5]) + Math.min(dice[1], dice[4]) + Math.min(dice[2], dice[3]); // 3면 중 최솟값
        long sum2 = Integer.MAX_VALUE; //2면의 합 최솟값 -> 마주보는 것만 아니라면 전부 붙어 있으므로 최솟값 찾으면 된다.
        long sum1 = Integer.MAX_VALUE; //1면 중 최솟값
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                if (i + j != 5) {
                    sum2 = Math.min(dice[i] + dice[j], sum2);
                }
            }
            sum1 = Math.min(sum1, dice[i]);
        }


        long res = 0;
        long corner = 4L;
        long midCorner = (n-2) * corner;
        long midSquare = (n-2) * (n-2);

        //맨 윗층 = 4면의 모서리(3면)의 합 + 중간 모서리(2면)의 합 [(n-2) * 4] + 가운데(1면) 합
        res += (corner * sum3);
        res += (midCorner * sum2);
        res += (midSquare * sum1);
        //중간 ~ 맨밑 층 = [ 모서리(2면)의 합 + 중간 모서리 (1면)의 합 ] * (n-1층)
        res += (corner * sum2 * (n-1));
        res += (midCorner * (n-1) * sum1);

        System.out.println(res);



    }
}
