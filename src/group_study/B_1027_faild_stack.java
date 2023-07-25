package group_study;

import java.io.*;
import java.util.*;

public class B_1027_faild_stack {
    static Deque<Building> stack;
    static int[] left, right;
    static long[] data;
    static int n;
    static class Building {
        int index; //빌딩 위치 인덱스
        long v; //높이
        Building(int index, long v) {
            this.index = index;
            this.v = v;
        }
    }

    private static void solve_left() {
        stack = new LinkedList<>();
        int i = 1;

        while (i <= n) {
            while (i <= n && (stack.isEmpty() || stack.peek().v > data[i])) {
                //System.out.println("push " + data[i]);
                stack.push(new Building(i, data[i++]));
            }

            if (i > n || (!stack.isEmpty() && stack.peek().v <= data[i])) {
                if (i > n) i = n;
                while (!stack.isEmpty() && (i == n || stack.peek().v <= data[i])) {
                    Building b = stack.pop();
                    if (b.v >= data[i]) {
                        while (!stack.isEmpty()) left[stack.peek().index] = b.index - stack.pop().index;
                    }
                    left[b.index] = i - b.index;
                    //System.out.println("pop " + b.v + " " + left[b.index]);
                }

                if (i == n && stack.isEmpty()) break;
            }


        }
    }

    private static void solve_right() {
        stack = new LinkedList<>();
        int i = n;

        while (i >= 1) {
            while (i >= 1 && (stack.isEmpty() || stack.peek().v > data[i])) {
                //System.out.println("push " + data[i]);
                stack.push(new Building(i, data[i--]));
            }

            if (i < 1 || (!stack.isEmpty() && stack.peek().v <= data[i])) {
                if (i < 1) i = 1;
                while (!stack.isEmpty() && (i == 1 || stack.peek().v <= data[i])) {
                    Building b = stack.pop();
                    if (b.v >= data[i]) {
                        while (!stack.isEmpty()) right[stack.peek().index] = stack.pop().index - b.index;
                    }
                    right[b.index] = b.index-i;
                    //System.out.println("pop " + b.v + " " + left[b.index]);
                }

                if (i == 1 && stack.isEmpty()) break;
            }
        }
    }
    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        data = new long[n+1];
        for (int i = 1; i <= n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        left = new int[n+1];
        right = new int[n+1];

        solve_left();
        solve_right();

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, left[i] + right[i]);
        }
        System.out.println(ans);
    }

    /*
    처음에는 스택 알고리즘을 이용하여 문제를 풀었다.
    왼쪽에서 보이는 건물들의 수와 ㄱ오른쪽에서 보이는 건물의 수를 합한 최댓값을 구하는 식으로 생각했으나
    태스트 케이스는 다 맞았으나, 통과하지 못했다.

     */
}
