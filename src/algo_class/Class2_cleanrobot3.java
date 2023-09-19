package algo_class;
import java.util.*;

public class Class2_cleanrobot3 {

    public int[] solution(int[][] board, int k){
        int n = board.length;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int dir = 1;
        int x = 0, y = 0;
        //장애물 만나면 시계방향 90 -> dir + 1 % 4;
        for (int i = 0; i < k; i++) {
            int xx = x + dx[dir];
            int yy = y + dy[dir];
            if (xx < 0 || yy < 0 || xx >= n || yy >= n || board[xx][yy] == 1) {
                dir = (dir + 1) % 4;
                continue;
            }
            x = xx;
            y = yy;
        }
        return new int[]{x,y};
    }

    public static void main(String[] args){
//        Solution T = new Solution();
        Class2_cleanrobot3 T = new Class2_cleanrobot3();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }

}
