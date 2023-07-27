package group_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//메모리 초과 돌겠어요
public class B_1030 {
    static int s,n,k,r1,r2,c1,c2;
    static char[][] borad;
    private static void solve(int now, int byeon_i, int byeon_j, long size) {
        if (now < 1) return;

        //홀수 일 때.
        // k의 범위 byeon/2 - byeon_k/2

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nxt_i = (int) (byeon_i + i*size/n);
                int nxt_j = (int) (byeon_j + j*size/n);
                int nxt_size = (int) (size/n);

                if ((n%2==0 && is_center_even_ver(i,j)) || (n%2!=0 && is_center_odd_ver(i,j))) {
                    fill_black(nxt_i, nxt_j, nxt_size);
                } else if (nxt_i>= r1 && nxt_i <= r2 && nxt_j >= c1 && nxt_j <= c2){ //불필요한 재귀를 막기 위한, 장치.
                    solve(now-1, nxt_i, nxt_j, nxt_size);
                }
            }
        }
    }
    private static boolean is_center_odd_ver(int i, int j) {
        if (((n/2-k/2) <= j && (n/2+k/2) >= j && (n/2-k/2) <= i && (n/2+k/2) >= i)) return true;
        return false;
    }
    private static boolean is_center_even_ver(int i, int j) {
        if (((n/2-k/2) <= j && (n/2+k/2-1) >= j && (n/2-k/2) <= i && (n/2+k/2-1) >= i)) return true;
        return false;
    }

    private static void fill_black(int size_i, int size_j, int size) {
        for (int i = size_i; i <= size_i+size-1; i++) {
            for (int j = size_j; j <= size_j+size-1; j++) {
                if (i <= r2 && j <= c2)
                    borad[i][j] = '1';
            }
        }
    }

    private static void print() {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                System.out.print(borad[i][j]);
            }
            System.out.println();
        }
    }


    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        reset(new StringTokenizer(br.readLine(), " "));
        solve(s, 0,0,(long)Math.pow(n,s));
        print();

    }
    private static void reset(StringTokenizer st) {
        s = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        borad = new char[r2+1][c2+1];
        for (int i = 0; i <= r2; i++) {
            Arrays.fill(borad[i], '0');
        }

    }

}
