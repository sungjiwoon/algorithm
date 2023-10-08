package samsung;

import java.util.*;
import java.io.*;

public class Samsung_23_01_01 {
    int n, m, k;
    int[][] map;
    HashMap<Pair, Integer> hasPerson;
    Pair exit; //출구.

    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair) o;
                return (this.x == p.x) && (this.y == p.y);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int getD(Pair me) {
        return Math.abs(me.x - exit.x) + Math.abs(me.y - exit.y);
    }

    public int move() {
        //큐에 담긴 위치들을 출구와 가장 가깝게 이동시킨다.
        //출구라면, 탈출을 시킨다.
        //이동 시킨 다음 hashMap 에 값을 갱신시킨다.
        //이동한 만큼 sum++;
        int sum = 0;
        int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};

        HashMap<Pair, Integer> nh = new HashMap<>();

        for (Pair np : hasPerson.keySet()) {

            int v = hasPerson.get(np);
            if (v == 0) continue;

            Pair p = new Pair(np.x, np.y);
            System.out.print(p.x + " " + p.y + ":" + v + "명 ->");
            nh.put(np, 0); //기존 값 0으로.
            int minX = p.x, minY = p.y, minD = getD(p);

            for (int k = 0; k < 4; k++) {
                int xx = p.x + dx[k];
                int yy = p.y + dy[k];
                if (xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
                if (map[xx][yy] >= 1 && map[xx][yy] <= 9) continue;

                if (getD(new Pair(xx,yy)) < minD) {
                    minX = xx;
                    minY = yy;
                    minD = getD(new Pair(xx,yy));
                }
            }
            if (!(minX == p.x && minY == p.y)) {
                //움직일 수 있는 칸이 갱신됐다면,
                p.x = minX;
                p.y = minY;
                sum += v;
            }

            if (minD != 0) {
                //출구 도착하지 않았다면, 해시맵에 값을 담는다.
                System.out.println(p.x + " " + p.y);
                nh.put(p, v);
            } else {
                System.out.println(p.x + " " + p.y + " exit!! ");
                //nh.put(p, 0);
            }
        }

        for (Pair p : nh.keySet()) {
            hasPerson.put(p, nh.get(p));
        }
        return sum;
    }

    public boolean isOkSquare(Pair st, Pair en) {
        for (Pair p : hasPerson.keySet()) {
            if (hasPerson.get(p) < 1) continue;
            if (p.x >= st.x && p.x <= en.x && p.y >= st.y && p.y <= en.y) return true;
        }
        return false;
    }

    public void rotate90(Pair st, Pair en, int size) {
        int[][] tmp = new int[n][n];

        for (int i = st.x; i <= en.x; i++) {
            for (int j = st.y; j <= en.y; j++) {
                // 스텝 1) (st.x , st.y) -> (0, 0)
                // 스텝 2) 좌표 변경.
                int ox = i - st.x, oy = j - st.y;
                int rx = oy, ry = size - ox;
                tmp[rx + st.x][ry + st.y] = map[i][j];
            }
        }

        for (int i = st.x; i <= en.x; i++) {
            for (int j = st.y; j <= en.y; j++) {
                map[i][j] = tmp[i][j];
            }
        }

    }

    public void modify(Pair st, Pair en, int size) {

        for (int i = st.x; i <= en.x; i++) {
            for (int j = st.y; j <= en.y; j++) {
                if (map[i][j] >= 1 && map[i][j] <= 9) {
                    map[i][j]--;
                }
            }
        }

        HashMap<Pair, Integer> newPset = new HashMap<>();

        for (Pair tmpP : hasPerson.keySet()) {
            if (tmpP.x < st.x || tmpP.x > en.x || tmpP.y < st.y || tmpP.y > en.y) continue;

            int ox = tmpP.x - st.x, oy = tmpP.y - st.y;
            int rx = oy, ry = size - ox;
            Pair tmpTo = new Pair(st.x + rx, st.y + ry);

            newPset.put(tmpTo, hasPerson.get(tmpP));
            newPset.put(tmpP, 0);
        }

        for (Pair p : newPset.keySet()) {
            hasPerson.put(p, newPset.get(p));
        }

        int ox = exit.x - st.x, oy = exit.y - st.y;
        int rx = oy, ry = size - ox;

        exit.x = st.x + rx;
        exit.y = st.y + ry;
    }

    public void rotate() {
        /*
            1) 출구를 기준으로 가장 작은 정사각형을 잡음, 단 열과 행이 작은 순서대로,
            2) 90도 회전. (함수)
            3) map 검사해보면서 참가자가 있다면,
            -> 큐에 담음. ,
            -> 또 벽이 있다면 내구성 감소. (-1)
        */

        for (int k = 1; k < n; k++) {
            for (int i = 0; i + k < n; i++) {
                if (!(i <= exit.x && i + k >= exit.x)) continue;
                for (int j = 0; j + k < n; j++) {
                    if (!(j <= exit.y && j + k >= exit.y)) continue;
                    Pair st = new Pair(i, j);
                    Pair en = new Pair(i+k, j+k);
                    if (isOkSquare(st, en)) {
                        System.out.print("okSquare: ");
                        System.out.println(i + "," + j + " ~ " + (i+k) + "," + (j+k));
                        rotate90(st, en, k);
                        modify(st, en, k);
                        print();
                        return;
                    }
                }
            }
        }
    }

    public boolean empty() {
        for (Pair p : hasPerson.keySet()) {
            if (hasPerson.get(p) >= 1) return false;
        }
        return true;
    }

    public int solve() {
        int ans = 0;

        for (int i = 1; i <= k; i++) {
            ans += move();
            if (empty()) break;
            rotate(); //2. 회전
            System.out.println("" + (i) + "초 exit: " + exit.x + " " + exit.y + "\n");
        }

        return ans;
    }
    public void print() {

        for(int i = 0; i < n; i++) {
            for (int j = 0; j< n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
       // Main m = new Main();
        Samsung_23_01_01 m = new Samsung_23_01_01();
        m.input();

        int ans = m.solve();

        System.out.println(ans);
        System.out.println((m.exit.x+1) + " " + (m.exit.y+1));
    }
    public void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]);
            m = Integer.parseInt(sp[1]);
            k = Integer.parseInt(sp[2]);

            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            hasPerson = new HashMap<>();

            for (int i = 0; i < m; i++) {
                sp = br.readLine().split(" ");
                int x = Integer.parseInt(sp[0]) - 1;
                int y = Integer.parseInt(sp[1]) - 1;
                Pair p = new Pair(x, y);
                hasPerson.put(p, hasPerson.getOrDefault(p, 0) + 1);
            }

            sp = br.readLine().split(" ");
            int x = Integer.parseInt(sp[0]);
            int y = Integer.parseInt(sp[1]);
            exit = new Pair(x - 1, y - 1);

        } catch(Exception e) { }
    }
}