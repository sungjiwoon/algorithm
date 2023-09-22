package study_alone;
import java.util.*;
import java.io.*;

/*
uppper Bound, Lower Bound 문제.. 너무 어렵다ㅜ

랜선 자르기 성공

시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	188820	44382	30059	21.248%
문제
집에서 시간을 보내던 오영식은 박성원의 부름을 받고 급히 달려왔다.
박성원이 캠프 때 쓸 N개의 랜선을 만들어야 하는데 너무 바빠서 영식이에게 도움을 청했다.

이미 오영식은 자체적으로 K개의 랜선을 가지고 있다. 그러나 K개의 랜선은 길이가 제각각이다.
박성원은 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다.
예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm는 버려야 한다. (이미 자른 랜선은 붙일 수 없다.)

편의를 위해 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며,
기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자.
그리고 자를 때는 항상 센티미터 단위로 정수길이만큼 자른다고 가정하자.
N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다. 이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.
 */
public class B_1654 {
    static int n,k;
    static int[] nums;

    public static long Count(long k, int[] nums){
        int cnt = 0;
        for(int x : nums){
            cnt += (x / k);
        }
        return cnt;
    }

    private static long solve() {

        long answer = 0;
        long left = 1;
        long right = 0;
        for(int x : nums) right = Math.max(right, x);

        while(left <= right){
            long mid = (left + right) / 2;
            if(Count(mid, nums) >= n){
                answer = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return answer;

    }

    public static void main(String[] args) {
        input();
        System.out.println(solve());

    }
    private static void input() {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            k = Integer.parseInt(sp[0]);
            n = Integer.parseInt(sp[1]);
            nums = new int[k];
            for (int i = 0; i < k; i++) {
                nums[i] = Integer.parseInt(br.readLine());
            }
        }catch (Exception e) {}
    }
}
