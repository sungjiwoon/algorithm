package b_16_greedy;

import java.util.*;
import java.io.*;

/*
거스름돈 (그리디 알고리즘)
브론즈 2
 */
public class B_5585 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cost = sc.nextInt();

        int[] money = {500, 100, 50, 10, 5, 1}; //거스름돈

        int v = 1000 - cost;
        int res = 0;
        int i = 0;

        while (v > 0) {

            while (i < 6 && v >= money[i]) {
                System.out.print(v + " ");
                v -= money[i];
                res++;
            }
            i++;
        }
        System.out.println();
        System.out.println(res);

    }
}

/*
620
120
20

 */
