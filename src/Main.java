import java.io.*;
import java.util.*;


public class Main {
	//���ظ��� �� ����~
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int len = Integer.parseInt(br.readLine());
			int arr[] = new int[len];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int mx = 0; //ù��° �ִ�.
			int index_mx = 0; //ù��° �ִ��� ��ġ. 
			
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
						is_minus = false; //�ѹ��̶� �����ϴ� �κ��� ������ ����, ��� �����ϸ� true;
					} else if (j == len-1) {
						if (index_mx == n-1) is_minus = false;
					}
				}
				
				if (is_minus) break; //��� �����ϸ� �ݺ��� ������. 
			}
			System.out.println(ans);

		}
	}
	
}
