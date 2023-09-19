package algo_class;

import java.util.*;
class Class2_takewalkatthepark {
    public int[] get_start(String[] park) {
        int r=0,c=0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    r = i;
                    c = j;
                }
            }
        }
        return new int[]{r,c};
    }
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        HashMap<String, Integer> dirMap = new HashMap<>();
        dirMap.put("N", 0);
        dirMap.put("S", 2);
        dirMap.put("E", 1);
        dirMap.put("W", 3);

        int H = park.length;
        int W = park[0].length();
        int[] start = get_start(park);
        int r = start[0], c = start[1];

        for (String ro : routes) {
            String[] dir_sp = ro.split(" ");
            int dir = dirMap.get(dir_sp[0]);
            int mov = Integer.parseInt(dir_sp[1]);

            boolean flag = true;
            int nr = r, nc = c;
            for (int k = 1; k <= mov; k++) {
                nr = r + dr[dir] * k;
                nc = c + dc[dir] * k;
                if (nr < 0 || nc < 0
                        || nr >= H || nc >= W
                        || park[nr].charAt(nc) == 'X') {
                    flag = false;
                    break;
                }

            }
            if (!flag) continue;
            r = nr;
            c = nc;

        }
        answer[0] = r;
        answer[1] = c;
        return answer;
    }
}