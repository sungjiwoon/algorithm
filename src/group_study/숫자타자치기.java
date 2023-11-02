package group_study;
import java.util.*;

/**
 * 숫자 타자 치기 (레벨3)
 * https://school.programmers.co.kr/learn/courses/30/lessons/136797
 * BFS 생각했는데 통과를 못한다..
 */
class 숫자타자치기 {
    final int score1 = 1, score2 = 2, score3 = 3;
    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    int[] dx2 = {-1,-1,1,1}, dy2 = {-1,1,-1,1};
    int[][] map = {
            {1,2,3},{4,5,6},{7,8,9},{-1,0,-1}
    };
    int[][][] totalD = new int[4][3][10];
    Pair left, right;
    HashMap<Integer, Integer> hX = new HashMap<>();
    HashMap<Integer, Integer> hY = new HashMap<>();

    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < 4 && y < 3;
    }
    public boolean isNumberPad(int x, int y) {
        return map[x][y] != -1 ? true : false;
    }

    public boolean isNotOther(Pair other, int x, int y) {
        if (other.x == x && other.y == y) return false;
        return true;
    }

    public int bfs(Pair loc, int goal, Pair other) {
        if (goal == map[loc.x][loc.y]) return score1;

        int gx = hX.get(goal);
        int gy = hY.get(goal);

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(loc.x, loc.y));

        //점수 담음.
        int[][] d = new int[4][3];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(d[i], 100);
        }
        d[loc.x][loc.y] = 0;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            int x = p.x, y = p.y;

            //1. 상하좌우 먼저 조사.
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (isRange(nx, ny) && isNotOther(other, nx, ny)) {
                    if (d[nx][ny] <= d[x][y] + score2) continue;
                    d[nx][ny] = d[x][y] + score2;
                    qu.add(new Pair(nx, ny));
                }
            }

            //2. 대각선 조사
            for (int k = 0; k < 4; k++) {
                int nx = x + dx2[k], ny = y + dy2[k];
                if (isRange(nx, ny) && isNotOther(other, nx, ny)) {
                    if (d[nx][ny] <= d[x][y] + score3) continue;
                    d[nx][ny] = d[x][y] + score3;
                    qu.add(new Pair(nx, ny));
                }
            }
        }


        return d[gx][gy];

    }
    public int solution(String numbers) {
        int answer = 0;
        init();

        for (char c : numbers.toCharArray()) {
            int goal = c - '0';
            int leftSum = bfs(left, goal, right);
            int rightSum = bfs(right, goal, left);
            if (leftSum <= rightSum) {
                left = new Pair(hX.get(goal), hY.get(goal));
                answer += leftSum;
            } else {
                right = new Pair(hX.get(goal), hY.get(goal));
                answer += rightSum;
            }
        }

        return answer;
    }

    public void init() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] != -1) {
                    hX.put(map[i][j], i);
                    hY.put(map[i][j], j);
                }
            }
        }


        left = new Pair(hX.get(4), hY.get(4));
        right = new Pair(hX.get(6), hY.get(6));
    }
}

