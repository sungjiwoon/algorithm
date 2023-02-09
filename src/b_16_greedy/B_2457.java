package b_16_greedy;
import java.io.*;
import java.util.*;

/*
 * 공주님의 정원 (골드 3)
 * 
 * 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	192 MB	12396	3025	2110	25.164%
문제
오늘은 공주님이 태어난 경사스러운 날이다. 왕은 이 날을 기념하기 위해 늘 꽃이 피어있는 작은 정원을 만들기로 결정했다.

총 N개의 꽃이 있는 데, 꽃은 모두 같은 해에 피어서 같은 해에 진다. 하나의 꽃은 피는 날과 지는 날이 정해져 있다. 예를 들어, 5월 8일 피어서 6월 13일 지는 꽃은 5월 8일부터 6월 12일까지는 꽃이 피어 있고, 6월 13일을 포함하여 이후로는 꽃을 볼 수 없다는 의미이다. (올해는 4, 6, 9, 11월은 30일까지 있고, 1, 3, 5, 7, 8, 10, 12월은 31일까지 있으며, 2월은 28일까지만 있다.)

이러한 N개의 꽃들 중에서 다음의 두 조건을 만족하는 꽃들을 선택하고 싶다.

공주가 가장 좋아하는 계절인 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 한다.
정원이 넓지 않으므로 정원에 심는 꽃들의 수를 가능한 적게 한다. 
N개의 꽃들 중에서 위의 두 조건을 만족하는, 즉 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 꽃들을 선택할 때, 선택한 꽃들의 최소 개수를 출력하는 프로그램을 작성하시오. 

입력
첫째 줄에는 꽃들의 총 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 각 꽃이 피는 날짜와 지는 날짜가 주어진다. 하나의 날짜는 월과 일을 나타내는 두 숫자로 표현된다. 예를 들어서, 3 8 7 31은 꽃이 3월 8일에 피어서 7월 31일에 진다는 것을 나타낸다. 

출력
첫째 줄에 선택한 꽃들의 최소 개수를 출력한다. 만약 두 조건을 만족하는 꽃들을 선택할 수 없다면 0을 출력한다.

예제 입력 1 
4
1 1 5 31
1 1 6 30
5 15 8 31
6 10 12 10
예제 출력 1 
2

전형적인 그리디 유형 . 어려움 . 
 */
class Flower {
	int d1, d2;

	public Flower(int d1,int d2) {
		this.d1 = d1;
		this.d2 = d2;
	}

	public int getD1() {
		return d1;
	}


}


public class B_2457 {
	
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		Flower[] fs = new Flower[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int d1 = Integer.parseInt(st.nextToken()) * 100 +  Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken()) * 100 +  Integer.parseInt(st.nextToken());
			fs[i] = new Flower(d1,d2);
		}
		
		
//		Arrays.sort(fs, new Comparator<Flower>() {
//			@Override
//			public int compare(Flower a, Flower b) {
//				return a.getD1() - b.getD1();
//			}
//		} );
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(fs[i].d1 + " " + fs[i].d2);
//		}
//		
		int ans = 0;
		int t = 301; //3월 1일부터 필수 이므로. 
		
		while (t < 1201) {
			int nxt_t = t;
			for (int i = 0; i < n; i++) {
				if (fs[i].d1 <= t && fs[i].d2 > nxt_t) {
					nxt_t = fs[i].d2;
				}
			}
			
			if (t == nxt_t) {
				ans = 0;
				break;
			} //시간이 같다는 뜻 (전진을 안함.)
			
			ans++;
			t = nxt_t;
		}
		System.out.println(ans);
		
		
		
		
		
	}
}
