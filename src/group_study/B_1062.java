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
    static private void dfs_bitmask(int depth, int flag, int st) {
        if (depth == k) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                boolean isVaild = true;
                for (int j = 0; j < data[i].length(); j++) {
                    int check = data[i].charAt(j) - 'a';
                    if ((flag & (1 << check)) == 0) {
                        //flag에 해당 글자가 없다는 뜻.
                        isVaild = false;
                        break;
                    }
                }
                if (isVaild) cnt++;
            }
            res = Math.max(res, cnt);
            return;
        }
        for (int i = st; i < 26; i++) {
            if ((flag & (1 << i)) == 0) {
                dfs_bitmask(depth+1, flag | (1 << i), i+1);
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

//        boolean[] vis = new boolean[26];
//        vis['n'-'a'] = vis['c'-'a'] = vis['i'-'a'] = vis['t'-'a'] = vis['a'-'a'] = true;
//        dfs(0, 0, vis);
//
//        System.out.println(res);

        int flag = 0;
        flag |= (1 << ('a'-'a'));
        flag |= (1 << ('c'-'a'));
        flag |= (1 << ('i'-'a'));
        flag |= (1 << ('t'-'a'));
        flag |= (1 << ('n'-'a'));
        dfs_bitmask(0,flag,0);
        System.out.println(res);


        /*
        문제 : 가르침 (골4)
        백트래킹

        antic을 제외한 21개의 알파벳들의 모든 21C(K-5) 조합으로 찾아냈다.
        처음에는 모든 조합을 전부 replaceAll로 통해 찾으려고 했으나 시간초과발생하였다.
        -> data[i] = data[i].replaceAll("a|n|t|c|i|r", ""); -> 반복하니 시간초과
        그래서 isVaild 플래그 변수를 두어 찾아내었다.

        비트 마스킹 :
        flag 변수 : 00000000 00000000 00000000 00000000 인 int 2진수
        'c' 가 들어있다면 'c'-'a' = 2
        flag |= (1<<2) -> 00000000 00000000 00000000 00000100
        'g'가 들어있다면 'g'-'a' = 7
        flag |= (1<<7) -> 00000000 00000000 00000000 10000100

        'g'가 들어있는지 확인하려면
        flag & (1<<7) -> (00000000 00000000 00000000 10000100) & (00000000 00000000 00000000 10000000) > 0
        'f'가 들어있는지 확인하면
        flag & (1<<6) -> (00000000 00000000 00000000 10000100) & (00000000 00000000 00000000 01000000) = 0
        즉, f는 flag 조합에 없으므로, break;문에 걸려 탈출한다.
        이런 방식으로 가장 많이 isVaild = true가 나오는 문자열 조합을 찾아내면 된다.


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
