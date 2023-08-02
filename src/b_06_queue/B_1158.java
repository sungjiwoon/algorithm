package b_06_queue;

import java.awt.desktop.QuitEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_1158 {
    public void work() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }


        System.out.print("<");
        while (!queue.isEmpty()) {
            int i = 0;
            while (i < k-1) {
                queue.add(queue.poll());
                i++;
            }
            System.out.print(queue.poll());
            if (queue.size() >= 1) System.out.print(", ");

        }
        System.out.print(">");
    }
}
