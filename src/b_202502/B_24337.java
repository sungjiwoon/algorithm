package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 250210 가희와 탑 그리디, 덱
public class B_24337 {
    int n, a, b;

    private String print(Deque dq) {
        String st = "";
        while(!dq.isEmpty()) {
            st += dq.poll();
            if (!dq.isEmpty()) st += " ";

//            System.out.print(dq.poll() + " ");
        }
        return st;
    }

    private String solve() {
        // a만큼 순열이 보장
        // b만큼 아래로 내려가는 순열 보장
        // 1 3 2 5 3 1
        Deque<Integer> dq = new LinkedList<>();

        if (a+b > n && a+b != n+1) {
//            System.out.println("-1");
            return "-1";
        }

        if (a == 1 && b == 1 && n == 1) {
//            System.out.println("1");
            return "1";
        }

        if (a > b) {
            // a 먼저
            for (int i = 1; i <= a; i++) {
                dq.add(i);
            }
            for (int i = b-1; i >= 1; i--) {
                dq.addLast(i);
            }
        } else if (a == 1 && a < b) {
            dq.add(b);
            while (dq.size() <= n-b) {
                dq.addLast(1);
            }
            for (int i = b-1; i >= 1; i--) {
                dq.addLast(i);
            }
        } else if (a < b) {
            for (int i = 1; i <= a-1; i++) {
                dq.add(i);
            }
            for (int i = b; i >= 1; i--) {
                dq.addLast(i);
            }
        } else {
            for (int i = 1; i <= a; i++) {
                dq.add(i);
            }
            for (int i = b; i >= 1; i--) {
                dq.addLast(i);
            }
        }
        while (dq.size() < n) {
            dq.addFirst(1);
        }
        return print(dq);

    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//            StringBuilder sb = new StringBuilder();
//            String str = "";
//            while (!(str = br.readLine()).equals("")) {
//                StringTokenizer st = new StringTokenizer(str, " ");
//                n = Integer.parseInt(st.nextToken());
//                a = Integer.parseInt(st.nextToken());
//                b = Integer.parseInt(st.nextToken());
//
//                String ans = br.readLine();
//                String my = solve();
//                if (!ans.equals(my)) {
//                    sb.append(n + " " + a + " " + b + "\n");
//                    sb.append(ans).append("\n");
//                    sb.append(my).append("\n\n");
//                }
//                str = br.readLine();
//            }
//            System.out.println(sb);
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            System.out.println(solve());
        } catch (Exception e) {}

    }

    public static void main(String[] args) {
        B_24337 b = new B_24337();
        b.init();
    }
}
