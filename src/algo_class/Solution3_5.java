package algo_class;
import java.util.*;

public class Solution3_5 {
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, int[]> hs = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");

            int[] time = new int[2]; // 0: 시간 1 : 누적시간.
            String[] times = arr[0].split(":");

            int hour = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);

            time[0] = hour*100 + min;
            time[1] = 0;

            if (arr[2].equals("IN")) {
                //누적시간 그냥 넣어주기.
                if (hs.containsKey(Integer.parseInt(arr[1]))) {
                    int[] value = hs.get(Integer.parseInt(arr[1]));
                    time[1] = value[1];
                    hs.put(Integer.parseInt(arr[1]), time);
                } else {
                    hs.put(Integer.parseInt(arr[1]), time);
                }

            } else if (arr[2].equals("OUT")){
                int[] value = hs.get(Integer.parseInt(arr[1]));
                //0 : time 1 : 누적시간 넣기.
                int hour_v = value[0] / 100;
                int min_v = value[0] % 100;
//
//                System.out.println(hour + ":" + min);
//                System.out.println(hour_v + ":" + min_v);

                int tmp = (hour -hour_v)*60 + min - min_v;
                value[1] += tmp;
                value[0] = -1;
                hs.put(Integer.parseInt(arr[1]), value);

//                System.out.println(arr[1] + ": " + tmp);
            }
        }

        List<Integer> keySet = new ArrayList<>(hs.keySet());

        // 키 값으로 오름차순 정렬
        Collections.sort(keySet);
        int[] answer = new int[keySet.size()];
        int i = 0;
        for (int key : keySet) {
            int[] value = hs.get(key);
            //System.out.println(key + " " + value[1] );
            if (value[0] != -1) {
                int hour_v = value[0] / 100;
                int min_v = value[0] % 100;
                int tmp = (23 -hour_v)*60 + 59 - min_v;
                value[1] += tmp;
                //System.out.println(tmp);
            }
            int time = value[1];
            int res = 0;
            if (time > fees[0])
                res = fees[1] + ( (int) Math.ceil((time-fees[0])/(double)fees[2])) * fees[3];
            else
                res = fees[1];
            // System.out.println(key + " " + value[1] + ", "+ res);
            answer[i++] = res;
        }
        return answer;
    }

}
