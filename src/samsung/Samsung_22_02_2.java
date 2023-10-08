package samsung;


import java.util.*;
import java.io.*;

public class Samsung_22_02_2 {
    int n, m;
    ArrayList<Pair> person;
    Queue<Pair> presentLoc = new LinkedList<>();
    int[][] map;
    int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    Pair EMPTY = null;
    int[][] d = new int[16][16];

    class Pair {
        int index;
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Pair(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }
    private void bfs(Pair st, Pair en) {
        //최단 거리 구하기.
        //각 위치마다 출발지점까지의 거리를 담음.
        //en -> 목표 지점 (편의점)
        //만약 베이스캠프를 찾는 목적이라면, en == null

        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }

        Queue<Pair> qu = new LinkedList<>();
        qu.add(st); //st -> 출발지
        d[st.x][st.y] = 0;

        while (!qu.isEmpty()) {
            Pair p = qu.poll();

            for (int k = 0; k < 4; k++) {
                int xx = p.x + dx[k];
                int yy = p.y + dy[k];
                if (xx < 0 || yy < 0 || xx >= n || yy >= n) continue;

                //이동할 수 없는 위치 or 한번 이동했던 위치라면,
                if (map[xx][yy] == -1 || d[xx][yy] < Integer.MAX_VALUE) continue;

                d[xx][yy] = d[p.x][p.y] + 1;

                if (en == EMPTY) {
                    if (map[xx][yy] == 1) {
                        //베이스 캠프 위치로 발견.
                        presentLoc.offer(new Pair(st.index, xx, yy));
                        map[xx][yy] = -1;
                        return;
                    }
                } else {
                    if (xx == en.x && yy == en.y) {
                        //System.out.println("편의점 발견: " + xx+","+yy);
                        return;
                    }
                }
                qu.add(new Pair(xx,yy));
            }
        }

    }

    public void allMoveOneStep(int second) {

        int size = presentLoc.size();
        for (int i = 0; i < size; i++) {

            //1. 현 위치에서 편의점까지의 최소 거리를 d에 담는다.
            Pair ps = presentLoc.poll();
            //System.out.println(second+"초(" + ps.index + "): " + ps.x + "," + ps.y);
            Pair goal = person.get(ps.index); //편의점
            bfs(goal, ps); //편의점 -> 베이스캠프까지의 최단 거리를 담아야함.

            //2. 베이스캠프 -> 편의점 가는 길로 one step. (우선순위 대로 )
            int minX = ps.x, minY = ps.y, minD = Integer.MAX_VALUE;
            for (int k = 0; k < 4; k++) {
                int xx = ps.x + dx[k];
                int yy = ps.y + dy[k];
                if (xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
                if (d[xx][yy] < minD) {
                    minX = xx;
                    minY = yy;
                    minD = d[xx][yy];
                }
            }
            //3. 만약 이동한 칸이 편의점과 동일하다면,
            //편의점 칸을 -1로 처리 (이동 x)
            //편의점 완료 했기 때문에 큐 아웃.
            //동일하지 않다면, 아직 이동중이므로 큐에 값 삽입.

            if (minX == goal.x && minY == goal.y) {
                // System.out.println("편의점 발견해서 값 수정" + second + "초:" + minX+","+minY);
                map[minX][minY] = -1;
            } else {
                presentLoc.offer(new Pair(ps.index, minX, minY));
            }

        }

        //1. 일단 베이스 캠프로 이동한다.
        //cf. 베이스캠프 이동한 이후로는 베이스캠프 있는 칸을 지나갈 수 없음.
        // map[b.x][b.y] = -1;
        //큐에 새로운 사람(베이스 캠프에 도착한 사람) 넣음. 만약 베이스캠프에 도착한 사람이 없다면,
        //넘어감.
        if (second <= m) {
            Pair goBase = person.get(second-1);
            bfs(new Pair(goBase.index, goBase.x, goBase.y), EMPTY);
        }


    }
    public int solve() {
        int second = 1;
        while (true) {
            allMoveOneStep(second);
            //편의점에 모두 도착했다 -> 큐가 비었다.
            if (presentLoc.isEmpty()) break;
            second++;
        }
        return second;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        Samsung_22_02_2 M = new Samsung_22_02_2();
        M.input();
        int ans = M.solve();
        System.out.println(ans);

    }
    public void input() {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));

            String[] st = br.readLine().split(" ");
            n = Integer.parseInt(st[0]);
            m = Integer.parseInt(st[1]);

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
            }
            person = new ArrayList<>();
            for (int i = 0; i < m; i++){
                int[] loc = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                person.add(new Pair(i, loc[0]-1, loc[1]-1));
            }
        } catch (Exception e) {}
    }
}
