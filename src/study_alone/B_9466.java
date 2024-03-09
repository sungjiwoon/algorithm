package study_alone;

import java.io.*;
import java.util.*;

public class B_9466 {

//    static int T, n;
//    static int[] arr;
    

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        T = Integer.parseInt(br.readLine());
//        for (int t = 0; t < T; t++) {
//            n = Integer.parseInt(br.readLine());
//            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        }

        String a = "abc", b = new String("abc");
        System.out.println((a==b));
        if (a.equals(b)) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }
}