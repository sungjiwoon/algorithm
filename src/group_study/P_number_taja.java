//package group_study;
//import java.util.*;
//
///**
// * 숫자 타자 치기 (레벨3)
// * https://school.programmers.co.kr/learn/courses/30/lessons/136797
// * BFS 생각했는데 통과를 못한다..
// */
//class 숫자타자치기 {
//
//    final int score1 = 1, score2 = 2, score3 = 3;
//
//    int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
//    int[] dx2 = {-1,-1,1,1}, dy2 = {-1,1,-1,1};
//
//    int[][] map = {
//            {1,2,3},{4,5,6},{7,8,9},{-1,0,-1}
//    };
//
//    int[][][] dp;
//    char[] nums;
//    int n = 0;
//
//    int[][] totalD = new int[10][10];
//    // int[][] cost = {
//    //     {1, 7, 6, 7, 5, 4, 5, 3, 2, 3},
//    //     {7, 1, 2, 4, 2, 3, 5, 4, 5, 6},
//    //     {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
//    //     {7, 4, 2, 1, 5, 3, 2, 6, 5, 4},
//    //     {5, 2, 3, 5, 1, 2, 4, 2, 3, 5},
//    //     {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
//    //     {5, 5, 3, 2, 4, 2, 1, 5, 3, 2},
//    //     {3, 4, 5, 6, 2, 3, 5, 1, 2, 4},
//    //     {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
//    //     {3, 6, 5, 4, 5, 3, 2, 4, 2, 1}
//    // };
//
//    HashMap<Integer, Integer> hX = new HashMap<>();
//    HashMap<Integer, Integer> hY = new HashMap<>();
//
//    class Pair {
//        int x, y;
//        Pair(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    public boolean isRange(int x, int y) {
//        return x >= 0 && y >= 0 && x < 4 && y < 3;
//    }
//
//    public int bfs(Pair loc, int goal) {
//        if (goal == map[loc.x][loc.y]) return score1;
//
//        int gx = hX.get(goal);
//        int gy = hY.get(goal);
//
//        Queue<Pair> qu = new LinkedList<>();
//        qu.add(new Pair(loc.x, loc.y));
//
//        //점수 담음.
//        int[][] d = new int[4][3];
//        for (int i = 0; i < 4; i++) {
//            Arrays.fill(d[i], 100);
//        }
//
//        d[loc.x][loc.y] = 0;
//
//        while (!qu.isEmpty()) {
//            Pair p = qu.poll();
//            int x = p.x, y = p.y;
//
//            //1. 상하좌우 먼저 조사.
//            for (int k = 0; k < 4; k++) {
//                int nx = x + dx[k], ny = y + dy[k];
//                if (isRange(nx, ny)) {
//                    if (d[nx][ny] <= d[x][y] + score2) continue;
//                    d[nx][ny] = d[x][y] + score2;
//                    qu.add(new Pair(nx, ny));
//                }
//            }
//
//            //2. 대각선 조사
//            for (int k = 0; k < 4; k++) {
//                int nx = x + dx2[k], ny = y + dy2[k];
//                if (isRange(nx, ny)) {
//                    if (d[nx][ny] <= d[x][y] + score3) continue;
//                    d[nx][ny] = d[x][y] + score3;
//                    qu.add(new Pair(nx, ny));
//                }
//            }
//        }
//
//        return d[gx][gy];
//
//    }
//
//    public int dfs(int idx, int L, int R) {
//        if (idx == n) {
//            return 0;
//        }
//
//        if (dp[idx][L][R] != -1) {
//            return dp[idx][L][R];
//        }
//
//        char c = nums[idx];
//        int goal = c - '0';
//
//        int res = Integer.MAX_VALUE;
//
//        //왼손움직임.
//        if (goal != R) {
//            res = Math.min(dfs(idx+1, goal, R) + totalD[L][goal], res);
//        }
//
//        //오른손 움직임.
//        if (goal != L) {
//            res = Math.min(dfs(idx+1, L, goal) + totalD[R][goal], res);
//        }
//
//        return dp[idx][L][R] = res;
//
//    }
//
//    public int solution(String numbers) {
//        init();
//        n = numbers.length();
//        dp = new int[n+1][10][10];
//        nums = numbers.toCharArray();
//
//        for (int i = 0; i < n+1; i++) {
//            for (int j = 0; j < 10; j++) {
//                Arrays.fill(dp[i][j], -1);
//            }
//        }
//        return dfs(0, 4, 6);
//    }
//
//    public void init() {
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (map[i][j] != -1) {
//                    hX.put(map[i][j], i);
//                    hY.put(map[i][j], j);
//                }
//            }
//        }
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 3; j++) {
//                for (int k = 0; k <= 9; k++) {
//                    if (map[i][j] == -1) continue;
//                    totalD[map[i][j]][k] = bfs(new Pair(i, j), k);
//                }
//            }
//        }
//    }
//}
//
