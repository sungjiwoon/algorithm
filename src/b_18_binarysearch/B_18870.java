package b_18_binarysearch;

import java.io.*;
import java.util.*;
/*
 * 좌표 압축 성공
 실버 2
 -> 중복배열 제거 등 여러 함수를 써볼라 했지만, hashmap을 쓰면 간단하게 해결된다!
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	512 MB	57365	24020	18368	39.689%
문제
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

입력
첫째 줄에 N이 주어진다.

둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

출력
첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.

제한
1 ≤ N ≤ 1,000,000
-109 ≤ Xi ≤ 109
예제 입력 1 
5
2 4 -10 4 -9
예제 출력 1 
2 3 0 3 1
 */
public class B_18870 {
	
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */	
		
		int n = Integer.parseInt(br.readLine());
		long[] a = new long[n];
		long[] sorted = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) 
			sorted[i] = a[i] = Long.parseLong(st.nextToken());

		Arrays.sort(sorted);
		
		Map<Long, Integer> hs = new HashMap<>();
		
		int rank = 0;
		for (int i = 0; i < n; i++) {
			if (hs.get(sorted[i]) == null) {
				hs.put(sorted[i], rank); //hashmap에 동일한 원소가 없으면 값을 넣어줌. 
				rank++;
			} 
		}
		
		for (long l : a) {
			sb.append(hs.get(l)+" ");
		}
		System.out.println(sb);
			
	}
}
