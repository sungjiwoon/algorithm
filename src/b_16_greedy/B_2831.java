package b_16_greedy;
import java.io.*;
import java.util.*;
/** 240326 백준 댄스파티 그리디 골4 */
public class B_2831 {
    static int n;
    static int[] men, women;
    static int res = 0;
    private static void solve() {
        // 마이너스 남자 X 플러스 여자
        PriorityQueue<Integer> mQ = new PriorityQueue<>();
        PriorityQueue<Integer> wQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (men[i] < 0) mQ.add(Math.abs(men[i]));
            else break;
        }
        for (int i = n-1; i >= 0; i--) {
            if (women[i] > 0) wQ.add(Math.abs(women[i]));
            else break;
        }

        while (!mQ.isEmpty() && !wQ.isEmpty()) {
            //여자 기준
            int h = wQ.poll();
            while (!mQ.isEmpty() && mQ.peek() <= h) {
                mQ.poll();
            }
            if (mQ.isEmpty()) break;
//            System.out.println(String.format("M : %d, W : %d", mQ.peek(), h));
            mQ.poll();
            res++;
        }

        mQ = new PriorityQueue<>();
        wQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (women[i] < 0) wQ.add(Math.abs(women[i]));
            else break;
        }
        for (int i = n-1; i >= 0; i--) {
            if (men[i] > 0) mQ.add(Math.abs(men[i]));
            else break;
        }

        while (!mQ.isEmpty() && !wQ.isEmpty()) {
            //남자 기준
            int h = mQ.poll();
            while (!wQ.isEmpty() && wQ.peek() <= h) {
                wQ.poll();
            }
            if (wQ.isEmpty()) break;
            wQ.poll(); // 빠져야함
            res++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        men = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        women = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(men);
        Arrays.sort(women);

        solve();
        System.out.println(res);


    }
}
