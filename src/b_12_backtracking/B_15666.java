package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
/*
 * 문제명 N과 M 12
 * 난이도 실버2
 * 예제 입력 2 
	4 2
	9 7 9 1
	
	예제 출력 2 
	1 1
	1 7
	1 9
	7 7
	7 9
	9 9
 */
public class B_15666 {
	static int M, N;
	static int[] nums, arr, before;
	static boolean[] vis;
	static StringBuilder sb;
	static HashSet<String> hs;
	private static void func(int idx, int st) {
		if (idx == M) {
			StringBuilder temp = new StringBuilder();
			
			for (int i = 0; i < M; i++) temp.append(arr[i] + " ");
				
			if (!hs.contains(temp.toString())) {
				sb.append(temp).append("\n");
				hs.add(temp.toString());
			}
			
			return;
		}
		
		for (int i = st; i < N; i++) {
			arr[idx] = nums[i];
			func(idx+1, i);

		}
					
	}
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nums);
		arr = new int[M+1];
		hs = new HashSet<>();
		
		vis = new boolean[N+1];
		func(0,0);
		System.out.print(sb);
	}
}



