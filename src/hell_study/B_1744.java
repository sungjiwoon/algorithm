package hell_study;

import java.util.*;

/** 240223 백준 수 묶기 그리디 */

public class B_1744 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        // 작은 수 대로 정렬 O(NlogN)
        Arrays.sort(input);

        // 음수는 일단 앞에서부터 묶는게 이득 ex. -10 * -9 > -3 * -1
        // 음수가 한개일 경우, 0이 있다면 같이 묶어준다. -1 * 0 > -1 + 0
        // 양수는 뒤에서부터 묶는게 이득 ex. 100 * 9 > 1 * 4
        // 단, 1 같은 경우 곱하는 것보다 더하는 것이 더 낫다. ex. 1 1 1 -> 1 * 1 + 1 < 1 + 1 + 1

        int ans = 0;

        // 음수, 0
        for (int i = 0; i < n && input[i] <= 0; i++) {
            if (i+1 < n && input[i+1] <= 0) {
                ans += (input[i] * input[i+1]);
                i++;
            } else {
                ans += input[i];
            }
        }

        // 양수
        for (int i = n - 1; i >= 0 && input[i] > 0; i--) {
            if (i-1 >= 0 && input[i-1] > 1) {
                ans += (input[i] * input[i-1]);
                i--;
            } else {
                ans += input[i];
            }
        }

        System.out.println(ans);

    }
}
