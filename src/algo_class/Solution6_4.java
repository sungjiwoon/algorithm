package algo_class;
import java.util.*;

//무인도여행 (프로그래머스) : https://school.programmers.co.kr/learn/courses/30/lessons/154540
public class Solution6_4 {
    int cnt = 0;
    int[] dr = {-1,0,1,0};
    int[] dc = {0,1,0,-1};

    public void dfs(char[][] board, int r, int c){

        if (board[r][c] == 'X') return;
        cnt += board[r][c] - '0';
        board[r][c] = 'X';

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr<0 || nc<0 || nr>= board.length || nc >= board[0].length) continue;
            dfs(board, nr, nc);
        }
    }
    public int[] solution(String[] maps) {
        ArrayList<Integer> cntList = new ArrayList<>();
        char[][] board = new char[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++){
            board[i] = maps[i].toCharArray();

        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'X') {
                    cnt = 0;
                    dfs(board, i, j);
                    cntList.add(cnt);
                }
            }
        }


        if (cntList.isEmpty()) {
            return new int[]{-1};
        }

        int[] answer = new int[cntList.size()];
        for (int i = 0; i < cntList.size(); i++) {
            answer[i] = cntList.get(i);
        }

        Arrays.sort(answer);
        return answer;
    }
}

