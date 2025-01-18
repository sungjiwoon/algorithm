package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 240118 그리디 달력  */
public class B_20207 {

    int n;
    int[][] days;

    void solve() {
        init();

        // 정렬 1. 시작날짜 순. 정렬 2. (종료 날짜-시작 날짜 내림차순)
        Arrays.sort(days, (o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0]-o2[0];
            return (o2[1]-o2[0]) - (o1[1]-o1[0]);
        });

        int sum = 0;
        int w = 0, h = 1;
        int st = days[0][0], en = days[0][1];
        List<Integer> hList = new ArrayList<>();
        hList.add(en);

        for (int i = 1; i < n; i++) {
            int nst = days[i][0], nen = days[i][1];
            System.out.print("nst = " + nst + ", nen = " + nen);

            if (nst > en + 1) {
                // 전 직사각형의 가장 긴 지점이 현재의 start 지점보다 작음

                w = en - st + 1;
                sum += w * hList.size();
                System.out.println(" nst > en+1 -> w = " + w + ", h = "+ hList.size());
                System.out.println("sum = " + sum);
                hList = new ArrayList<>();
                hList.add(nen);
                st = nst;
                en = nen;
                continue;
            }

            boolean flag = false;
            for (int j = 0; j < hList.size(); j++) {
                h = hList.get(j);
                if (nst >= h + 1) {
                    // 이어 붙이기
                    hList.remove(j);
                    hList.add(j, nen);
                    en = Math.max(en, nen);
                    flag = true;
                    System.out.println(" nst=en+1 -> en = " + en + " hList("+j+") = " + hList.get(j));
                    break;
                }
            }

            if (!flag) {
                hList.add(nen);
                en = Math.max(en, nen);
                System.out.println(" en = " + en + " hList(j) = " + hList.size());
            }

        }
        w = en - st + 1;
        sum += w * hList.size();
        System.out.println(sum);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            days = new int[n][2];
            for (int i = 0; i < n; i++) {
                days[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_20207 b = new B_20207();
        b.solve();
    }
}
