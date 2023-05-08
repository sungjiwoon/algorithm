package b_19_twopointer;
import java.io.*;
import java.util.*;
/*
 * List of Unique Numbers 실패
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	32 MB	4005	1471	1087	35.898%
문제
길이가 N인 수열이 주어질 때, 수열에서 연속한 1개 이상의 수를 뽑았을 때 같은 수가 여러 번 등장하지 않는 경우의 수를 구하는 프로그램을 작성하여라.

입력
첫 번째 줄에는 수열의 길이 N이 주어진다. (1 ≤ N ≤ 100,000)

두 번째 줄에는 수열을 나타내는 N개의 정수가 주어진다. 수열에 나타나는 수는 모두 1 이상 100,000 이하이다.

출력
조건을 만족하는 경우의 수를 출력한다.
 */
public class B_13144 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* 선언 및 초기화 부분 */		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int res =0;
		int en = 0;
		
		boolean[] cnt = new boolean[100002];
		cnt[a[0]]=true;
		for (int srt = 0; srt < n; srt++) {
			while (en < n-1 && !cnt[a[en+1]]) {
				en++;
				cnt[a[en]]= true;
			}
			res += en-srt+1;
			cnt[a[srt]]=false;
		}
		System.out.println(res);
		
	}
}
