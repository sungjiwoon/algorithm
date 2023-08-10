package group_study;
import java.io.*;
import java.util.*;
public class B_1105_02 {
    static int L,R;

    private static int count_8(int n) {
        int cnt = 0;
        while (n != 0) {
            if (n % 10 == 8) cnt++;
            n /= 10;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        input();

        //1) L부터 R까지 8의 갯수 다 구해본다?
        //8의 갯수 구하는 방법: 나머지 연산을 통해 구한다.
        //모든 수의 8의 갯수를 다 구한다. 단, 0개가 나오면 바로 탈출. (과부하를 막기위해)
        //1부터는 min 값을 갱신시킨다.
        int min = 10;
        for (int i = L; i <= R; i++) {
            min = Math.min(min, count_8(i));
            if (min == 0) break;
        }
        System.out.println(min);


    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
    }
}
