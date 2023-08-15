package group_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1062 {
    static int n,k;
    static String[] data;
    static int res = 0;
    static String alpha = "";
    static private void dfs(int depth,  int st, boolean[] vis){
        if (depth == k) {
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                boolean isVaild = true;
                for (int j = 0; j < data[i].length(); j++) {
                    if (!vis[data[i].charAt(j)-'a']) {
                        isVaild = false;
                        break;
                    }
                }
                if (isVaild) cnt++;
            }
            res = Math.max(cnt, res);
            return;
        }
        for (int i = st; i < alpha.length(); i++) {
            if (!vis[i]) {
                vis[i] = true;
                dfs(depth+1,i+1, vis);
                vis[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{

        input();
        if (k < 5) {
            res = 0;
            System.out.println(0);
            return;
        }

        k -= 5; //antic

        boolean[] vis = new boolean[26];
        vis['n'-'a'] = vis['c'-'a'] = vis['i'-'a'] = vis['t'-'a'] = vis['a'-'a'] = true;
        dfs(0, 0, vis);

        System.out.println(res);

        /*
        문제 : 가르침 (골4)
        백트래킹

        antic을 제외한 21개의 알파벳들의 모든 21C(K-5) 조합으로 찾아냈다.
        처음에는 모든 조합을 전부 replaceAll로 통해 찾으려고 했으나 시간초과발생하였다.
        -> data[i] = data[i].replaceAll("a|n|t|c|i|r", ""); -> 반복하니 시간초과
        그래서 isVaild 플래그 변수를 두어 찾아내었다.


         */

    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        data = new String[n];
        for (int i = 0; i < n; i++) {
            data[i] = br.readLine();
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            alpha += ch;
        }
    }
}
