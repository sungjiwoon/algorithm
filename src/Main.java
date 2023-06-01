import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {	
	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		arr[1] = 1;
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//arr[a] = b -> aÀÇ ºÎ¸ð b
			if (arr[a] != 0)  arr[b] = a;
			else if (arr[b] != 0) arr[a] = b;
			
		}
		
		for (int i = 2; i <= n; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
