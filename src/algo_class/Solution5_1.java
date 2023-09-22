package algo_class;
import java.util.*;
//최소 점프
public class Solution5_1 {
    public int solution(int home){

        // 놀이터 (0) -> 집 : (home)
        // +1, -1, +5
        int[] dx = {1,-1,5};
        Queue<Integer> qu = new LinkedList<>();
        qu.add(0);
        int[] d = new int[10001];
        //d[i] = i 좌표 길을 가는데 최소 점프 방법
        while (!qu.isEmpty()) {
            int x = qu.poll();
            for (int k = 0; k < 3; k++) {
                int xx = x + dx[k];
                if (xx < 0 || xx > 10000 || d[xx] != 0) continue;
                qu.add(xx);
                d[xx] = d[x] + 1;
                if (xx == home) return d[home];
            }
        }

        return d[home];

    }
    public static void main(String[] args) {
        Solution5_1 T = new Solution5_1();
        System.out.println(T.solution(10));
        System.out.println(T.solution(14));
        System.out.println(T.solution(25));
        System.out.println(T.solution(24));
        System.out.println(T.solution(345));
    }

}
