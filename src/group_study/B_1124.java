package group_study;

import java.io.*;
import java.util.*;

public class B_1124 {
    static int a,b;
    static boolean[] prime_nums = new boolean[100001];
    static ArrayList<Integer> prime_nums_list = new ArrayList<>();
    static int cnt = 0; //언더프라임 수
    private static void count_prime_num() {
        prime_nums[2] = prime_nums[3] = true;
        prime_nums_list.add(2);
        prime_nums_list.add(3);

        for (int i = 4; i <= b ; i++) {
            boolean is_prime = true;
            for (int j = 2; j <= Math.sqrt(i)+1; j++) {
                if (i % j == 0) {
                    is_prime= false;
                    break;
                }
            }
            if (is_prime) {
                prime_nums[i] = true;
                prime_nums_list.add(i);
            }
        }
    }

    private static void solve() {
        for (int i = a; i <= b; i++) {
            if (prime_nums[i]) continue; //소수면 언더프라임이 아니다.

            //실행 속도를 줄이기 위해, 2(소수) 나눠지면, 소수임을 판단하도록함.
            //굳이 필요없는 조건문임!, 없으면 448ms, 있으면 338ms
            if (i % 2 == 0 && prime_nums[i/2]) {
                cnt++;
                continue;
            }

            ArrayList<Integer> div = new ArrayList<>();
            int tmp = i; //그냥 i로만 계산해주면 i는 1에 머물러있어서 무한루프에 빠짐
            int j = 0;
            while (tmp > 1) {
                int p = prime_nums_list.get(j);
                while (tmp % p == 0) { //8-> 2*2*2 이므로, 2로 계속 나눠줘야하므로 while 문 돌려줘야함.
                    div.add(p); //소인수분해한 값들만 담김.
                    tmp /= p;
                }
                j++;
            }

            if (prime_nums[div.size()]) { //소인수분해한 값들만 담긴 리스트의 길이가 소수인지 아닌지 판별
                cnt++;
            }

        }
    }
    public static void main(String[] args) throws IOException {
        input();
        count_prime_num();
        solve();
        System.out.println(cnt);
        /*

        매번 소인수분해를 해주기 위해 소수를 계산하는 것보다, 미리 b까지 자연수 중에서 소수를 구해놓고,
        계산하는게 더 빠르므로 count_prime_num() 에서 소수를 미리 계산해주었다.
        boolean[] prime_nums : i가 소수이면 true
        ArrayList prime_nums_list : 소수만 담겨있는 리스트

        solve() : 언더프라임 갯수 카운트
         */
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }
}
