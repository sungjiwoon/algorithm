package group_study;

import java.io.*;
import java.util.*;

public class B_1966 {

    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] prioity = new int[10]; //중요도 담는 배열
            int max_pri = 1; //현재 가장 높은 중요도를 담는 변수
            Queue<int[]> qu = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int[] num = new int[2];
                num[0] = i; //인덱스
                num[1] = Integer.parseInt(st.nextToken()); //중요도
                qu.add(num);
                prioity[num[1]]++; //해당 중요도를 담는 곳 + 1
                if (num[1] > max_pri) max_pri = num[1]; //가장 높은 중요도 갱신
            }
            int ans = 0; //순서
            while (!qu.isEmpty()) {
                int[] q = qu.poll();
                if (q[1] < max_pri) { //꺼낸 문서의 중요도가 현재 가장 높은 중요도 보다 낮을 경우 다시 큐 삽입.
                    qu.add(q);
                    continue;
                } else if (q[1] == max_pri) { //인쇄되는 경우.
                    prioity[max_pri]--;
                    while (max_pri > 1 && prioity[max_pri] == 0) max_pri--; //중요도는 9에서 1로 갈 수 있으므로 반복문.
                    ans++;
                }
                if (q[0] == m) break;
            }
            System.out.println(ans);

        }
    }
}
