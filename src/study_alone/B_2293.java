package study_alone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2293 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }



        /*
        10 => 1*10,
        1,2,5 로 만들 수 있는 조합 -> 1,2,5,12,15,25,125 (7)
        1 -> 1 (1)
        2 -> 11 , 2 (2)
        3 -> 111, 12 (2)
        4 -> 1111, 112, 22 (3) /  4는 2와 나눠지니까, dp[i-1] + 1;
        5 -> 11111,1112,122,5 (4) 5는 5와 나눠지니까, dp[i-1] + 1
        6 -> 111111, 11112, 1122, 222, 15 (5) -> 6은 2와 나눠지니까, dp[i-1]+1
        7 -> 1111111, 111112,11122,1222,115,25 (6) -> 7은 2+5 와 나눠지니까 dp[i-1]+1
        8 ->

         */

    }
}
