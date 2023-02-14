import java.io.*;
import java.util.*;


public class Main {
	//이해못함 걍 포기~
	private static int gcd(int a, int b) { //최대공약수 구하는 함수. 
		if (b == 0) return a;
		return gcd(b, a%b);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int res = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					res += gcd(arr[i],arr[j]);
				}
			}
			System.out.println(res);
			
		}
		
	}
	
}
