package algo_class;
import java.util.*;

//미로의 최단거리 통로 (BFS)
public class Solution5_2 {

    static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int solution(int[][] board){
        int size = board.length;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(0,0)); //시작 지점
        int[][] d = new int[size][size];
        // d[i][j] => (i,j) 좌표에서 최단 거리.
        int ans = 0;
        while (!qu.isEmpty()) {
            Pair q = qu.poll();
            //종료 지점.
            if (q.r == size - 1 && q.c == size - 1) {
                ans = d[q.r][q.c];
                break;
            }
            for (int k = 0; k < 4; k++) {
                int rr = q.r + dr[k];
                int cc = q.c + dc[k];
                if (rr < 0 || cc < 0 || rr >= size || cc >= size) continue;
                if (d[rr][cc] != 0) continue;
                d[rr][cc] = d[q.r][q.c] + 1;
                qu.add(new Pair(rr,cc));
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Solution5_2 T = new Solution5_2();
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(T.solution(arr));
    }
}
