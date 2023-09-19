package algo_class;
import java.util.*;

public class Class2_moverobot {
    public int[] solution(String moves){

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int r = 0;
        int c = 0;
        int d = 1;
        for(char command : moves.toCharArray()){
            if(command == 'G'){
                r = r + dr[d];
                c = c + dc[d];
            }
            else if(command == 'R') d = (d + 1) % 4;
            else if(command == 'L') d = (d + 3) % 4;

        }
        return new int[]{r, c};
        // R -> 오른쪽 90 -> 시계방향
        // L -> 왼쪽 90 -> 반시계
        // G -> 마주보는 방향으로 이동.
    }

    public static void main(String[] args){
//        Solution T = new Solution();
        Class2_moverobot T = new Class2_moverobot();
        System.out.println(Arrays.toString(T.solution("GGGRGGG")));
        System.out.println(Arrays.toString(T.solution("GGRGGG")));
        System.out.println(Arrays.toString(T.solution("GGGGGGGRGGGRGGRGGGLGGG")));
        System.out.println(Arrays.toString(T.solution("GGLLLGLGGG")));
    }
}
