import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long cnt = 0; //현재 보고 있는 수 
		long mxval = (long) (Math.pow(2, 62) * (-1)) - 1; //가장 많이 등장한 수의 값
		long mxcnt = 0; //가장 많이 등장한 수의 등장 횟수
		
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if (i == 0 || arr[i] == arr[i-1]) cnt++;
			else {				
				if (cnt > mxcnt) {
					mxcnt = cnt;
					mxval = arr[i-1];
				}
                cnt = 1;
			}
		}
		if (cnt > mxcnt) mxval = arr[n-1];
		System.out.println(mxval);
	}
}
