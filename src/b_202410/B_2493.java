package b_202410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

/**
 * 스택 - 탑(골5)
 * 2024.10.05
 */
public class B_2493 {
    int n;
    int[] top;

    public void solve() {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int v = 0;
            while (!st.isEmpty()) {
                if (top[st.peek()-1] <= top[i]) {
                    st.pop();
                } else {
                    v = st.peek();
                    break;
                }
            }
            res[i] = v;
            st.push(i+1);
        }

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args) throws Exception {
        B_2493 b = new B_2493();
        b.input();
        b.solve();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        top = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
