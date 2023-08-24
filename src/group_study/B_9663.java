package group_study;

import java.util.Scanner;

public class B_9663 {
    static int n;
    static int sum = 0;
    private static void solve(int num, int[] locate) {
        if (num > n) {
            sum++;
            return;
        }

        for (int j = 1; j <= n; j++) {
            locate[num] = j;
            //num이 놓을 위치 j가 적절한 위치인지 판단.
            if (!is_n_queen(locate, num)) continue;
            solve(num+1, locate);
        }
    }

    private static boolean is_n_queen(int[] locate, int num) {
        //num이 놓은 위치가 n_queen이 적절해질지 검사.

        /*
        queen이 위치하면 가로세로대각선은 위치할 수 없다.
        즉 1 queen의 자리가 4에 놓였다면
        만약 3의 queen은 2, 4, 6에 놓을 수 없다.
        2, 6은 1의위치(3) +- (3-1) 이므로
        Math.abs(locate[3]-locate[1]) = 2이면 놓을 수 없다.
        4는 locate[1]에 놓을 수 없으므로 안된다.
         */

        for (int i = 1; i < num; i++) {
            if (locate[i] == locate[num]) return false;
            if (num-i == Math.abs(locate[num] - locate[i])) return false;
        }

        return true;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        long start = System.currentTimeMillis();

        solve(1, new int[n+1]);

        System.out.println(sum);
        long end = System.currentTimeMillis()-start;
        System.out.println(end); //1000ms -> 1s n=15 : 16346ms -> 16s
    }
}
