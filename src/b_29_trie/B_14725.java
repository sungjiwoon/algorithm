package b_29_trie;

import java.io.*;
import java.util.*;

public class B_14725 {
    int n;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    class Node {
        Map<String, Node> child;
        boolean isEnd;

        public Node() {
            this.child = new HashMap<>();
            isEnd = false;
        }
    }

    class Trie {
        Node root;
        public Trie() {
            this.root = new Node();
        }

        void insert(String str) {
            String[] sp = str.split(" ");
            int depth = Integer.parseInt(sp[0]);

            Node node = this.root;
            for (int i = 1; i <= depth; i++) {
                if (!node.child.containsKey(sp[i])) {
                    node.child.put(sp[i], new Node());
                }
                node = node.child.get(sp[i]);
            }

            node.isEnd = true;
        }

        void print() {
            print(this.root, "");
        }

        private void print(Node node, String pre) {
            if (node.isEnd) {
                return;
            }

            // 자식들 전부 출력, 단 사전 순서로 출력
            List<String> keyList = new ArrayList<>(node.child.keySet());
            Collections.sort(keyList);

            for (String key : keyList) {
                String nextPre = pre + "--";
                System.out.println(pre + key);
                print(node.child.get(key), nextPre);
            }

        }
    }

    void solve() throws Exception {
        n = Integer.parseInt(input());

        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(input());
        }

        // 출력 DFS
        trie.print();
    }


    public static void main(String[] args) throws Exception {
        B_14725 b = new B_14725();
        b.solve();
    }

    public String input() throws Exception {
        return br.readLine();
    }
}
