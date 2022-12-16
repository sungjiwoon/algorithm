import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class B_2108 {
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}
		
		double sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums.get(i);
		}
		
		int ad = (int) Math.round(sum/n);
		System.out.println(ad); //평균
		
		Collections.sort(nums);
//		for (int i = 0; i < n; i++) {
//			System.out.println(nums.get(i));
//		}
//		
		System.out.println(nums.get(n/2)); //중앙값
		
		/* 빈도수 구하기 */
		
		int[] nums_max = new int[8001];
		for (int i = 0; i < 8001; i++) {
			nums_max[i]=0;
		}
		for (int i = 0; i < n; i++) {
			nums_max[nums.get(i) + 4000]+=1;
		}
		
		
		int best = 0;
		int max_value = -1;
		for (int i = 0; i < 8001; i++) {
			if (best < nums_max[i]) {
				max_value = i-4000;
				best = nums_max[i];
			}
		}
		
		boolean not_first = false;
		
		for (int i = 0; i < 8001; i++) {
			if (best == nums_max[i] && not_first) {
				max_value = i-4000;
				break;
			}
			
			if (best == nums_max[i]) {
				not_first = true;
				max_value = i-4000;
			}
		}
		System.out.println(max_value);
		
		
//		Map<Integer, Integer> hs = new HashMap<Integer, Integer>();
//		for (int i = 0; i < n; i++) {
//			hs.put(nums.get(i), 0);
//		}	
//		for (int i = 0; i < n; i++) {
//			hs.put(nums.get(i), hs.get(nums.get(i))+1);
//		}
//		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(hs.entrySet());
//		entryList.sort(Map.Entry.comparingByKey()); //오름차순 정렬 개같은게 음수는 정렬안됨^_^
//		
////		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(hs.entrySet());
////		entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
////			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
////				return o2.getValue() - o1.getValue();
////			}
////		} );
//		
//		int best = 0;
//		for (Integer key : hs.keySet()) {
//			System.out.println("key : " + key + ", value : " + hs.get(key));
//			if (best < hs.get(key))
//				best = hs.get(key);
//		}
//		boolean notfirst = false;
//		int max_index = -1;
//		for (Integer key : hs.keySet()) {
//			if (notfirst && best == hs.get(key))
//				max_index = key;
//			if (best == hs.get(key))
//				notfirst = true;
//		}
//			

		
		//범위
		System.out.println(nums.get(n-1) - nums.get(0));
		
		
	}
}
