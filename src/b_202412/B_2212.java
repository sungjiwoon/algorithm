package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_2212 {

    int n, k;
    int[] arr;

    void solve() {
        init();

        Arrays.sort(arr);

        List<Integer> sensorDist = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            if (arr[i] == arr[i+1]) continue;
            sensorDist.add(arr[i+1] - arr[i]);
        }

        // 센서 사이의 거리 오름차순 정렬
        // 센서 사이의 거리 중 먼것들은 제외한다.
        // 제외하는 갯수는 k-1개

        Collections.sort(sensorDist);
        int cnt = 0;
        for (int i = 0; i < sensorDist.size()-(k-1); i++) {
            //System.out.println(sensorDist.get(i));
            cnt += sensorDist.get(i);
        }
        System.out.println(cnt);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            k = Integer.parseInt(br.readLine());
            String[] sp = br.readLine().split(" ");
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(sp[i]);
            }
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_2212 b = new B_2212();
        b.solve();
    }
}
