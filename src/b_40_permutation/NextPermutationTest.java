package b_40_permutation;
import java.util.Arrays;

public class NextPermutationTest {
	static int n = 4;
	private boolean next_permutation(int[] arr) {
		int idx = n-1;
		//주어진 순열의 뒤부터 탐색하여, 증가하는 부분을 찾는다. 
		while (idx > 0 && arr[idx -1] > arr[idx]) {
			idx--;
		}
		
		//증가하는 부분이 없다면 false 반환. 
		if (idx == 0) {
			return false;
		}
		
		//해당 인덱스 기준으로 좌우로 나눈다. 
		// 좌측의 제일 오른쪽 숫자에 대하여 우측의 제일 오른쪽 지점부터 탐색하여 가장 큰 값을 찾는다. 
		int big_idx = n-1;
		while (big_idx > idx && arr[idx-1] > arr[big_idx]) {
			big_idx--;
		}
		
		//해당 숫자를 찾았다면 바꾼다. 
		int tmp = arr[idx-1];
		arr[idx-1] = arr[big_idx];
		arr[big_idx] = tmp;
		
		Arrays.sort(arr, idx, n);
		System.out.println(Arrays.toString(arr));
		return true;
		
	}
	public void work() {
		int[] arr = {1,2,3,4};
		while (next_permutation(arr));
		
	}
}
