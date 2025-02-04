package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// 250204 두 배열의 합 골드 3 투포인터
public class B_2143 {

    int T;
    int n, m;
    int[] A, B;
    int[] sumA;
    int[] sumB;

    private void solve() {
        sumA = new int[n];
        sumB = new int[m];

        // 누적합 구하기
        sumA[0] = A[0];
        for (int i = 1; i < n; i++) {
            sumA[i] = sumA[i-1] + A[i];
        }

        sumB[0] = B[0];
        for (int i = 1; i < m; i++) {
            sumB[i] = sumB[i-1] + B[i];
        }

        int sizeA = n*(n-1)/2+n, sizeB = m*(m-1)/2+m;
        int idx = 0;

        long[] a = new long[sizeA];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                a[idx++] = sumA[j] - sumA[i] + A[i];
            }
        }

        long[] b = new long[sizeB];
        idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                b[idx++] = sumB[j] - sumB[i] + B[i];
            }
        }


        // 투포인터

        Arrays.sort(a);
        Arrays.sort(b);

        int pa = 0, pb = sizeB-1;
        long cnt = 0;
        while (pa < sizeA && pb >= 0) {

            if (a[pa] + b[pb] == T) {
                // 연속된 수를 찾는다.
                long cntA = 1;
                int idxA = pa+1;
                while (idxA < sizeA && a[idxA] == a[pa]) {
                    idxA++;
                    cntA++;
                }
                long cntB = 1;
                int idxB = pb-1;
                while (idxB >= 0 && b[idxB] == b[pb]) {
                    idxB--;
                    cntB++;
                }
                cnt += (cntA*cntB);
                pa = idxA;
                pb = idxB;
            }
            else if (a[pa] + b[pb] < T) {
                pa++;
            } else {
                pb--;
            }

        }
        System.out.println(cnt);
    }

    private void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            T = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            m = Integer.parseInt(br.readLine());
            B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            solve();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2143 b = new B_2143();
        b.init();
    }
}
