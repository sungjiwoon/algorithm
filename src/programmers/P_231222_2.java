package programmers;
import java.util.*;


/**
 * 프로그래머스 레벨 3 : 베스트앨범
 * 해시함수 이용.
 */

public class P_231222_2 {
    HashMap<String, Integer> genreIdx, genreCnt;
    PriorityQueue<String> orders;
    PriorityQueue<int[]>[] pqArr;
    int[] cnt;
    public int[] solution(String[] genres, int[] plays) {
        init(genres);

        for (int i = 0; i < plays.length; i++) {
            String key = genres[i];
            int idx = genreIdx.get(key);
            cnt[idx] += plays[i];
            pqArr[idx].add(new int[]{i, plays[i]});
        }

        // 계산
        List<Integer> ansList = new ArrayList<>();
        for (String key : genreIdx.keySet()) {
            orders.add(key);
        }
        while (!orders.isEmpty()) {
            String key = orders.poll();
            int idx = genreIdx.get(key);
            for (int i = 0; i < 2; i++) {
                if (pqArr[idx].isEmpty()) break;
                int[] value = pqArr[idx].poll();
                ansList.add(value[0]);
            }
        }

        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        return answer;
    }

    public void init(String[] genres) {
        genreIdx = new HashMap<>();
        genreCnt = new HashMap<>();
        int idx = 0;

        for (String key : genres) {
            if (!genreIdx.containsKey(key)) {
                genreIdx.put(key, idx++);
            }
        }

        cnt = new int[idx];
        orders = new PriorityQueue<>((o1, o2) ->
                cnt[genreIdx.get(o2)] - cnt[genreIdx.get(o1)]
        );

        pqArr = new PriorityQueue[idx];
        for (int i = 0; i < idx; i++) {
            pqArr[i] = new PriorityQueue<int[]>((o1, o2) -> {
                if (o1[1] == o2[1]) return o1[0] - o2[0];
                return o2[1] - o1[1];
            });
        }

    }
}
