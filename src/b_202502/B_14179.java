package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// 250219 빗물 골드5 - 구현, 스택
public class B_14179 {

    int h, w;
    int[] blocks;

    private void solve() {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        // 가로로 접근
        // 가로 기준으로 값의 사이에 있으면 더해준다?
        for (int i = h; i >= 0; i--) {
            stack.clear();
            for (int j = 0; j < w; j++) {
                if (blocks[j] >= i) {
                    if (stack.isEmpty()) {
                        stack.push(j);
                    } else {
                        int pre = stack.pop();
                        ans += (j - pre - 1);
                        stack.push(j);
                    }
                }
            }
        }
        System.out.println(ans);

    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            blocks = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            solve();


        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_14179 b = new B_14179();
        b.init();
    }
}
