import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {	
	static int n,s;
	static int ans = 0;
	static int[] borad;
	private static void func(int size, int[] arr, int depth, int st) {
		if (depth == size) {
			if (check(arr)) ans++;
			return;
		}
		
		for (int i = st; i < n; i++) {
			arr[depth] = borad[i];
			func(size, arr, depth+1, i);
		}
	}
	private static boolean check(int[] arr) {
		int size = arr.length;
		int sum = 0;
		for (int i= 0; i< size; i++) {
			sum += arr[i];
		}
		if (sum == s) return true;
		return false;
	}
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		borad = new int[n];
		int j = 0;
		st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			borad[j++] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= n; i++) {
			int[] arr = new int[i];
	
			func(i,arr, 0, 0);
		}
		System.out.println(ans);
	
	}
}
