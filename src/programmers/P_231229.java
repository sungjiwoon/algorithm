package programmers;

import java.util.*;

/**
 * 프로그래머스 레벨 2 PCCP 기출 2번
 * BFS
 */

public class P_231229 {
    Map<Integer, Integer> len = new HashMap<>();
    boolean[][] vis;
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void bfs(int i, int j, int[][] land) {
        int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(i, j));
        vis[i][j] = true;

        Set<Integer> set = new HashSet<>();
        int size = 0;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            set.add(p.y);
            size++;
            for (int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if (nx < 0 || ny < 0 || nx >= land.length || ny >= land[0].length) continue;
                if (vis[nx][ny] || land[nx][ny] == 0) continue;
                vis[nx][ny] = true;
                qu.add(new Pair(nx,ny));
            }
        }

        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int s = iter.next();
            len.put(s, len.getOrDefault(s, 0) + size);
        }

    }
    public int solution(int[][] land) {
        int answer = 0;
        vis = new boolean[land.length][land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (vis[i][j] || land[i][j] == 0) continue;
                bfs(i, j, land);
            }
        }

        for (int l : len.keySet()) {
            answer = Math.max(len.get(l), answer);
        }

        return answer;
    }
}
