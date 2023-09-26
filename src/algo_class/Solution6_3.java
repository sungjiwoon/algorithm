package algo_class;
import java.util.*;

public class Solution6_3 {

    int answer;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int cnt = 0;
    public void DFS(int r, int c, int[][] board){

        if (board[r][c] == 1) {
            board[r][c] = 0;
            cnt++;
        } else {
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nc < 0 || nr >= board.length || nc >= board.length) continue;
            DFS(nr, nc, board);
        }

    }
    public int[] solution(int[][] board){
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    DFS(i, j, board);
                    ans.add(cnt);
                    cnt = 0;
                }
            }
        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }


        return answer;
    }
    public static void main(String[] args){
        Solution6_3 T = new Solution6_3();
        System.out.println(Arrays.toString(T.solution(new int[][]{{0, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 1, 0}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 0, 1, 0, 0}, {1, 1, 0, 1, 0}, {1, 0, 1, 0, 0}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{0, 0, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 1, 0}, {0, 0, 1, 1, 0}})));
        System.out.println(Arrays.toString(T.solution(new int[][]{{0, 0, 0, 0, 1}, {0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 0, 0}})));
    }
}
