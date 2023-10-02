package b_29_trie;

import java.io.*;
import java.util.*;

/*
접두사 찾기 (실버1)
트라이알고리즘
https://www.acmicpc.net/problem/14426

 */
public class B_14426 {
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> checkList = new ArrayList<>();
    class Trie {
        Trie[] nodes;
        boolean isEnd;
        public Trie() {
            this.nodes = new Trie[26];
            this.isEnd = false;
        }

        public void insert(String s) {

            if (s.length() == 0) return;

            Trie[] node = this.nodes;
            Trie curr = null;

            for (char c : s.toCharArray()) {
                int num = c - 'a';

                if (node[num] == null) {
                    node[num] = new Trie();
                }

                curr = node[num];
                node = curr.nodes;

            }
            curr.isEnd = true;
        }

        public boolean isCheck(String s) {

            Trie[] node = this.nodes;
            Trie curr = null;

            for (char c : s.toCharArray()) {
                int num = c - 'a';

                if (node[num] == null) {
                    return false;
                }

                curr = node[num];
                node = curr.nodes;

            }

            return true;
        }

    }

    private int solve() {
        int res = 0;
        Trie root = new Trie();
        for (String s : list) {
            root.insert(s);
        }

        for (String check : checkList) {
            if (root.isCheck(check)) {
                res++;
            }
        }

        return res;
    }
    public static void main(String[] args){
         B_14426 b = new B_14426();
//         Main b = new Main();

        b.input();
        System.out.println(b.solve());
    }
    private void input() {
        try {
            BufferedReader br
                    = new BufferedReader(new InputStreamReader(System.in));
            int[] cnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            while (cnt[0]-- > 0) {
                list.add(br.readLine());
            }

            while (cnt[1]-- > 0) {
                checkList.add(br.readLine());
            }

        } catch (Exception e) {}
    }
}
