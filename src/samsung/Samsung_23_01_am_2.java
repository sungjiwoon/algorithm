package samsung;

import java.util.*;
import java.io.*;

/*
토끼와 경주 (23년 상반기 오전 2번)
구현구현..
 */

// 객체 분리를 잘하자...
// 값이 자주 바뀌는 부분은 배열로 따로 빼서 id로 관리하기.
public class Samsung_23_01_am_2 {
    int q, n, m, p;
    Rabit[] rabitList;
    HashMap<Integer, Integer> idxToId = new HashMap<>();
    ArrayList<String> raceList = new ArrayList<>();
    PriorityQueue<Rabit> qu;
    int[] d;
    long[] score;
    long totalSum = 0;

    class Pair implements Comparable<Pair> {
        int x, y;

        Pair (int x, int y) {
            this.x = x;
            this.y = y;
        }

        int sum() {return this.x + this.y;}

        @Override
        public int compareTo(Pair o) {
            //행+열 큰 -> 행 큰 -> 열 큰
            if (this.sum() != o.sum()) return o.sum() - this.sum();
            if (this.x != o.x) return o.x - this.x;
            return o.y - this.y;
        }
    }

    class Rabit implements Comparable<Rabit> {
        int pid;
        Pair loc;
        int jump; //총 점프 횟수
        public Rabit(int pid) {
            this.pid = pid;
            this.loc = new Pair(1, 1);
            this.jump = 0;
        }

        @Override
        public int compareTo(Rabit o) {
            //필요한 것
            //총 점프 횟수, 토끼의 위치, 고유번호
            if (this.jump != o.jump) return this.jump - o.jump;
            if (this.loc.sum() != o.loc.sum()) return this.loc.sum() - o.loc.sum();
            if (this.loc.x != o.loc.x) return this.loc.x - o.loc.x;
            if (this.loc.y != o.loc.y) return this.loc.y - o.loc.y;
            return this.pid - o.pid;
        }
    }

    public Pair up(int x, int y, int dis) {
        dis %= 2 * (n-1);

        /*
        격자선에서 다시 내 자신으로 돌아올려면 이동거리가 2 *(n-1)이 되어야한다.
        P' = P % (2 * (n-1))
        즉, 현재 열 위치를 c라 했을 때 맨 오른쪽까지 이동하는 데 남은 거리가
        m - 1 - c이 되므로 m - 1 - c <= P'인 경우라면 c값에 P'을 더해주고 종료하면 됩니다.

        */

        if (dis >= x-1) {
            dis -= (x-1);
            x = 1;
        } else {
            x -= dis;
            dis = 0;
        }

        if (dis >= n - x) {
            dis -= (n - x);
            x = n;
        } else {
            x += dis;
            dis = 0;
        }

        x -= dis;
        return new Pair(x, y);
    }

    public Pair down(int x, int y, int dis) {
        dis %= 2 * (n-1);

        if (dis >= n - x) {
            dis -= (n - x);
            x = n;
        } else {
            x += dis;
            dis = 0;
        }

        if (dis >= x - 1) {
            dis -= (x - 1);
            x = 1;
        } else {
            x -= dis;
            dis = 0;
        }

        x += dis;
        return new Pair(x, y);
    }

    public Pair left(int x, int y, int dis) {
        dis %= 2 * (m-1);

        if (dis >= y - 1) {
            dis -= (y - 1);
            y = 1;
        } else {
            y -= dis;
            dis = 0;
        }

        if (dis >= m - y) {
            dis -= (m - y);
            y = m;
        } else {
            y += dis;
            dis = 0;
        }
        y -= dis;
        return new Pair(x, y);
    }

    public Pair right(int x, int y, int dis) {
        dis %= 2 * (m-1);

        if (dis >= m - y) {
            dis -= (m - y);
            y = m;
        } else {
            y += dis;
            dis = 0;
        }

        if (dis >= y - 1) {
            dis -= (y - 1);
            y = 1;
        } else {
            y -= dis;
            dis = 0;
        }

        y += dis;
        return new Pair(x, y);
    }

    // public int isRangeX(int x) {
    //     if (x > 0 && x <= n) return x;
    //     else if (x <= 0) x = isRangeX(x * -1 + 2);
    //     else if (x > n) x = isRangeX(n - (x - n));
    //     return x;

    // }

    // public int isRangeY(int y) {
    //     if (y > 0 && y <= m) return y;
    //     if (y <= 0) y = isRangeY(y * -1 + 2);
    //     else if (y > m) y = isRangeY(m - (y - m));
    //     return y;
    // }

    public void proceedRace(int k, int s) {
        boolean[] isJump = new boolean[p+1];

        //k번 턴.
        for (int i = 0; i < k; i++) {
            Rabit priRabit = qu.poll();

            // System.out.print(i + "번:"+priRabit.pid);

            int x = priRabit.loc.x;
            int y = priRabit.loc.y;
            int dis = d[idxToId.get(priRabit.pid)];
            Pair[] pairList = new Pair[4];

            pairList[0] = up(x, y, dis);
            pairList[1] = down(x, y, dis);
            pairList[2] = left(x, y, dis);
            pairList[3] = right(x, y, dis);

            Arrays.sort(pairList);
            Pair pp = pairList[0];
            //System.out.println(" " +x+","+y+"->"+pp.x+","+pp.y);

            totalSum += (pp.x + pp.y);
            score[idxToId.get(priRabit.pid)] -= (pp.x + pp.y);

            priRabit.jump++;
            isJump[idxToId.get(priRabit.pid)] = true;
            priRabit.loc = new Pair(pp.x, pp.y);

            qu.offer(priRabit);
        }

        //모두 진행된 후에 우선순위대로 정렬 후 -> (+s)
        Arrays.sort(rabitList, (o1, o2) -> {
            int com = o1.loc.compareTo(o2.loc);
            if (com != 0) return com;
            return o2.pid - o1.pid;
        });

        for (Rabit rr : rabitList) {
            if (!isJump[idxToId.get(rr.pid)]) continue;
            score[idxToId.get(rr.pid)] += s;
            return;
        }

    }

    public void modifyDistance(int pid_t, int l) {
        d[idxToId.get(pid_t)] *= l;
    }

    public void finalRace() {
        long max = 0;
        for (long l : score) {
            max = Math.max(max, l + totalSum);
        }
        System.out.println(max);
    }

    public void init() {
        qu = new PriorityQueue<>();
        for (Rabit r : rabitList) {
            qu.offer(r);
        }
    }

    public void solve(String race) {

        String[] races = race.split(" ");
        int raceNum = Integer.parseInt(races[0]);
        switch (raceNum) {
            case 200 :
                //경주 진행
                int k = Integer.parseInt(races[1]);
                int s = Integer.parseInt(races[2]);
                proceedRace(k, s);
                break;
            case 300 :
                //이동 거리 변경
                int pid_t = Integer.parseInt(races[1]);
                int l = Integer.parseInt(races[2]);
                modifyDistance(pid_t, l);
                break;
            case 400:
                //최고의 토끼 선정.
                finalRace();
                // System.out.println(totalSum);
                break;
        }

    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Samsung_23_01_am_2 m = new Samsung_23_01_am_2();
        m.input();
    }
    public void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            q = Integer.parseInt(br.readLine());

            //첫번 째 명령
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[1]);
            m = Integer.parseInt(sp[2]);
            p = Integer.parseInt(sp[3]);

            rabitList = new Rabit[p];
            d = new int[p];
            score = new long[p];
            int k = 0;
            for (int i = 0; i < p; i++) {
                int pid = Integer.parseInt(sp[4+k]);
                int dd = Integer.parseInt(sp[4+k+1]);
                idxToId.put(pid, i);
                k += 2;
                d[i] = dd;
                rabitList[i] = new Rabit(pid);
            }

            init();

            for (int i = 0; i < q - 1; i++) {
                solve(br.readLine());
            }
        } catch(Exception e) {}
    }
}

