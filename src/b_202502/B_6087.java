package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// 240202 백준 레이저통신, BFS, 다익스트라
public class B_6087 {
    int w, h;
    char[][] map;
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    final int INF = 20000;

    void solve() {

        int stX = -1, stY = -1;
        int enX = -1, enY = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 'C') {
                    if (stX == -1) {
                        stX = i;
                        stY = j;
                    } else {
                        enX = i;
                        enY = j;
                        break;
                    }
                }
            }
        }

        PriorityQueue<int[]> qu = new PriorityQueue<>((o1, o2) -> o1[3]-o2[3]);

        int[][][] vis = new int[h][w][4];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                Arrays.fill(vis[i][j], INF);
            }
        }

        // {x,y,dir, v} -> x,y,방향(0,1,2,3), 거울의 갯수
        for (int k = 0; k < 4; k++) {
            int nx = stX + dx[k], ny = stY + dy[k];
            if (nx<0 || ny<0 || nx>=h || ny>=w || map[nx][ny] == '*') continue;
            qu.add(new int[] {nx, ny, k, 0});
            vis[stX][stY][k] = 0;
        }


        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            int x = q[0], y = q[1], dir = q[2], mi = q[3];
            if (mi > vis[x][y][dir]) continue;

//            System.out.println(x+" "+y+" -> " +dir + " mi: "+ mi);

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx<0 || ny<0 || nx>=h || ny>=w || map[nx][ny] == '*') continue;
                if (dir == k && vis[nx][ny][k] > mi) {
//                  System.out.println("dir eq["+k+"]: " + nx + " "+ny + " " + vis[nx][ny][k] + " st");
                    vis[nx][ny][k] = mi;
//                  System.out.println("dir eq["+k+"]: " + nx + " "+ny + " " + vis[nx][ny][k] + " en");
                    qu.add(new int[] {nx, ny, k, mi});
                } else if (dir != k && vis[nx][ny][k] > mi + 1){
                    vis[nx][ny][k] = mi + 1;
//                  System.out.println("dir n["+k+"]: " + nx + " "+ny + " " + vis[nx][ny][k]);
                    qu.add(new int[] {nx, ny, k, mi+1});
                }
            }
        }

//        for (int i = 0; i < h; i++) {
//            for (int j = 0; j < w; j++) {
//                System.out.print(String.format("%5d",laser[i][j]) + " ");
//            }
//            System.out.println();
//        }
        int min = vis[enX][enY][0];
        for (int k = 1; k < 4; k++) {
            min = Math.min(vis[enX][enY][k], min);
        }
        System.out.println(min);


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
            }
            solve();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_6087 b = new B_6087();
        b.init();
    }
}
