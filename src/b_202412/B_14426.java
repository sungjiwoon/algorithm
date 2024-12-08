package b_202412;
import java.util.*;
import java.io.*;

public class B_14426 {

    String[] words = new String[10001];
    String[] preWords = new String[10001];

    int n, m;

    class Node {
        Map<Character, Node> child;
        boolean isEnd;

        public Node() {
            this.child = new HashMap<>();
            isEnd = false;
        }
    }

    class Trie {
        Node root; // root 에는 값이 없음

        public Trie() {
            root = new Node();
        }

        void insert(String str) {
            char[] strArr = str.toCharArray();

            Node node = this.root;
            for (int i = 0; i < strArr.length; i++) {
                char c = strArr[i];
                if (!node.child.containsKey(c)) {
                    // node의 자식 중에서 값이 없으면 넣어준다.
                    node.child.put(c, new Node());
                }
                node = node.child.get(c);
            }

            node.isEnd = true;
        }

        boolean search(String str) {
            char[] strArr = str.toCharArray();

            Node node = this.root;
            for (int i = 0; i < strArr.length; i++) {
                char c = strArr[i];
                if (node.child.containsKey(c)) {
                    // node의 자식 중에서 값이 있으면 이동함
                    node = node.child.get(c);
                } else {
                    return false;
                }
            }
            return node.isEnd; // 마지막 노드의 isEnd 여부 반환
        }

        boolean searchPreWord(String str) {
            char[] strArr = str.toCharArray();

            Node node = this.root;
            for (int i = 0; i < strArr.length; i++) {
                char c = strArr[i];
                if (node.child.containsKey(c)) {
                    // node의 자식 중에서 값이 있으면 이동함
                    node = node.child.get(c);
                } else {
                    return false;
                }
            }
            return true;
        }

        public boolean delete(String str) {
            return delete(this.root, str, 0);
        }

        boolean delete(Node node, String str, int idx) {
            char c = str.charAt(idx);

            // 현재 노드의 자식 노드에서 c를 지워야하는데, 없으면 return false
            if (!node.child.containsKey(c)) return false;

            Node cur = node.child.get(c);
            idx++;
            if (idx == str.length()) { // 문자열 끝에 도달했을 때
                if (!cur.isEnd) return false;

                // isEnd를 false로 바꿔주면, 찾으려는 문자열 찾을 수 없게됨
                cur.isEnd = false;
                if (cur.child.isEmpty()) {
                    node.child.remove(c);
                }
            } else { // 문자열의 끝에 도달하지 않았을 때
                if (!this.delete(cur, str, idx)) return false;
                // true 반환 받고, 자식 노드 비어있으면 현재 노드 삭제함
                // node는 cur의 부모 노드임. cur 노드를 node의 자식에서 삭제
                if (!cur.isEnd && cur.child.isEmpty()) {
                    node.child.remove(c);
                }
            }
            return true;
        }
    }

    public void solve() {
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            trie.insert(words[i]);
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (trie.searchPreWord(preWords[i])) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    public static void main(String[] args) throws Exception {

        B_14426 b = new B_14426();
//        Main b = new Main();

        b.input();
        b.solve();

    }
    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            preWords[i] = br.readLine();
        }
    }
}
