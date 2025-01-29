package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 250130 같은 수로 만들기
//1️⃣ stack이 비었다면 push
//
//2️⃣ 새로 입력된 값이 stack의 top보다
//
//👉 크면, 차이 만큼 답에 더해주고, pop 후 새로운 값을 push
//
//👉 작다면, pop 후 새로운 값을 push
//
//👉 입력되는 값 중, 가장 큰 값을 저장해준다.
//
//3️⃣ 입력이 끝나면, stack의 모든 값을 pop해주면서 max 값과의 차이를 더해주면 끄읕🙋‍♀️
public class B_2374 {
    int n;
    long[] a;

    void solve() {
        long sum = 0;
        Stack<Long> stack = new Stack<>();
        stack.push(a[0]);

        long max = a[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, a[i]);
            if (stack.peek() < a[i]) {
                sum += (a[i] - stack.pop());
                stack.push(a[i]);
            } else if (stack.peek() > a[i]) {
                stack.pop();
                stack.push(a[i]);
            }
        }
        while (!stack.isEmpty()) {
            sum += (max - stack.pop());
        }
        System.out.println(sum);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(br.readLine());
            }
            solve();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2374 b = new B_2374();
        b.init();
    }
}
