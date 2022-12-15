import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

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
		System.out.println(ad); //Æò±Õ
		
		Collections.sort(nums);
		System.out.println(nums.get(n/2)); //Áß¾Ó°ª
		
//		int[] max_nums = new int[500000];
//		
//		int store = 0;
//		for (int i = 1; i < n; i++) {
//			if (nums.get(i) != nums.get(i-1)) {
//				
//			}
//		}
		
		//¹üÀ§
		System.out.println(nums.get(n-1) - nums.get(0));
		
		
	}
}
