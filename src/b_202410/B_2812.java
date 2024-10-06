package b_202410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_2812 {
    int n, k;
    String str;

    public void solve() {
        // k개를 지워서 얻을 수 있는 가장 큰 수?
        // n-k 자리
        int make = n - k;
        int rem = n - make + 1;

        int[] nums = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
        Queue<Integer> res = new LinkedList<>();

        Stack<Integer> stack = new Stack<>();

        // 일단 최초의 값들까지 넣는다.
        int best = 0;
        for (int i = 0; i < rem; i++) {
            if (nums[best] < nums[i]) best = i;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            stack.push(i);
        }

        res.add(best);

        for (int i = rem; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                System.out.println(String.format("nums[%d](%d)>nums[%d](%d), stack.pop() = %d",
                        i, nums[i], stack.peek(), nums[stack.peek()], stack.peek()));
                stack.pop();
            }
            if (stack.isEmpty() || stack.peek() < best) {
                res.add(i);
                best = i;
            } else if (stack.peek() > best && nums[stack.peek()] >= nums[i]) {
                res.add(stack.peek());
                best = stack.peek();
            }
            stack.push(i);
        }


        while (!res.isEmpty()) {
            System.out.print(nums[res.poll()]);
        }

    }
    public static void main(String[] args) throws Exception {
        B_2812 b = new B_2812();
        b.input();
        b.solve();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        k = arr[1];
        str = br.readLine();
    }
}
