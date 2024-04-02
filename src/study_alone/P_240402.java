package study_alone;

import java.io.*;
import java.util.*;

/** 240402 프로그래머스 카카오인턴 보석쇼핑 투포인터 */

class P_240402 {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int minI = 0, minJ = 1;

        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        for (String g : gems) {
            if (map.containsKey(g)) continue;
            map.put(g, idx++);
        }

        int size = map.size();
        int[] arr = new int[size];

        int min = Integer.MAX_VALUE;
        int i = 0, j = 1;
        int cnt = 0;

        arr[map.get(gems[0])] = 1;
        cnt = 1;

        if (size == 1) return new int[]{1, 1};

        while (i <= j) {
            if (i > j || j >= gems.length) {
                answer[0] = minI;
                answer[1] = minJ;
                break;
            }

            if (arr[map.get(gems[j])] == 0) {
                cnt++;
                if (cnt == size) {
                    if (min > j-i+1) {
                        min = j-i+1;
                        minI = i+1;
                        minJ = j+1;
                    }
                }
            }

            arr[map.get(gems[j])]++;

            if (arr[map.get(gems[j])] > 1) {
                while (i <= j && arr[map.get(gems[i])] > 1) {
                    arr[map.get(gems[i])]--;
                    i++;
                }
                if (cnt >= size && min > j-i+1) {
                    min = j-i+1;
                    minI = i+1;
                    minJ = j+1;
                }
            }
            j++;
        }


        return answer;
    }
}
