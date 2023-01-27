package b_14_sort;
import java.io.*;
import java.util.*;
/*
 * 문제 명 : 카드 
 * 문제
	준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.
	
	준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
	
	입력
	첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
	
	출력
	첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.
	
	예제 입력 1 
	5
	1
	2
	1
	2
	1
	예제 출력 1 
	1
 */
public class B_11652 {
	public void work() throws NumberFormatException, IOException {
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
