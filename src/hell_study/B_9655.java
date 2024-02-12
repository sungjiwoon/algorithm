package hell_study;

import java.util.*;
import java.io.*;

/** 240212
 * 돌게임 DP
 */
public class B_9655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // first 가 이기냐, second 가 이기냐
        // n = 1 : 상근 승
        // n = 2 : 창영 승
        // n = 3 : 상근 승
        // n = 4 : 창영 승
        // n = 5 : 상근 승
        // n = 6 : 창영 승
        // n이 짝수 or 홀수 일 때마다 달라짐?!

        if (n % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
