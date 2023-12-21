package programmers;

import java.util.*;

/*
231221 프로그래머스 : 메뉴 리뉴얼
완전 탐색 + 백트래킹
 */

public class P_231221 {
    Map<String, Integer> map;
    List<String> res = new ArrayList<>();
    private void combination(int depth, int len, char[] arr, char[] str, int st, boolean[] vis) {
        if (depth == len) {
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                sb.append(c);
            }

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = st; i < str.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                arr[depth] = str[i];
                combination(depth+1, len, arr, str, i+1, vis);
                vis[i] = false;
            }
        }
    }

    private void setMaxValue() {
        int max = 0;

        Map<Integer, List<String>> maxList = new HashMap<>();

        for (String key : map.keySet()) {
            int v = map.get(key);
            max = Math.max(max, v);

            if (maxList.containsKey(v)) {
                maxList.get(v).add(key);
            } else {
                List<String> list = new ArrayList<>();
                list.add(key);
                maxList.put(v, list);
            }
        }
        if (max < 2) return;

        List<String> value = maxList.get(max);
        for (String v : value) {
            res.add(v);
        }
    }

    public String[] solution(String[] orders, int[] course) {

        for (int co : course) {
            map = new HashMap<>();

            for (String s : orders) {
                char[] str = s.toCharArray();
                Arrays.sort(str);
                combination(0, co, new char[co], str, 0, new boolean[str.length]);
            }

            setMaxValue();
        }
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        P_231221 p = new P_231221();
        String[] ans = p.solution(
                new String[] {"XYZ", "XWY", "WXA"},
                new int[] {2,3,4});
        System.out.println(Arrays.toString(ans));
    }
}










