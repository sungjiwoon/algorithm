package hell_study;

import java.io.*;
import java.util.*;
/** 240306 백준 암호코드 골드 5 DP */
public class B_2011 {
    /*
    값이 0인 경우 암호를 풀 수 없음!
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        int n = input.length;

        int[] values = new int[n];
        if (input[0] != '0') values[0] = 1;

        for (int i = 1; i < n; i++) {
            int tmp = Integer.parseInt(String.valueOf(input[i-1])  + String.valueOf(input[i]));
            if (input[i-1] != '0' && tmp >= 1 && tmp <= 26) { // 01 -> 암호 못 만들음.
                if (input[i] == '0') {
                    if (i >= 2) values[i] = values[i-2];
                    else values[i] = 1;
                } else {
                    if (i >= 2) values[i] = values[i-2] + values[i-1];
                    else values[i] = 1 + values[i-1];
                }
            } else {
                if (input[i] == '0') break;
                values[i] = values[i-1];
            }
            values[i] %= 1000000;
//            System.out.println(i + ":" + values[i]);
        }

        System.out.println(values[n-1]);
    }
}
