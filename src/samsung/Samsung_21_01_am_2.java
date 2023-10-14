package samsung;
import java.util.*;
import java.io.*;

//색깔 폭탄 (골드2)
public class Samsung_21_01_am_2  {
    int n, m;
    int[][] map;
    long score = 0;
    final int Black = -1, Red = 0, Bombed = -2, Blank = -3;
    boolean[][] vis;

    PriorityQueue<Bomb> pQ;

    class Pair {
        int x, y;
        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Bomb {
        List<Pair> bombList;
        Pair stand; //기준 점.
        int cnt = 0; //레드의 갯수.
        Bomb (List<Pair> bombList, Pair stand, int cnt) {
            this.bombList = bombList;
            this.stand = stand;
            this.cnt = cnt;
        }
    }


    public void rotate270() {
        //반시계 회전.
        int[][] newMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMap[i][j] = map[j][n-1-i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = newMap[i][j];
            }
        }
    }

    public boolean isRange(int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < n);
    }

    public boolean dontVis(int x, int y) {
        return (map[x][y] == Black || map[x][y] == Red || map[x][y] == Bombed || map[x][y] == Blank);
    }

    public void visRedToFalse() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == Red) {
                    vis[i][j] = false;
                }
            }
        }
    }

    public void sortBombList(List<Pair> bombList) {
        int r_cnt = 0;

        Collections.sort(bombList, (o1, o2) -> {
            if (o1.x != o2.x) return o2.x - o1.x;
            return o1.y - o2.y;
        });

        Pair stand = new Pair(-1, -1);
        for (Pair b : bombList) {
            if (map[b.x][b.y] == Red) r_cnt++;
            else if (stand.x == -1) {
                stand.x = b.x;
                stand.y = b.y;
            }
        }

        pQ.offer(new Bomb(bombList, stand, r_cnt));
        //System.out.println("stand: " + stand.x +"," + stand.y +" size: " + bombList.size() +", redCnt: " + r_cnt);

    }
    public void bfs() {
        int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};

        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dontVis(i, j) || vis[i][j]) continue;
                List<Pair> bombList = new ArrayList<>();

                Queue<Pair> qu = new LinkedList<>();
                qu.add(new Pair(i, j));
                vis[i][j] = true;
                int color = map[i][j];

                while (!qu.isEmpty()) {
                    Pair p = qu.poll();
                    bombList.add(new Pair(p.x, p.y));
                    for (int k= 0; k < 4; k++) {
                        int xx = p.x + dx[k];
                        int yy = p.y + dy[k];

                        if (isRange(xx,yy) && !vis[xx][yy] && (map[xx][yy] == color || map[xx][yy] == Red)) {
                            qu.add(new Pair(xx, yy));
                            vis[xx][yy] = true;
                        }
                    }
                }

                //레드 폭탄은 여러번 들어갈 수 있으므로 방문 여러번 가능.
                visRedToFalse();
                if (bombList.size() <= 1) continue;
                sortBombList(bombList);

            }
        }

    }

    public void init() {
        pQ = new PriorityQueue<>((o1, o2) -> {
            // 레드가 가장 적은 칸 -> 행이 큰칸 -> 열이 작은칸.
            if (o1.bombList.size() != o2.bombList.size()) return o2.bombList.size() - o1.bombList.size();
            if (o1.cnt != o2.cnt) return o1.cnt - o2.cnt;
            if (o1.stand.x != o2.stand.x) return o2.stand.x - o1.stand.x;
            return o1.stand.y - o2.stand.y;
        });
    }

    public void poll() {
        //중력
        for (int j = 0; j < n; j++) {
            boolean[] down = new boolean[n];
            for (int i = n-1; i >= 1; i--) {
                if (map[i][j] == Blank) {
                    for (int k = i-1; k >= 0; k--) {
                        if (map[k][j] == Black) break;
                        if (map[k][j] == Blank) continue;
                        if (down[k]) continue;
                        down[k] = true;
                        map[i][j] = map[k][j];
                        map[k][j] = Blank;
                        break;
                    }
                }
            }
        }

    }


    public void remove(Bomb bomb) {
        int size = bomb.bombList.size();
        score += size * size;

        for (Pair b: bomb.bombList) {
            map[b.x][b.y] = Blank;
        }

        // System.out.println("remove 1차::");
        // print();

    }

    public void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void solve() {
        while (true) {
            init();

            //1. 폭탄 묶음 찾기 (2개 이상인 경우만)
            //폭탄 묶음이 없다면 -> break;
            bfs();
            if (pQ.isEmpty()) break;

            //2. 가장 큰 폭탄 묶음 찾기.
            Bomb bomb = pQ.poll();
            //System.out.println("Bomb!!: " + bomb.stand.x +"," + bomb.stand.y +" size: " + bomb.bombList.size() +", redCnt: " + bomb.cnt);


            //3. 폭탄 제거. (사이즈 * 사이즈)
            //4. 검정 돌 밑에 있는 폭탄들 전부 내려옴.
            remove(bomb);
            poll();
            // System.out.println("remove::");
            // print();

            //5. 반시계 90도 회전
            rotate270();
            poll();
            // System.out.println("rotated::");
            // print();

            //6. 중력 적용.


        }
        System.out.println(score);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Samsung_21_01_am_2  m = new Samsung_21_01_am_2 ();
        m.input();
        m.solve();
    }
    public void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = nm[0];
            m = nm[1];

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        } catch (Exception e) {}
    }
}

