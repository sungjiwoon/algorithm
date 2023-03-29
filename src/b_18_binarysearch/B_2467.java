package b_18_binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 용액 성공스페셜 저지 (골드 5) ->투 포인터 사용.
 
	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
	1 초	128 MB	22179	8116	6336	36.422%
	문제
	KOI 부설 과학연구소에서는 많은 종류의 산성 용액과 알칼리성 용액을 보유하고 있다. 
	각 용액에는 그 용액의 특성을 나타내는 하나의 정수가 주어져있다. 산성 용액의 특성값은 1부터 1,000,000,000까지의 양의 정수로 나타내고, 
	알칼리성 용액의 특성값은 -1부터 -1,000,000,000까지의 음의 정수로 나타낸다.
	
	같은 양의 두 용액을 혼합한 용액의 특성값은 혼합에 사용된 각 용액의 특성값의 합으로 정의한다. 
	이 연구소에서는 같은 양의 두 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들려고 한다. 
	
	예를 들어, 주어진 용액들의 특성값이 [-99, -2, -1, 4, 98]인 경우에는 특성값이 -99인 용액과 특성값이 98인 용액을 혼합하면 특성값이 
	-1인 용액을 만들 수 있고, 이 용액의 특성값이 0에 가장 가까운 용액이다. 
	참고로, 두 종류의 알칼리성 용액만으로나 혹은 두 종류의 산성 용액만으로 특성값이 0에 가장 가까운 혼합 용액을 만드는 경우도 존재할 수 있다.
	
	산성 용액과 알칼리성 용액의 특성값이 정렬된 순서로 주어졌을 때, 이 중 두 개의 서로 다른 용액을 혼합하여 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액을 찾는 프로그램을 작성하시오.
	
	입력
	첫째 줄에는 전체 용액의 수 N이 입력된다. N은 2 이상 100,000 이하의 정수이다. 둘째 줄에는 용액의 특성값을 나타내는 N개의 정수가 빈칸을 사이에 두고 오름차순으로 입력되며, 이 수들은 모두 -1,000,000,000 이상 1,000,000,000 이하이다. N개의 용액들의 특성값은 모두 서로 다르고, 산성 용액만으로나 알칼리성 용액만으로 입력이 주어지는 경우도 있을 수 있다.
	
	출력
	첫째 줄에 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력한다. 출력해야 하는 두 용액은 특성값의 오름차순으로 출력한다. 특성값이 0에 가장 가까운 용액을 만들어내는 경우가 두 개 이상일 경우에는 그 중 아무것이나 하나를 출력한다.
	
	예제 입력 1 
	5
	-99 -2 -1 4 98
	예제 출력 1 
	-99 98
 */
public class B_2467 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */	
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] a = new long[n];
		for (int i = 0; i < n; i++) 
			a[i] = Long.parseLong(st.nextToken());
		
		int left = 0, right = n-1;
		int mx_a=0, mx_b=n-1; //투 포인터 방법 사용. 
		long mx = Integer.MAX_VALUE;
		while (left < right) {
			long tmp = a[left] + a[right];
			if (Math.abs(tmp) < mx) {
				mx = Math.abs(tmp);
				mx_a = left;
				mx_b = right;
			}
			
			if (tmp > 0) {
				//양수 이므로 
				right--;
			} else if (tmp < 0) {
				left++;
			} else break;
		}
		
		sb.append(a[mx_a] + " " + a[mx_b]);
		System.out.println(sb);
		return;	
			
	}
}
