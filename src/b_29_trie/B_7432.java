package b_29_trie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
디스크 트리 (골3)
트라이
split(역슬래시) -> split("\\\\");
dfs -> 파일 이름 탐색.
 */
public class B_7432 {
    ArrayList<String> list = new ArrayList<>();
    class Trie {
        ArrayList<Trie> node;
        String dir;
        int depth;
        HashMap<String, Integer> getIndex;
        //현재 디렉토리에 있는 하위 디렉토리들의 인덱스 반환.
        Trie() {
            node = new ArrayList<>();
            depth = -1;
            getIndex = new HashMap<>();
        }

        public void insert(String s) {
            ArrayList<Trie> node = this.node;
            Trie curr = this;

            String[] sp = s.split("\\\\");

            for (String str : sp) {
                int index = 0;
                if (!curr.getIndex.containsKey(str)) {
                    // 새로운 트라이 (하위 디렉토리) 만들기.
                    Trie newTrie = new Trie();
                    newTrie.dir = str;
                    newTrie.depth = curr.depth + 1;

                    //기존 트라이 (현재 디렉토리) 에 추가.
                    curr.getIndex.put(str, node.size()); //상위 디렉토리에 추가.
                    curr.node.add(newTrie);
                }
                index = curr.getIndex.get(str);
                curr = node.get(index);
                node = curr.node;

            }
        }

        public void find(Trie top) {
            if (top.node == null) return;

            Collections.sort(top.node, (o1, o2) -> {
                return o1.dir.compareTo(o2.dir);
            });

            for (Trie trie : top.node) {
                for (int i = 0; i < trie.depth; i++)
                    System.out.print(" "); //공백 처리
                System.out.println(trie.dir);

                find(trie); //디렉토리 순환 방식이 dfs 방식임.
            }
        }
    }

    private void solve() {
        Trie root = new Trie();
        for (String s : list) {
            root.insert(s);
        }

        root.find(root);
    }
    public static void main(String[] args) {
        B_7432 b = new B_7432();
//        Main b = new Main();
        b.input();
        b.solve();

    }

    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            while (n-- > 0) {
                list.add(br.readLine());
            }
        }catch (Exception e) {}
    }
}
