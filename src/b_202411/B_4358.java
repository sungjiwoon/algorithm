package b_202411;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class B_4358 {

    List<String> animals = new ArrayList<>();

    public void solve() {

        // 생태계 계산
        int size = animals.size();

        // 종들 정렬
        Collections.sort(animals);

        // 종들 계산 - Map
        Map<String, Integer> map = new HashMap<>();
        for (String animal : animals) {
            if (!map.containsKey(animal)) map.put(animal, 1);
            else {
                map.put(animal, map.get(animal) + 1);
            }
        }

        // 종들 계산, 정렬
        List<String> keySet = map.keySet().stream().sorted().collect(Collectors.toList());

        // 백분율 계산
        for (String key : keySet) {
            double p = (double) map.get(key) / size * 1000000.0;
            double percent = Math.round(p) / 10000.0;

            double p2 = (double) map.get(key) / size * 100.0;
            String strp = String.format("%.4f", p2);
            System.out.println(key + " " + strp);
        }

    }

    public static void main(String[] args) throws Exception {
        B_4358 b = new B_4358();
        b.init();
        b.solve();

    }

    public void init() throws Exception {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str == null || str.isEmpty()) break;
            animals.add(str);
        }

    }

}
