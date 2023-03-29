package b_18_binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 차집합 성공
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	256 MB	6599	2929	2330	44.981%
문제
몇 개의 자연수로 이루어진 두 집합 A와 B가 있다. 집합 A에는 속하면서 집합 B에는 속하지 않는 모든 원소를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 집합 A의 원소의 개수 n(A)와 집합 B의 원소의 개수 n(B)가 빈 칸을 사이에 두고 주어진다. (1 ≤ n(A), n(B) ≤ 500,000)이 주어진다. 둘째 줄에는 집합 A의 원소가, 셋째 줄에는 집합 B의 원소가 빈 칸을 사이에 두고 주어진다. 하나의 집합의 원소는 2,147,483,647 이하의 자연수이며, 하나의 집합에 속하는 모든 원소의 값은 다르다.

출력
첫째 줄에 집합 A에는 속하면서 집합 B에는 속하지 않는 원소의 개수를 출력한다. 다음 줄에는 구체적인 원소를 빈 칸을 사이에 두고 증가하는 순서로 출력한다. 집합 A에는 속하면서 집합 B에는 속하지 않는 원소가 없다면 첫째 줄에 0만을 출력하면 된다.

예제 입력 1 
4 3
2 5 11 7
9 7 4
예제 출력 1 
3
2 5 11
 */
public class B_1822 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n_a = Integer.parseInt(st.nextToken());
		int n_b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] a = new int[n_a];
		for (int i = 0; i < n_a; i++) a[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int[] b = new int[n_b];
		for (int i = 0; i < n_b; i++) b[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		int cnt = 0;
		for (int i = 0; i < n_a; i++) {
			if (Arrays.binarySearch(b, a[i]) < 0) { 
				cnt++; 
				sb.append(a[i]+" ");
			}
		}
		sb.insert(0,cnt+"\n");
		System.out.println(sb);
			
	}
}
