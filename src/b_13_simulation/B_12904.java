package b_13_simulation;

import java.util.*;

/** 240304 백준 A와 B 골드 5 문자열 */
public class B_12904 {
    static String s, t;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        t = sc.nextLine();

        // T->S 인지 확인.
        // 끝부분이 B 이면 뒤집기.
        // 끝부분이 A면 A 제거.

        StringBuilder sb = new StringBuilder(t);
        while (sb.length() > s.length()) {
            if (sb.toString().charAt(sb.length() - 1) == 'B') {
                if (sb.length() >= 1) sb.delete(sb.length() - 1, sb.length());
                sb = sb.reverse();
            } else {
                if (sb.length() >= 1) sb.delete(sb.length() - 1, sb.length());
            }

            if (sb.toString().equals(s.toString())) {
                System.out.println("1");
                return;
            }
            System.out.println(sb);
        }
        System.out.println("0");
    }
}
