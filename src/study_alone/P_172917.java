package study_alone;
import java.util.*;

/*
프로그래머스 레벨 2 광물캐기
https://school.programmers.co.kr/learn/courses/30/lessons/172927
그리디
어려웠다.
 */
public class P_172917 {
    int[][] tired;

    private int cntValue(ArrayList<Integer> list) {
        int sum = 0;
        for (int l : list) {
            sum += tired[2][l];
        }
        return sum;
    }
    public int solution(int[] picks, String[] minerals) {
        int dia = 0, iron = 1, stone = 2;
        HashMap<String, Integer> mineral = new HashMap<>();
        mineral.put("diamond", dia);
        mineral.put("iron", iron);
        mineral.put("stone", stone);

        tired = new int[][]{
                {1,1,1}, {5,1,1}, {25,5,1}
        };

        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < picks[i]; j++) {
                str.append(i+" ");
            }
        }

        /*
            광물 5개씩 쪼갠다음 돌로 했을 때 가장 많이 드는 순대로 정렬.
            정렬대로 다이아몬드 -> 철 -> 돌맹이로 계산.
            근데 광물의 수 > 곡괭이 수 * 5 일때 애매해짐.
            그래서 제약조건을 걸어 광물의 수 <= 곡괭이 수가 되도록 해야함.
        */

        int[] pick = Arrays.stream(str.toString().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        PriorityQueue<ArrayList<Integer>> qu =
                new PriorityQueue<>((o1,o2) -> {
                    return cntValue(o2) - cntValue(o1);
                });


        for (int i = 0; i < minerals.length; i++) {
            if (i >= pick.length * 5) break;

            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                if (i+j >= minerals.length) break;
                list.add(mineral.get(minerals[i+j]));
            }
            qu.add(list);
            i += 4;
        }

        int ans = 0;
        for (int p : pick) {
            if (qu.isEmpty()) break;
            ArrayList<Integer> list = qu.poll();
            for (int l : list) {
                // System.out.print(l+" ");
                ans += tired[p][l];
            }
            // System.out.println();
        }


        return ans;
    }
}
