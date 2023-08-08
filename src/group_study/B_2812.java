package group_study;

import java.io.*;
import java.util.*;
/*
2812 크게만들기 (골3)
 */
public class B_2812 {
    static int n,k;
    static int[] data, res;

    private static void solve() {

        PriorityQueue<Integer> qu = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (data[o1] == data[o2]) return o1-o2;
                return data[o1]-data[o1];
            }
        });

        int st = 0, en = k;
        int index = -1;

        for (int i = st; i < en; i++) {
            qu.add(i);
        }
        while (en < n) {
            qu.add(en);
            while (index >= 0 && qu.peek() < res[index]) {
                System.out.println(qu.peek());
                qu.poll();
            }
            res[++index] = qu.poll();
            en++;
        }

    }
    private static void print() {
        StringBuilder ans = new StringBuilder("");
        for (int i = 0; i < n-k; i++) {
            System.out.print(res[i]+" ");
            ans.append(data[res[i]]);
        }
        System.out.println(ans);
    }
    public void work() throws NumberFormatException, IOException {
        input();
        solve();
        print();
        /*
            k개의 문자를 빼야한다는 것은 즉, n-k의 길이를 가진 숫자를 만드는 것과 같다.
            첫번째 자릿수에 와야할 숫자는 인덱스 0~k 까지의 숫자 중 가장 큰 값이며,
            두번째 자릿수에 와야할 숫자는 첫째자릿수인덱스+1 ~ k+1 중 가장 큰 값,
            세번째 자릿수에 와야할 숫자는 둘째자릿수인덱스+1 ~ k+2 중 가장 큰 값,
            으로 반복하면 된다.

            가장 큰 값을 꺼내는 자료구조는 우선순위 큐를 사용했으며,
            우선 순위큐에 인덱스만을 넣어, Comparator를 이용하여 데이터의 값 비교를 내림차순으로 하게 했다.
            같은 값이면 앞 인덱스가 와야하므로 처리를 해주었다. (4 2 8894 )로 알아냄.

            첫번째 자릿수의 값을 넣으면 k+1 값 인덱스를 넣어주어 다시 비교를 하여 다음 자릿수를 구하고, 이를 반복하였다.
         */
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        data = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        res = new int[n-k];
    }
}
