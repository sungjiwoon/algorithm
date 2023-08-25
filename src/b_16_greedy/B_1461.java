package b_16_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_1461 {
    static int n, m;
    static ArrayList<Integer> arr_pos, arr_neg;
    public static void main(String[] args) {
        input();
        Collections.sort(arr_pos);
        Collections.sort(arr_neg, Collections.reverseOrder());

        boolean[] vis = new boolean[n];

        //일단 양수 부터
        int sum = 0;
        int j = 0;
        int remain = 0;
        while (j < arr_pos.size()) {
            int tmp = m;
            while (tmp > 0 && j < arr_pos.size()) {
                j++;
                tmp--;
            }
            if (tmp == 0) sum += 2 * arr_pos.get(j-1);
            if (j == arr_pos.size() && tmp > 0) {
                remain = tmp;
                sum += 2 * arr_pos.get(j-1);
            }
        }

        //음수 처리
        j = 0;
        while (j < arr_neg.size()) {
            int tmp = m;
            if (remain > 0) {
                tmp = remain;
                remain = 0;
            }
            while (tmp > 0 && j < arr_neg.size()) {
                j++;
                tmp--;
            }
            if (tmp == 0) sum += -2 * arr_neg.get(j-1);
            if (j == arr_neg.size() && tmp > 0) {
                remain = tmp;
                sum += -2 * arr_neg.get(j-1);
            }
        }

        System.out.println(sum);

    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr_pos = new ArrayList<>();
            arr_neg = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num >= 0) arr_pos.add(num);
                else arr_neg.add(num);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
