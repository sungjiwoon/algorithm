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
