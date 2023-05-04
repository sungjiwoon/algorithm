package programmers;

import java.io.*;
import java.util.*;
/*
 * ������� ���
 * 
 */
public class P_230504_5 {
	public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, int[]> hs = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");
            
            int[] time = new int[2]; // 0: �ð� 1 : �����ð�. 
            String[] times = arr[0].split(":");
             
            int hour = Integer.parseInt(times[0]);
            int min = Integer.parseInt(times[1]);
             
            time[0] = hour*100 + min; 
            time[1] = 0;
            
            if (arr[2].equals("IN")) {         
                //�����ð� �׳� �־��ֱ�. 
                if (hs.containsKey(Integer.parseInt(arr[1]))) {
                    int[] value = hs.get(Integer.parseInt(arr[1]));
                    time[1] = value[1];
                    hs.put(Integer.parseInt(arr[1]), time);
                } else {
                    hs.put(Integer.parseInt(arr[1]), time);
                }
                System.out.println("IN" + Arrays.toString(time));
                
            } else if (arr[2].equals("OUT")){
                int[] value = hs.get(Integer.parseInt(arr[1]));
                //0 : time 1 : �����ð� �ֱ�. 
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

        // Ű ������ �������� ����
        Collections.sort(keySet);
        int[] answer = new int[keySet.size()];
        int i = 0;
        for (int key : keySet) {
        	int[] value = hs.get(key);
        	System.out.println(key + " " + value[1] );
            if (value[0] != -1) {
            	int hour_v = value[0] / 100;
                int min_v = value[0] % 100;
            	int tmp = (23 -hour_v)*60 + 59 - min_v;
                value[1] += tmp;
                System.out.println(tmp);
            }
            int time = value[1];
            int res = 0;
            if (time > fees[0])
            	//math.ceil �ݿø�. 
            	res = fees[1] + ( (int) Math.ceil((time-fees[0])/(double)fees[2])) * fees[3];
            else 
            	res = fees[1];
            System.out.println(key + " " + value[1] + ", "+ res);
            answer[i++] = res;
        }
        return answer;
       

    }
	public void work() throws NumberFormatException, IOException {
//		int[] fees = {180, 5000, 10, 600};
//		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", 
//							"07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", 
//							"19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] fees = {120, 0, 60, 591};
		String[] records = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
		System.out.println(Arrays.toString(solution(fees, records)));
	}
}
