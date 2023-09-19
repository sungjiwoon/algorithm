package algo_class;
import java.util.*;

public class Class2_cleanrobot {
    public int[] solution(int n, String moves){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int[] dir = {'U', 'R', 'D', 'L'};
        int x = 0, y = 0;
        for (char commad : moves.toCharArray()) {
            for (int k = 0; k < 4; k++) {
                if (commad == dir[k]) {
                    int xx = x + dx[k];
                    int yy = y + dy[k];
                    if (xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
                    x = xx;
                    y = yy;
                }
            }
        }
        return new int[]{x,y};
    }

    public static void main(String[] args){
//        Solution T = new Solution();
        Class2_cleanrobot T = new Class2_cleanrobot();
        System.out.println(Arrays.toString(T.solution(5, "RRRDDDUUUUUUL")));
        System.out.println(Arrays.toString(T.solution(7, "DDDRRRDDLL")));
        System.out.println(Arrays.toString(T.solution(5, "RRRRRDDDDDU")));
        System.out.println(Arrays.toString(T.solution(6, "RRRRDDDRRDDLLUU")));
    }
}
