package b_16_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 수 묶기 성공 (골드 4)
 
	시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
	2 초	128 MB	28798	9009	7247	30.546%
	문제
	길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다. 하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다. 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다. 하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다. 그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
	
	예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.
	
	수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.
	
	수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 수열의 크기 N이 주어진다. N은 50보다 작은 자연수이다. 둘째 줄부터 N개의 줄에 수열의 각 수가 주어진다. 수열의 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
	
	출력
	수를 합이 최대가 나오게 묶었을 때 합을 출력한다. 정답은 항상 231보다 작다.
	
	예제 입력 1 
	4
	-1
	2
	1
	3
	예제 출력 1 
	6
 */
public class B_1744 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		long ans = 0;
		int plus_num = 0;
		int minus_num = 0;
		int zero_num = 0;
		int one_num = 0;
		for (int i = n-1; i >= 0; i--) {
		
			if (arr[i] > 1) plus_num++; //2이상의 갯수
			else if (arr[i] < 0) minus_num++; //음수 갯수
			else if (arr[i] == 0) zero_num++; //0의 갯수 (사실 음수랑 합해도 노상관)
			else if (arr[i] == 1) one_num++; //1의 갯수 
			
		}
		for (int i = n-1; i >= n-plus_num; i--) {
			if (i == n-plus_num) {
				System.out.println("양수부분 ans += " + arr[i]);
				ans += arr[i];
				System.out.println("양수부분 결과 : " + ans);
			}
			else {
				System.out.println("양수부분 ans += " + arr[i] + "*" + arr[i-1]);
				ans += arr[i] * arr[i-1];
				System.out.println("양수부분 결과 : " + ans);
				i--;
			}
		}
		
		for (int i = n-plus_num-1; i >= n-plus_num-one_num; i--) {
			System.out.println("1 더하기 : " + arr[i]);
			ans += arr[i];
			System.out.println("1 더하기 결과 : " + ans);
		}
		
		System.out.println("minus_num+zero_num = " + (minus_num+zero_num));
		for (int i = 0; i < minus_num+zero_num; i++) {
            if (i < minus_num+zero_num -1 ) {
				System.out.println("음수부분 ans += " + arr[i] + "*" + arr[i+1]);
            	int sum = arr[i] * arr[i+1];
				i++;
				ans += sum;
            } else {
            	System.out.println("음수부분 ans += : " + arr[i]);
                ans += arr[i];
            }
            System.out.println("음수부분 결과 : " + ans);
		}
		//음수의 갯수 짝수 및 0의 갯수 짝수 -> 음수 차례로 곱해서 더해준다. 
		//음수의 갯수 짝수 및 0의 갯수 홀수 -> 음수 차례로 곱하고 0은 더해준다. 
		//음수의 갯수 홀수 0의 갯수 짝수 -> 음수 곱해주고 0과 곱해서 더해준다. 
		//음수의 갯수 홀수 0의 갯수 홀수 -> 음수 곱해주고 마지막 남은 음수 0과 곱해줌. 나머지 0 더함~
		
		
		System.out.println(ans);
	
		
	}
}
