package hell_study;

import java.io.*;
import java.util.*;

/** 240304 백준 선긋기 골드 5 그리디, 정렬 */
public class B_2170 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> inputList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputList.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        Collections.sort(inputList, (o1, o2) -> o1[0] - o2[0]);

        int st = Integer.MAX_VALUE;
        int en = Integer.MIN_VALUE;

        int res = 0;

        for (int i = 0; i < n; i++) {
            int x = inputList.get(i)[0];
            int y = inputList.get(i)[1];
//            System.out.println(String.format("st : %d, en : %d", st, en));

            if (x < st) {
                st = x;
            } else if (x > en){
                res += en - st;
                st = x;
                en = y;
//                System.out.println(String.format("st : %d, en : %d, res : %d", st, en, res));
            }

            if (y > en) {
                en = y;
            }


        }
        res += en - st;

        System.out.println(res);

    }
}
