package group_study;

import java.io.*;
import java.util.*;

public class B_1101 {
    static int n, m;
    static int[][] data;
    static ArrayList<Integer>[] cards;
    static int[] boxes;
    private static int solve(int joker) {
        int move = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (joker == i) continue;

            if (boxes[i] == 0) continue;
            else if (boxes[i] > 1) move++;
            else {
                for (int j = 0; j < m; j++) {
                    //안풀래....

                }
            }

        }
        return move;
    }
    private static void cnt_card() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j] == 1) cards[i].add(j);
            }
        }
    }
    private static void cnt_boxes() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (data[i][j] > 0) boxes[i]++;
            }
        }
    }
    public void work() throws IOException {

        input(new BufferedReader(new InputStreamReader(System.in)));

        cnt_card(); //각 카드마다 분산된 박스들의 번호를 담는 배열 완성
        cnt_boxes(); //각 박스마다 카드 종류의 수를 구하는 함수.

        //각각의 박스를 조커라고 생각하며 최솟값 도출.
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, solve(i));
        }
    }
    private static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        data = new int[n][m];
        for (int i = 0; i < n; i++) {
            data[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        boxes = new int[n];
        cards = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            cards[i] = new ArrayList();
        }

    }
}
