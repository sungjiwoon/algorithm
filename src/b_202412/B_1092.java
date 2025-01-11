package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class B_1092 {
    int n, m;
    Integer[] crains;
    List<Integer> boxList = new ArrayList<>();

    void solve() {
        init();

        Arrays.sort(crains, Collections.reverseOrder());
        Collections.sort(boxList, Collections.reverseOrder());

        int time = 0;

        if (boxList.get(0) > crains[0]) {
            time = -1;
            System.out.println(time);
            return;
        }


        while (!boxList.isEmpty()) {
            time++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < boxList.size(); j++) {
                    if (crains[i] >= boxList.get(j)) {
                        boxList.remove(j);
                        break;
                    }
                }
            }
        }
        System.out.println(time);
    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            String[] sp = br.readLine().split(" ");
            crains = new Integer[n];
            for (int i = 0; i < n; i++) {
                crains[i] = Integer.parseInt(sp[i]);
            }
            m = Integer.parseInt(br.readLine());
            sp = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                boxList.add(Integer.parseInt(sp[i]));
            }
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_1092 b = new B_1092();
        b.solve();
    }
}
