package group_study;

import java.util.*;

/*
프로그래머스 레벨2 : 리코쳇 로봇
사용 알고리즘 : BFS

리코쳇 로봇이라는 보드게임이 있습니다.

이 보드게임은 격자모양 게임판 위에서 말을 움직이는 게임으로, 시작 위치에서 목표 위치까지 최소 몇 번만에 도달할 수 있는지 말하는 게임입니다.

이 게임에서 말의 움직임은 상, 하, 좌, 우 4방향 중 하나를 선택해서 게임판 위의 장애물이나 맨 끝에 부딪힐 때까지 미끄러져 이동하는 것을 한 번의 이동으로 칩니다.

다음은 보드게임판을 나타낸 예시입니다.

 */
public class P_231019 {
    int n, m;
    char[][] map;

    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Pair getStart() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'R') {
                    return new Pair(i, j);
                }
            }
        }
        return new Pair(-1, -1);
    }

    public int bfs() {
        int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
        Pair st = getStart();

        Queue<Pair> qu = new LinkedList<>();
        qu.add(st);

        int[][] d = new int[n][m];

        while (!qu.isEmpty()) {
            Pair p = qu.poll();
            if (map[p.x][p.y] == 'G') {
                return d[p.x][p.y];
            }

            int cnt = d[p.x][p.y];

            for (int k = 0; k < 4; k++) {
                int x = p.x, y = p.y;

                while (true) {
                    int tmpX = x, tmpY = y;
                    x += dx[k];
                    y += dy[k];
                    if (x < 0 || y < 0 || x >= n || y >= m || map[x][y] == 'D') {
                        //다음 x,y 지점이 범위를 초과하거나 장애물을 만났을 때에는 반복문 탈출.
                        if (d[tmpX][tmpY] == 0) {
                            qu.add(new Pair(tmpX, tmpY));
                            d[tmpX][tmpY] = cnt + 1;
                        }
                        break;
                    }
                }
            }
        }

        return -1;
    }

    public int solution(String[] board) {

        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = board[i].toCharArray();
        }

        return bfs();
    }
}
