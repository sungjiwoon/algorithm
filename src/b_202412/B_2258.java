package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 240126 정육점 그리디 */
public class B_2258 {
    int n, m;
    int[][] meats;

    void solve() {

        Arrays.sort(meats, (o1, o2) -> {
            if (o1[1] != o2[1]) return o1[1]-o2[1];
            return o2[0]-o1[0];
        });

        int sum = 0; // 무게
        int price = -1; // 현재 더해진 가격
        int samePrice = -1;
        int finalPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            sum += meats[i][0];
            //System.out.println(i+": " + sum +" price: " + price);
            if (samePrice != meats[i][1]) {
                price = meats[i][1];
                samePrice = meats[i][1];
            } else {
                price += meats[i][1]; // 같은 가격임
            }

            if (sum >= m) {
                finalPrice = Math.min(price, finalPrice);
            }
        }
        if (sum < m) finalPrice = -1;
        System.out.println(finalPrice);
    }


    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = tmp[0];
            m = tmp[1];

            meats = new int[n][2];
            for (int i = 0; i < n; i++) {
                meats[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            solve();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2258 b = new B_2258();
        b.init();
    }
}
