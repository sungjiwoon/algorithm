package b_16_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_1461 {
    static int n, m;
    static ArrayList<Integer> arr_pos, arr_neg;
    public static void main(String[] args) {
        input();

        Collections.sort(arr_pos);
        Collections.sort(arr_neg, Collections.reverseOrder());

        //멀리 떨어진 순서대로 m개씩 묶되,
        //그 중 가장 멀리 떨어진 것이 +1배.
        //음수 , 양수 따로 나눠서 생각해야한다.

        PriorityQueue<Integer> qu = new PriorityQueue<>();

        for (int i = arr_pos.size()-1; i >= 0; i-=m) {
            qu.add(arr_pos.get(i));
            System.out.println(arr_pos.get(i));
        }

        for (int i = arr_neg.size()-1; i >= 0; i-=m) {
            qu.add(Math.abs(arr_neg.get(i)));
            System.out.println(arr_neg.get(i));
        }

        int res = 0;
        while(qu.size() != 1) {
            res += qu.poll()*2;
        }
        res += qu.poll();

        System.out.println("res= " + res);


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
