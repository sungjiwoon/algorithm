package b_29_trie;

import java.io.*;
import java.util.*;

public class B_5052 {

    static class Trie {
        Trie[] node;
        boolean isEnd;

        Trie() {
            this.node = new Trie[10];
            this.isEnd = false;
        }

        public void add(String s) {
            if (s.length() == 0) return;
            Trie[] nodes = this.node;
            Trie curr = null;

            for (char c : s.toCharArray()) {
                int num = c - '0';

                if (nodes[num] == null) {
                    nodes[num] = new Trie();
                }

                curr = nodes[num];
                nodes = nodes[num].node;
            }

            curr.isEnd = true; //끝나는 지점.
        }

        public boolean check(String s) {
            Trie[] nodes = this.node;
            Trie curr = null;

            for (int i = 0; i < s.length(); i++) {
                int n = s.charAt(i) - '0';
                curr = nodes[n];
                //일관성이 없는 경우.
                if (curr.isEnd && i < s.length() - 1) return false;
                nodes = curr.node;
            }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder("");

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<String> phones = new ArrayList<>();
            while (n-- > 0) {
                phones.add(br.readLine());
            }

            Trie root = new Trie();
            phones.forEach(phone -> root.add(phone));

            boolean ok = true;
            for (String ph : phones) {
                if (!root.check(ph)) {
                    ok = false;
                    break;
                }
            }

            if (!ok) res.append("NO\n");
            else res.append("YES\n");

        }
        System.out.println(res);

    }

}
