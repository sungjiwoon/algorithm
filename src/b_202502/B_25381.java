package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 250202 ABBC 그리디, 큐
public class B_25381 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toLowerCase();

        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> b = new LinkedList<>();

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') a.add(i);
            else if (c == 'b') b.add(i);
            else if (c == 'c'){
                if (!b.isEmpty()) {
                    b.poll();
                    ans++;
                }
            }
        }

        while (!a.isEmpty() && !b.isEmpty()) {
            int aIdx = a.poll();
            while (!b.isEmpty() && b.peek() < aIdx) b.poll();
            if (!b.isEmpty()) {
                ans++;
                b.poll();
            }
        }
        System.out.println(ans);

    }
}
