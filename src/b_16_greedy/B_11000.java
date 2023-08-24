package b_16_greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_11000 {
    static int n;
    static Course[] courses;
    static ArrayList<Integer> rooms;
    static class Course {
        int s,t;
        Course(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }
    private static int solve() {

        Arrays.sort(courses, (o1, o2) -> {
            if (o1.s == o2.s) return o1.t - o2.t;
            return o1.s - o2.s;
        });

        PriorityQueue<Integer> qu = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (!qu.isEmpty() && qu.peek() > courses[i].s) {
                qu.add(courses[i].t);
            } else {
                qu.poll();
                qu.add(courses[i].t);
            }
        }

        return qu.size();
    }

    public static void main(String[] args) {
        input();

        int res = solve();

        System.out.println(res);

        /*
        시작시간이 가장 빠른 것부터 정렬후에,
        끝나는시간이 가장 빠른 순부터 정렬이 가능한 우선순위 큐를 만들어 계산한다.
        시간 복잡도 n * logN
         */
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            courses = new Course[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                courses[i] = new Course(s,t);
            }
            rooms = new ArrayList<>();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
