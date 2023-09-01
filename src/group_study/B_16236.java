package group_study;

import java.io.*;
import java.util.*;

public class B_16236 {
    private static int[][] map;
    private static int n;
    private static Shark shark;
    static ArrayList<Fish> fishes;
    static class Shark {
        int x,y;
        int size, hp; //size = 아기상어 크기. hp = 크기에 도달하기 위한 에너지?
        Shark(int x, int y, int size, int hp) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.hp = hp;
        }
    }
    static class Fish implements Comparable<Fish>{
        int x, y, size, d;
        Fish(int x, int y, int size, int d) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.d = d;
        }

        @Override
        public int compareTo(Fish o) {
            //물고기 먹는 조건
            //거리가 가장 가까울수록 -> 거리가 같다면 좌표상 위에 있을수록 -> 둘다 같다면 좌표상 왼쪽에 있을수록.
            if (d != o.d) return d-o.d;
            if (x != o.x) return x-o.x;
            return y-o.y;
        }
    }
    private static PriorityQueue<Fish> bfs() {
        int[] dx = { 0, -1, 0, 1 };
        int[] dy = { -1, 0, 1, 0 };

        Queue<Shark> queue = new LinkedList<>();
        PriorityQueue<Fish> able_to_eat = new PriorityQueue<>();

        queue.add(shark);
        int[][] d = new int[n][n];

        while (!queue.isEmpty()) {
            Shark s = queue.poll();
            for (int k = 0; k < 4; k++) {
                int xx = s.x + dx[k];
                int yy = s.y + dy[k];
                if (xx < 0 || yy < 0 || xx >= n || yy >= n) continue;
                if (map[xx][yy] > shark.size || d[xx][yy] != 0) continue;
                d[xx][yy] = d[s.x][s.y] + 1;
                if (map[xx][yy] >= 1 && map[xx][yy] < shark.size) {
                    able_to_eat.add(new Fish(xx,yy,map[xx][yy],d[xx][yy]));
                }
                queue.add(new Shark(xx,yy, shark.size, shark.hp));
            }
        }

        return able_to_eat;

    }
    private static int solve() {
        int res = 0;

        //아기 상어의 위치에 따라 거리 다 재기.

        while (true) {

            PriorityQueue<Fish> able_eat = bfs();
            if (able_eat.isEmpty()) return res;

            Fish eat = able_eat.poll();
            map[eat.x][eat.y] = 0; //먹었으면 0 처리
            shark.x = eat.x;
            shark.y = eat.y;
            shark.hp++;
            res += eat.d;
            if (shark.hp == shark.size) {
                shark.size++;
                shark.hp = 0;
            }
        }

    }
    public static void main(String[] args) {
        input();

        System.out.println(solve());


        /*
        1. 아기상어 위치 갱신될 때마다 물고기들 위치 bfs() 통해 거리 알아냄.
        2. 물고기의 위치, bfs()한 거리 -> PriorityQueue , bfs() 할게 없다면 엄마상어 -> res 출력.
        3. 최솟값 꺼내서 먹고 아기상어 위치, 크기 갱신
        ->  res += d, 아기상어 = 먹은 물고기의 위치, 크기 충족되는지, 현재 hp++; hp가 size와 같아지면 size++;
         */


    }
    private static void input() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
               map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            fishes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 9) {
                        shark = new Shark(i,j,2, 0);
                        map[i][j] = 0;
                    } else if (map[i][j] >= 1) {
                        fishes.add(new Fish(i,j,map[i][j],Integer.MAX_VALUE));
                    }
                }
            }

        } catch (Exception e) {

        }
    }
}
