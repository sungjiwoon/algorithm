package b_30_bitmasking;

import java.io.*;
import java.util.*;

// 250202  괄호 제거 비트마스킹, 백트래킹, 스택
public class B_2800 {
    String s;

    private void solve() {

        //1. 괄호의 쌍을 보관하는 인덱스 저장소 생성.
        List<int[]> list = new ArrayList<>();

        //2. 괄호 위치 확인
        Stack<Integer> stack = new Stack();
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            } else if (c == ')') {
                int stIdx = stack.pop();
                list.add(new int[] {stIdx, i});
//                System.out.println(String.valueOf(s.charAt(stIdx)) + String.valueOf(s.charAt(i)));
            }
        }

        // 3. 괄호의 쌍 갯수 확인
        int size = list.size();

        // 4. 괄호의 쌍만큼 비트마스킹 돌림
        // 4.1 수식 보관할 우선순위큐 생성
        PriorityQueue<String> pq = new PriorityQueue<>();
        Map<String, Integer> vis = new HashMap<>();


        for (int bit = 1; bit < (1 << size); bit++) {

            boolean[] no = new boolean[s.length()];
            for (int i = 0; i < size; i++) {
                if ((bit & (1 << i)) > 0) {
                    int[] idx = list.get(i);
                    int st = idx[0], en = idx[1];
                    no[st] = true;
                    no[en] = true;
                }
            }
            String tmp = "";
            for (int i = 0; i < s.length(); i++) {
                if (!no[i]) tmp += s.charAt(i);
            }
            if (!vis.containsKey(tmp)) {
                pq.add(tmp);
                vis.put(tmp, 1);
            }

        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            s = br.readLine();
            solve();
        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        B_2800 b = new B_2800();
        b.init();
    }
}
