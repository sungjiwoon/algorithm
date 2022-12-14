import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B_2751 {
	static int[] nums;
	static int n;
	public void sort() {
		for (int i = 1; i < n; i++) {
			boolean isswaped = false;
			for (int j = 0; j < n-i; j++) {
				if (nums[j] > nums[j+1]) { 
					swap(nums, j, j+1);
					isswaped = true;
				}
			}
			
			if (isswaped == false) {
				break;
			}
		}
	}
	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public void work() throws NumberFormatException, IOException {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) 
			nums.add(Integer.parseInt(br.readLine()) );
		//Arrays.sort(nums);
		Collections.sort(nums);
		for (int i = 0; i < n; i++ ) {
			System.out.println(nums.get(i));
		}
		
	}

}
