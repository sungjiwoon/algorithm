package b_202410;

import java.io.*;
import java.util.*;

/**
 * 큐 (실4)
 * 2024.10.05
 */
public class B_1158 {

    int n, k;

    public void res() {

        // k번째 사람을 계속 제거한다.
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            qu.add(i);
        }

        System.out.print("<");
        while (!qu.isEmpty()) {
            for (int i = 1; i < k; i++) {
                qu.add(qu.poll());
            }
            System.out.print(qu.poll());
            if (!qu.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println(">");


    }

    public static void main(String[] args) throws Exception {
        B_1158 m = new B_1158();

        m.input();
        m.res();
    }

    public void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ip = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        n = ip[0];
        k = ip[1];

    }
}
