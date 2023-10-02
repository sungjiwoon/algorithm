package b_16_greedy;

import java.io.*;
import java.util.*;

public class B_11000 {
    int n;
    Class[] classes;
    class Class implements Comparable<Class> {
        int s, t;
        Class(int s, int t) {
            this.s = s;
            this.t = t;
        }
        @Override
        public int compareTo(Class com) {
            if (this.s == com.s)
                return this.t - com.t;
            return this.s - com.s;
        }

    }
    private int solve() {
        //수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.
        //김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데,
        // 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
        //참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다.
        // (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)

        Arrays.sort(classes);

        PriorityQueue<Integer> qu = new PriorityQueue<>();
        //끝나는 시간을 담는 우선순위 큐 .
        //빨리 끝나는 시간이 먼저 나온다.

        for (Class c : classes) {
            //끝나는 시간을 기준으로 계산.
            if (qu.isEmpty()) qu.offer(c.t);
            else {
                if (qu.peek() <= c.s) qu.poll();
                qu.offer(c.t);
            }
        }

        return qu.size();
    }
    public static void main(String[] args) {
        B_11000 b = new B_11000();
        b.input();
        System.out.println(b.solve());
    }
    private void input() {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            classes = new Class[n];
            for (int i = 0; i < n; i++) {
                String[] sp = br.readLine().split(" ");
                classes[i] = new Class(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]));
            }
        } catch (Exception e) {}
    }
}
