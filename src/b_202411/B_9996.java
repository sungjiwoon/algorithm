package b_202411;

import java.io.*;
import java.util.*;

public class B_9996 {
    static final String YES = "DA";
    static final String NO = "NE";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String xp = br.readLine();
        String[] sp = xp.split("\\*");
        int len = sp[0].length() + sp[1].length();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < len || !str.startsWith(sp[0]) || !str.endsWith(sp[1])) {
                System.out.println(NO);
                continue;
            }
            System.out.println(YES);

        }



    }
}
