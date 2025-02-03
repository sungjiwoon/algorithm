package b_202502;

import java.io.*;
import java.util.*;

// 250202 탑 보기 골드 3 스택
public class B_22866 {
    int n;
    int[] buildings;

    private void solve() {
        Stack<Integer> st = new Stack<>();
        int[] cnt = new int[n];
        int[] min = new int[n];
        Arrays.fill(min, n+1);

        // L <- R
        st.push(0);
        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && buildings[st.peek()] <= buildings[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                min[i] = st.peek();
            }
            cnt[i] += st.size();
            st.push(i);
        }

        st.clear();
        // R <- L
        st.push(n-1);
        for (int i = n-2; i>= 0; i--) {
            while (!st.isEmpty() && buildings[st.peek()] <= buildings[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                if (min[i] == n+1) min[i] = st.peek();
                else if (st.peek()-i < i-min[i]) min[i] = st.peek();
            }
            cnt[i] += st.size();
            st.push(i);
        }


        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0) {
                System.out.println(cnt[i]);
            } else {
                System.out.println(cnt[i] + " " + (min[i]+1));
            }
        }


    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            buildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            solve();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_22866 b = new B_22866();
        b.init();
    }
}
