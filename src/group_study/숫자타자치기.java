package group_study;
import java.util.*;

/**
 * 숫자 타자 치기 (레벨3)
 * https://school.programmers.co.kr/learn/courses/30/lessons/136797
 * BFS 생각했는데 통과를 못한다..
 */
class 숫자타자치기 {
    int n = 0;
    int res = Integer.MAX_VALUE;
    final int score1 = 1, score2 = 2, score3 = 3;
    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    int[] dx2 = {-1,-1,1,1}, dy2 = {-1,1,-1,1};

    int[][] map = {
            {1,2,3},{4,5,6},{7,8,9},{-1,0,-1}
    };

    int[][][] totalD = new int[4][3][10];
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

    public int bfs(Pair loc, int goal) {
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
                if (isRange(nx, ny)) {
                    if (d[nx][ny] <= d[x][y] + score2) continue;
                    d[nx][ny] = d[x][y] + score2;
                    qu.add(new Pair(nx, ny));
                }
            }

            //2. 대각선 조사
            for (int k = 0; k < 4; k++) {
                int nx = x + dx2[k], ny = y + dy2[k];
                if (isRange(nx, ny)) {
                    if (d[nx][ny] <= d[x][y] + score3) continue;
                    d[nx][ny] = d[x][y] + score3;
                    qu.add(new Pair(nx, ny));
                }
            }
        }


        return d[gx][gy];

    }

    public void dfs(int depth, char[] nums, int sum, Pair left, Pair right) {
        if (depth == n) {
            res = Math.min(sum, res);
            return;
        }
        char c = nums[depth];
        int goal = c - '0';

        if (map[left.x][left.y] == goal || map[right.x][right.y] == goal) {
            dfs(depth + 1, nums, sum + score1, left, right);
        } else {
            int leftSum = totalD[left.x][left.y][goal];
            int rightSum = totalD[right.x][right.y][goal];
            dfs(depth + 1, nums, sum + leftSum, new Pair(hX.get(goal), hY.get(goal)), right);
            dfs(depth + 1, nums, sum + rightSum, left, new Pair(hX.get(goal), hY.get(goal)));
        }

    }

    public int solution(String numbers) {
        int answer = 0;
        init();
        n = numbers.length();

        dfs(0, numbers.toCharArray(), 0,
                new Pair(hX.get(4), hY.get(4)), new Pair(hX.get(6), hY.get(6)));
        return res;
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

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k <= 9; k++) {
                    totalD[i][j][k] = bfs(new Pair(i, j), k);
                }
            }
        }

    }
}

