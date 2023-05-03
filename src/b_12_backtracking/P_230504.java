package b_12_backtracking;

import java.io.IOException;
/*
 * Å¸°Ù ³Ñ¹ö (DFS) lv2
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 * 
 */
public class P_230504 {
	static int answer = 0;
	private void dfs(int[] arr, int depth, int size, int target, int[] nums) {
		if (depth == size) {
			int sum = 0;
			for (int i = 0; i < size; i++) {
				//System.out.print(arr[i] + " ");
				if (arr[i] == 0) {
					sum = sum - nums[i];
				} else {
					sum = sum + nums[i];
				}
			}
			if (sum == target) {
				for (int i : arr) {
					System.out.print(i + " ");
				}
				System.out.println();
				answer++;
			}
			
			return;
		}
		
		arr[depth] = 0;
		dfs(arr, depth+1, size, target, nums);
		arr[depth] = 1;
		dfs(arr, depth+1, size, target, nums);
			
	}
		
	public int solution(int[] numbers, int target) {
        //int answer = 0;
		int size = numbers.length;
        int[] arr = new int[size];
        dfs(arr, 0, size, target, numbers);
        
        return answer;
    }
	public void work() throws NumberFormatException, IOException {
		int[] nums = {4,1,2,1};
		System.out.println(solution(nums, 4));	
		
	}
}
