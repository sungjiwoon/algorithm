package hell_study;

import java.io.*;
import java.util.*;


public class B_17219 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            map.put(tmp[0], tmp[1]);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            sb.append(map.get(br.readLine())+"\n");
        }
        System.out.println(sb);

    }

}
