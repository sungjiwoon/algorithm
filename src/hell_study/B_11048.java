package hell_study;
import java.util.*;
import java.io.*;
/** 240215 이동하기 실버 2 DP */
public class B_11048 {
    int n, m;
    public static void main(String[] args) {

    }
    private void input() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            n = tmp[0];
            m = tmp[1];
        } catch(Exception e) {}
    }
}
