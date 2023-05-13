package b_40_permutation;

import java.util.*;

public class PrePermutationTest {
	static int n = 4;
	private boolean pre_permutation(int[] arr) {
		
		int idx = n-1;
		//뒤에서부터 검사하여 감소하는 부분을 찾는다. 
		while (idx > 0 && arr[idx] >= arr[idx-1]) {
			idx--;
		}
		
		if (idx == 0) return false;
		
		int small_idx = n-1;
		//arr[idx-1] < arr[small_idx]를 만족하는 첫번째 수 찾기. 
		while (small_idx > idx && arr[small_idx] >= arr[idx-1]) {
			small_idx--;
		}
		
		int tmp = arr[small_idx];
		arr[small_idx] = arr[idx-1];
		arr[idx-1] = tmp;
		
		small_idx = n-1; //역순정렬. 
		while (idx < small_idx) {
			tmp = arr[small_idx];
			arr[small_idx] = arr[idx];
			arr[idx] = tmp;
			
			idx++;
			small_idx--;
		}
		System.out.println(Arrays.toString(arr));
		
		return true;
		
	}
	
	public void work() {
		int[] arr = {4,3,2,1};
		while (pre_permutation(arr));
	}
}
