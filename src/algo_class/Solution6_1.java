package algo_class;

//ㅅ순열
import java.util.*;
import java.io.*;
public class Solution6_1 {
    Stack<Integer> pm = new Stack<>();
    private void DFS(int L, int n, int m, int[] ch) {
        //ch가 방문 배열
        //pm에 찐 값 담김
        if (L == m) {
            for (int p : pm) {
                System.out.print(p + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                pm.push(i);
                DFS(L+1, n, m, ch);
                ch[i] = 0;
                pm.pop();
            }

        }
    }
    private void solution(int n, int m) {
        int[] ch = new int[n+1];
        DFS(0, n, m, ch);
    }

    public static void main(String[] args) {
        Solution6_1 T = new Solution6_1();
        T.solution(3,2);
    }


}
