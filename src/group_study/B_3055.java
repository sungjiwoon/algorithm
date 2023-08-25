package group_study;

import java.io.*;
import java.util.*;

public class B_3055 {
    private static int r,c;
    private static char[][] map;
    private static final String FAIL = "KAKTUS";
    static class Pair {
        int x,y;
        Pair (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static int bfs() {
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};

        Queue<Pair> me = new LinkedList<>(); //고슴도치 방문 큐
        Queue<Pair> water = new LinkedList<>(); //물이 번지는 큐

        int[][] d = new int[r][c]; //고슴도치가 해당 정점을 방문한 시간을 담는 배열.

        //고슴도치의 위치 && 물의 위치.
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') me.add(new Pair(i,j));
                if (map[i][j] == '*') water.add(new Pair(i,j));
            }
        }


        //
        /*
        메모리 초과가 계속 났던 이유: 고슴도치가 이동한 방문 경로는 계속 체크해줬는데, 물은 안해줌. ㅜ
        물의 이동 예정인 곳도 고슴도치는 방문을 못 하므로,
        물 먼저 방문 처리를 해주고 고슴도치 방문 처리를 해주었다.
        size 변수 사용 이유 : 물 이동 다음에 고슴 도치가 이동해야하므로 현재 큐에 담겨있는 것만 이동처리를 해주어야한다.
        고슴도치 큐가 비어있다는 뜻은 더이상 고슴도치가 비버의 굴로 가지 못한채 갖혔다는 뜻이므로 FIAL이다.
        return -1 : FAIL 표시.

        시간 복잡도 : 모든 정점을 방문하는 것이 최악의 시간복잡도.. O(50*50) -> 250?

         */


        while (!me.isEmpty()) {
            int size = water.size();

            for (int i = 0; i < size; i++) {
                Pair p = water.poll();
                for (int k = 0; k < 4; k++) {
                    int xx = p.x + dx[k];
                    int yy = p.y + dy[k];
                    if (xx < 0 || yy < 0 || xx >= r || yy >= c) continue;
                    if (map[xx][yy] == 'D' || map[xx][yy] == 'X' || map[xx][yy] == '*') continue;
                    map[xx][yy] = '*';
                    water.add(new Pair(xx,yy));
                }
            }

            size = me.size();

            for (int i = 0; i < size; i++) {
                Pair p = me.poll();
                for (int k = 0; k < 4; k++) {
                    int xx = p.x + dx[k];
                    int yy = p.y + dy[k];
                    if (xx < 0 || yy < 0 || xx >= r || yy >= c) continue;
                    if (map[xx][yy] == '*' || map[xx][yy] == 'X' || d[xx][yy] > 0) continue;
                    if (map[xx][yy] == 'D') {
                        return d[p.x][p.y] + 1;
                    }
                    d[xx][yy] = d[p.x][p.y] + 1;
                    me.add(new Pair(xx, yy));
                }
            }

        }

        return -1;


    }
    public static void main(String[] args) {
        input();
        int res = bfs();
        if (res >= 0) System.out.println(res);
        else System.out.println(FAIL);
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new char[r][c];
            for (int i = 0; i < r; i++) {
                map[i] = br.readLine().toCharArray();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
