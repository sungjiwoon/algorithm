package b_202410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/** 241013 트리 골드 5 */

public class B_1068 {
    int n;
    int[] parents;
    int removeIdx, root;

    List<Integer>[] graph = new ArrayList[51];

    public void solve() {

        // remove node
        Queue<Integer> qu = new LinkedList<>();
        qu.add(removeIdx);
        while (!qu.isEmpty()) {
            int q = qu.poll();
            for (int r : graph[q]) {
                qu.add(r);
            }
            graph[q] = null;
        }

        // removeIdx의 부모에서 removeIdx삭제
        if (parents[removeIdx] != -1) {
            List<Integer> tmp = new ArrayList<>();
            for (int l : graph[parents[removeIdx]]) {
                if (l == removeIdx) continue;
                tmp.add(l);
            }
            graph[parents[removeIdx]] = tmp;
        }

        // count leaf node
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (graph[i] != null && graph[i].size() == 0) cnt++;
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        B_1068 b = new B_1068();
        b.init();
        b.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        removeIdx = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                continue;
            }
            graph[parents[i]].add(i);
        }

    }
}
