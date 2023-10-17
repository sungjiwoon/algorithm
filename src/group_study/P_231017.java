package group_study;

import java.util.*;

class P_231017 {
    int[][] tired = {{1,1,1,0}, {5,1,1,0}, {25,5,1,0}};
    PriorityQueue<int[]> qu;
    HashMap<String, Integer> nameToIdx = new HashMap<>();
    public void init() {
        qu = new PriorityQueue<>((o1, o2) -> {
            int sum1 = Arrays.stream(o1)
                    .map(it -> tired[2][it])
                    .sum();
            int sum2 = Arrays.stream(o2)
                    .map(it -> tired[2][it])
                    .sum();
            return sum2 - sum1;

        });
    }

    public int solution(int[] picks, String[] minerals) {
        nameToIdx.put("diamond", 0);
        nameToIdx.put("iron", 1);
        nameToIdx.put("stone", 2);

        /*
        5개 조합으로 나눈다음,
        돌을 기준으로 계산을 하여 배열을 정렬한다.
        그 다음 다이아몬드 -> 철 -> 돌로 깨면 된다.
        */

        //만약 광물의 갯수 / 5 > picks.length 일 경우
        //그 이상의 광물은 캘수가 없다.
        //즉, 곡괭이의 수에 맞춰 광물의 수를 조정해야한다.

        int len = minerals.length;
        if (len > Arrays.stream(picks).sum() * 5) {
            len = Arrays.stream(picks).sum() * 5;
        }

        init();

        for (int i = 0; i < len; i++) {
            int[] group = new int[5];
            Arrays.fill(group, 3);

            int k = 0;
            for (int j = i; j < i+5; j++) {
                if (j >= len) {
                    break;
                }
                group[k++] = nameToIdx.get(minerals[j]);
            }
            qu.add(group);
            i += 4;
        }


        int answer = 0;
        for (int i = 0; i < picks.length; i++) {
            int cnt = picks[i];

            for (int j = 0; j < cnt; j++) {
                if (qu.isEmpty()) break;

                int[] group = qu.poll();
                for (int k = 0; k < 5; k++) {
                    answer += tired[i][group[k]];
                }
            }

            if (qu.isEmpty()) break;
        }


        return answer;
    }

    public static void main(String[] args) {
        P_231017 p = new P_231017();
        //answer : 12 , 50 , 5
        System.out.println(p.solution(new int[]{1, 3, 2}, new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"}));
        System.out.println(p.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
        System.out.println(p.solution(new int[]{0, 0, 1}, new String[]{"stone", "stone", "stone", "stone", "stone", "diamond"}));

    }
}
