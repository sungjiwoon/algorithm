package b_40_permutation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_10973 {
	private boolean next_permutation(int[] arr) {
		int idx = arr.length -1;
		while (idx > 0 && arr[idx] < arr[idx-1]) { idx--; }
		if (idx == 0) {
			System.out.println("-1");
			return false;
		}
		
		int j = arr.length-1;
		while (arr[j] < arr[idx-1] && idx < j) { j--; }
		
		int tmp = arr[j];
		arr[j] = arr[idx-1];
		arr[idx-1] = tmp;
		
		Arrays.sort(arr, idx, arr.length);
		
		for (int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + " ");
		System.out.println();
		return true;

		
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
		while (next_permutation(arr));
		
	}
}
