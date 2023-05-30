package b_40_permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//다음 순열 문제인데 번호를 이전순열 번호로 했다.. ㅋ
public class B_10973 {
	private boolean pre_permutation(int[] arr) {
		int idx = arr.length-1;
		while (idx > 0 ) {
			if (arr[idx] >= arr[idx-1]) idx--;
		}
		if (idx == 0) return false;
		//오름이란 의미.
		
		int small_idx = arr.length -1;
		while (small_idx > idx && arr[small_idx] >= arr[idx-1]) {
			small_idx--;
		}
		
		int tmp = arr[idx-1];
		arr[idx-1] = arr[small_idx];
		arr[small_idx] = tmp;
		
		
		small_idx = arr.length-1; //역순정렬. 
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
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		while (pre_permutation(arr));
		
	}
}
