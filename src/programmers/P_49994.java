package programmers;
import java.util.*;

public class P_49994 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public int[] getDirs(String dirs) {
        int[] dir = new int[dirs.length()];
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            switch(c) {
                case 'U': dir[i] = 0; break;
                case 'D': dir[i] = 1; break;
                case 'R': dir[i] = 2; break;
                case 'L': dir[i] = 3; break;
            }
        }
        return dir;
    }
    public String makePath(int x, int y, int nxt_x, int nxt_y) {
        return x+","+y+","+nxt_x+","+nxt_y;
    }
    public int solution(String dirs) {

        int[] dir = getDirs(dirs);
        int res = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int x = 0, y = 0;
        for (int i = 0; i < dir.length; i++) {
            int nxt_x = x+dx[dir[i]];
            int nxt_y = y+dy[dir[i]];
            if (nxt_x < -5 || nxt_y < -5 || nxt_x > 5 || nxt_y > 5) continue;

            String path = makePath(x,y,nxt_x, nxt_y);
            //반대 방향도 생각해줘야한다!
            String reverse_path = makePath(nxt_x,nxt_y,x,y);
            x = nxt_x;
            y = nxt_y;
            if (!hm.containsKey(path) && !hm.containsKey(reverse_path)) {
                hm.put(path, 1);
                hm.put(reverse_path,1);
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        P_49994 p = new P_49994();
        System.out.println(p.solution("ULURRDLLU"));
        System.out.println(p.solution("LULLLLLLU"));
        /*
        경로를 (x,y,nxt_x,nxt_y) 를 해쉬맵에 저장하여
        다음에도 같은 경로가 나오면 res를 추가 안하도록 함.
         */
    }
}
