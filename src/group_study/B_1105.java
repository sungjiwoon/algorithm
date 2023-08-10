package group_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1105 {
    static String L,R;
    private static int solve() {
        int cnt = 0;
        for (int i = 0; i < L.length(); i++) {
            if (L.charAt(i) == R.charAt(i) && L.charAt(i) == '8') cnt++;
            else if (L.charAt(i) != R.charAt(i)) return cnt;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        input();

        int min = 0;
        if (L.length() != R.length()) min = 0;
        else {
            min = solve();
        }

        System.out.println(min);

        /*
        2. 자릿수를 비교. 자릿수가 아예 다르면 8이 안들어오는 수도 분명히 존재하니 답은 0이된다.
        단, 자릿수가 같다면, 각 자릿수에 따라 L과 R의 값이 같은지 비교, 그리고 8이라면 답은 1씩 더해진다.
        8808 8898 이라면 88__ 까지는 비교가 되야한다. 그러나 세번째 자릿수 부터는 08~98 사이 어느 숫자가 들어와도 상관없으므로
        답은 2가 된다.
         */

    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = st.nextToken();
        R = st.nextToken();
    }
}
