package hell_study;

import java.io.*;
import java.util.*;

/**
 * 240212
 * 좌표 압축 실버 2
 */
public class B_18870 {
    // 2 4 -10 4 -9 -> -10 -9 2 4 순
    // 중복되지 않는 값이 담긴 배열의 정렬이 정답
    // 중복되지 않는다 -> set 이용. 정렬 필요 -> 매번 정렬해주는 treeSet 활용.
    // log 2 (1,000,000) => 약 20
    // 시간 max -> 1,000,000 * 20 = 200,000,000 (2억)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, Integer> idxMap = new HashMap<>();

        Set<Integer> set = new TreeSet<>(); //input 의 데이터를 모두 넣으면 O(NlogN)
        for (int i : input) { // N번
            set.add(i); // logN
        }

        // treeSet -> arr 변환.
        int[] sortArr = Arrays.stream(set.toArray()).mapToInt(it -> (int) it).toArray();

        int idx = 0;
        for (int val : sortArr) {
            idxMap.put(val, idx++);
        }

        StringBuffer sb = new StringBuffer(); //표준 입출력 사용하면 시간 초과남.
        for (int i = 0; i < n; i++) {
            sb.append(idxMap.get(input[i]) + " ");
        }
        System.out.println(sb);

    }
}
