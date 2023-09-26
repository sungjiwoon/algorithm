package algo_class;
import java.util.*;
import java.io.*;
public class Solution6_2 {

    int answer;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public void DFS(int r, int c, int[][] board){
        if (r < 0 || c < 0 || r >= board.length || c >= board.length) return;

        if (board[r][c] == 1) {
            board[r][c] = 0;
        } else {
            return;
        }

        for (int k = 0; k < 4; k++) {
            int rr = r + dr[k];
            int cc = c + dc[k];
            DFS(rr, cc, board);
        }

    }
    public int solution(int[][] board){
        answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    DFS(i, j, board);
                    answer++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Solution6_2 T = new Solution6_2();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 1, 1, 0, 1}, {1, 1, 1, 0, 1}, {0, 0, 1, 0, 0}, {1, 1, 0, 1, 0}, {1, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 0, 0}, {0, 1, 1, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 1, 0}, {0, 0, 1, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 0, 0, 1}, {0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 0, 0}}));
    }
}
