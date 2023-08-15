package study_alone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
집합 (실버 5)
비트연산공부
 */
public class B_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
        int S = 0;

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String oper = st.nextToken();
            int n;
            switch (oper) {
                case "add":
                    n = Integer.parseInt(st.nextToken());
                    S |= (1<<n);
                    break;
                case "remove" :
                    n = Integer.parseInt(st.nextToken());
                    S &= ~(1<<n);
                    break;
                case "check":
                    n = Integer.parseInt(st.nextToken());
                    if ((S & (1<<n)) > 0) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "toggle":
                    n = Integer.parseInt(st.nextToken());
                    S ^= (1<<n);
                    break;
                case "all":
                    S = (1<<21) -1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
