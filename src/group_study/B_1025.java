package group_study;

import java.io.*;
import java.util.*;
/*
제곱근 구하기 (골5)
 */
public class B_1025 {
    private static String[][] data = new String[9][9];
    private static int ans = -1;
    private static HashMap<String, Integer> sqrt_map = new HashMap<>();

    private static void fill_sqrt() { //	20352kb	256ms
        double max_num = Math.sqrt(999999999); //나올 수 있는 최대 숫자의 제곱근까지 넣는다.
        for (int i = 0; i <= max_num+1; i++ ) {
            sqrt_map.put(String.valueOf(i*i), 1);
        }
    }

    private static boolean is_sqrt(String s) { //16520kb 180ms
        int num = Integer.parseInt(s);
        if (Math.pow((int) Math.sqrt(num),2) == num) return true;
        return false;
    }

    private static void func(int n, int m) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                for (int x = -n; x < n; x++) { //행의 등차값
                    for (int y = -m; y < m; y++) { //열의 등차값
                        if (x == 0 && y == 0) continue;
                        int ii = i, jj = j;
                        String now = "";

                        while (ii >= 0 && ii < n && jj >= 0 && jj < m) {
                            now += data[ii][jj];
                            //System.out.println(now);
                            if (is_sqrt(now)) ans = Math.max(ans, Integer.parseInt(now)); //이게 더 빠름.
                            //if (sqrt_map.containsKey(now)) ans = Math.max(ans, Integer.parseInt(now));
                            ii += x;
                            jj += y;
                        }
                        if (is_sqrt(now)) ans = Math.max(ans, Integer.parseInt(now));
                    }
                }
            }
        }
    }

    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            data[i] = br.readLine().split("");
        }

        fill_sqrt();
        func(n,m);
        System.out.println(ans);


    }
}

/*
    제곱근 구하기
    완전탐색
    모든 경우의 수를 구해, 각 숫자들이 제곱근이 맞는지 확인해야한다.
    행과 열 등차를 구하는 것이 어려웠고, 결국 타 블로그를 참고했다.
ㅜㅜ
 */









