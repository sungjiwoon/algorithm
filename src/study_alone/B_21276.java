package study_alone;

import java.util.*;
import java.io.*;

public class B_21276 {
    static HashMap<String, Integer> index = new HashMap<>();
    static ArrayList<Integer>[] graph;
    static String[] name;
    static int[] indegree;
    static int n;

    public static void main(String[] args) {
        input();

        Queue<Integer> qu = new LinkedList<>(); //indegree[i] = 0인 i인 애들이 들감.
        ArrayList<String> root = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                qu.add(i);
                root.add(name[i]);
            }
        }

        ArrayList<Integer>[] res = new ArrayList[n];

        while (!qu.isEmpty()) {
            int q = qu.poll();
            for (int p : graph[q]) {
                indegree[p]--;
                if (indegree[p] == 0) {
                    qu.add(p);
                    if (res[q] == null) res[q] = new ArrayList<>();
                    res[q].add(p);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.size()+"\n");
        for (String r : root) {
            sb.append(r +" ");
        }
        sb.append("\n");
        for (int i = 0; i < n; i++) {
            sb.append(name[i]);
            sb.append(" ");
            if (res[i] == null) {
                sb.append("0\n");
                continue;
            }
            sb.append(res[i].size() + " ");
            for (int j : res[i]) {
                sb.append(name[j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
    public static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            name = br.readLine().split(" ");
            Arrays.sort(name);

            indegree = new int[n];
            graph = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Integer>();
                index.put(name[i], i);
            }

            int m = Integer.parseInt(br.readLine());
            while (m-- > 0) {
                String[] sp = br.readLine().split(" ");
                //sp[0] 의 조상 중 y가 있다.
                //sp[0]의 indegree ++;

                int parent = index.get(sp[1]);
                int child = index.get(sp[0]);

                indegree[child]++;
                graph[parent].add(child);

            }


        } catch (Exception e) {}
    }
}
