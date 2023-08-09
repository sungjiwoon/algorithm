package group_study;

import java.io.*;
import java.util.*;
class Pair {
    int num, cnt;
    Pair (int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}
public class B_17140 {
    static int r,c,k;
    static int r_line, c_line;
    static int[][] data;
    static PriorityQueue<Pair> qu;
    private static void R() {
        //행의 값들을 HashMap에 넣는다.
        //행의 값들을 우선순위큐에 넣는다.
        //data 의 값을 다시 갱신한다.
        //모든 행 반복.
        int max_c_line = 0;
        for (int i = 0; i < r_line; i++) {

            HashMap<Integer, Integer> nums = new HashMap<>();
            ArrayList<Integer> keys = new ArrayList<>(); //hashMap 에 값들 뽑아내기 위한 key들, 즉 data의 원소들이 key다.

            for (int j = 0; j < c_line; j++) {
                if (nums.containsKey(data[i][j])) {
                    nums.put(data[i][j], nums.get(data[i][j]) + 1);
                } else {
                    nums.put(data[i][j], 1);
                    keys.add(data[i][j]);
                }
            }

            for (int key : keys) {
                if (key == 0) continue;
                qu.add(new Pair(key,nums.get(key)));
            }

            ArrayList<Integer> line = new ArrayList<>();
            while (!qu.isEmpty()) {
                Pair p = qu.poll();
                line.add(p.num);
                line.add(p.cnt);
            }


            for (int j = 0; j < 100; j++) {
                if (j >= line.size()) data[i][j] = 0;
                else data[i][j] = line.get(j);
            }

            max_c_line = Math.max(max_c_line, line.size());
            if (max_c_line > 100) max_c_line = 100;

        }
        c_line = max_c_line;


    }
    private static void C() {
        int max_r_line = 0;
        for (int i = 0; i < c_line; i++) {

            HashMap<Integer, Integer> nums = new HashMap<>();
            ArrayList<Integer> keys = new ArrayList<>(); //hashMap 에 값들 뽑아내기 위한 key들, 즉 data의 원소들이 key다.

            for (int j = 0; j < r_line; j++) {
                if (nums.containsKey(data[j][i])) {
                    nums.put(data[j][i], nums.get(data[j][i]) + 1);
                } else {
                    nums.put(data[j][i], 1);
                    keys.add(data[j][i]);
                }
            }

            for (int key : keys) {
                if (key == 0) continue;
                qu.add(new Pair(key,nums.get(key)));
            }

            ArrayList<Integer> line = new ArrayList<>();
            while (!qu.isEmpty()) {
                Pair p = qu.poll();
                line.add(p.num);
                line.add(p.cnt);
            }

            for (int j = 0; j < 100; j++) {
                if (j >= line.size()) data[j][i] = 0;
                else data[j][i] = line.get(j);
            }

            max_r_line = Math.max(max_r_line, line.size());
            if (max_r_line > 100) max_r_line = 100;
        }

        r_line = max_r_line;

    }

    public static void main(String[] args) throws NumberFormatException, IOException {


        input();

        int res = -1;

        for (int i = 0; i < 101; i++) {
            System.out.println("time: " + i);
            print();

            if (data[r-1][c-1] == k) {
                res = i;
                break;
            }

            if (r_line >= c_line) R();
            else C();



        }

        System.out.println(res);

    }
    private static void print() {
        System.out.println("r_line: " + r_line +", c_line: " + c_line);
        for (int i = 0; i < r_line; i++) {
            for (int j = 0; j < c_line; j++) {
                System.out.print(data[i][j]+ " ");
            }
            System.out.println();
        }

    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        data = new int[101][101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        r_line = c_line = 3;
        qu = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.cnt == o2.cnt) return o1.num - o2.num;
                return o1.cnt-o2.cnt;
            }
        });

    }
}
