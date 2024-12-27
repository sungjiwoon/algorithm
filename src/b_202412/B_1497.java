package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 백트래킹 + 비트 마스크
public class B_1497 {

    int n, m;
    long[] bit;
    int res = Integer.MAX_VALUE;
    long stand = 0L;
    int maxBitCount = 0;

    private void tracking(int depth, long value, int cnt) {
        if (depth == n) {
            int bitCount = Long.bitCount(value);
            System.out.println(String.format("value: %s, bitCount: %d, cnt: %d, res: %d",
                    Long.toBinaryString(value), bitCount, cnt, res));

            if (bitCount > maxBitCount) {
                maxBitCount = bitCount;
                res = cnt;
            }
            if (bitCount == maxBitCount) {
                res = Math.min(res, cnt);
            }
            return;
        }

        for (int i = depth; i < n; i++) {
//            System.out.println("value : "+ Long.toBinaryString(value) + " bit[i]= " + Long.toBinaryString(bit[i]));
            tracking(i+1, value | bit[i], cnt + 1);
            tracking(i+1, value, cnt);
        }
    }
    private void solve() {
        init();
        tracking(0, 0L, 0);
        if (maxBitCount == 0) res = -1;
        System.out.println(res);
    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            n = Integer.parseInt(sp[0]);
            m = Integer.parseInt(sp[1]);

            bit = new long[n];
            for (int i = 0; i < n; i++) {
                sp = br.readLine().split(" ");
                bit[i] = 0L;

                for (int j = 0; j < m; j++) {
                    if (sp[1].charAt(j) == 'Y') {
                        bit[i] |= (1L << j);
                    }
                }
            }

            for (int i = 0; i < m; i++)
                stand |= (1L << i);


        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_1497 b = new B_1497();
        b.solve();
    }
}
