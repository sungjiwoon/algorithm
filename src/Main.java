import java.io.*;
import java.util.*;


public class Main {
	//이해못함 걍 포기~
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int len = Integer.parseInt(br.readLine());
			int arr[] = new int[len];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int mx = 0; //첫번째 최댓값.
			int index_mx = 0; //첫번째 최댓값의 위치. 
			
			for (int j = 0; j < len; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (mx < v) {
					mx = v;
					index_mx = j;
				}
				arr[j] = v;
				
			}
			
			int t = 0;
			int ans = 0;
			while (t < len) {
				int sum = 0;
				for (int j = t; j < index_mx; j++) {
					sum += arr[j];
				}
				if (index_mx > 0) {
					ans += arr[index_mx] * (index_mx-t) - sum;
				}
				t = index_mx+1;
				
				boolean is_minus = true;
				if (t >= len) break;
				mx = arr[t];
				
				for (int j = t; j < len; j++) {
					if (mx < arr[j]) {
						mx = arr[j];
						index_mx = j;
					}
					
					if (j < len-1 && arr[j+1] > arr[j]) {
						is_minus = false; //한번이라도 증가하는 부분이 있으면 실패, 계속 감소하면 true;
					} else if (j == len-1) {
						if (index_mx == n-1) is_minus = false;
					}
				}
				
				if (is_minus) break; //계속 감소하면 반복문 끝내기. 
			}
			System.out.println(ans);

		}
	}
	
}
