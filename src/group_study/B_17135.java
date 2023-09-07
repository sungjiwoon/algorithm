package group_study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_17135 {
    static int n,m,d;
    static int ans = 0;
    static ArrayList<Pair> enemies = new ArrayList<>();
    static int[][] map;
    static class Pair {
        int x,y,d,index;
        boolean dead;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int solve(int[] arr) {

        Pair[] en_copied = new Pair[enemies.size()];
        for (int i = 0; i < enemies.size(); i++) {
            Pair p = new Pair(enemies.get(i).x, enemies.get(i).y);
            en_copied[i] = p;
        }

        Comparator<Pair> com = (o1,o2) -> {
            if (o1.d == o2.d) return o1.y - o2.y;
            return o1.d - o2.d;
        };

        int res = 0; //궁수가 죽인 애들
        int trueCnt = 0; //죽은 애들
        while (trueCnt < enemies.size()) {

            Queue<Integer> deadQueue = new LinkedList<>();
            //1. 거리를 모두 재어 가장 가까운 애 죽인다.
            for (int i = 0; i < 3; i++) {
                Pair g = new Pair(n, arr[i]); //궁수의 위치
                PriorityQueue<Pair> attack = new PriorityQueue<>(com); //궁수가 죽일수 있는 애들
                for (int j = 0; j < en_copied.length; j++) {
                    if (en_copied[j].dead) continue;
                    Pair e = en_copied[j];
                    e.d = count_d(e, g);
                    e.index = j;
                    attack.add(e);
                }
                if (attack.isEmpty() || attack.peek().d > d) continue;
                deadQueue.add(attack.poll().index); //죽은 적들 담는 곳.
            }

            //2. 궁수가 죽인 놈들 세기.
            int tmp = 0; //실제로 죽인애들이 담기고
            while (!deadQueue.isEmpty()) {
                int dq = deadQueue.poll();
                if (en_copied[dq].dead) continue;
                en_copied[dq].dead = true;
                tmp++;
            }

            //3. 결과 값 추가. + 적들 아래로 이동.
            res += tmp;

            for (int i = 0; i < en_copied.length; i++) {
                if (en_copied[i].dead) continue;

                if (en_copied[i].x+1 >= n) {
                    en_copied[i].dead = true; //죽임.
                } else {
                    en_copied[i].x++; //아래로 이동.
                }

            }
            //4. 죽은애들 다시 세보기.
            trueCnt = 0;
            for (int i = 0; i < en_copied.length; i++) {
                if (en_copied[i].dead) trueCnt++;
            }

        }

        return res;

    }
    static int count_d(Pair e, Pair g) {
        return Math.abs(e.x - g.x) + Math.abs(e.y - g.y);
    }
    static void combination(int depth, int[] arr, int st, boolean[] vis) {
        if (depth == 3) {
//            int a = solve(arr);
//            System.out.println(Arrays.toString(arr) + a);
            ans = Math.max(ans, solve(arr));
            return;
        }
        for (int i = st; i < m; i++) {
            if (!vis[i]) {
                vis[i] = true;
                arr[depth] = i;
                combination(depth+1, arr, i+1, vis);
                vis[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        input();
        combination(0,new int[3], 0, new boolean[m]); //n칸 C 3(궁수의 수)
        System.out.println(ans);
    }
    private static void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            map= new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            //적의 위치 계산
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 1) {
                        enemies.add(new Pair(i,j));
                    }
                }
            }

        } catch (Exception e) {}
    }
}
