package b_21_binary_tree;

import java.io.*;
import java.util.*;
/*
 * 홍익 투어리스트 성공
 
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
1 초	1024 MB (추가 메모리 없음)	958	270	229	32.482%
문제
	도현이는 홍익 투어리스트가 되어 홍익대학교를 견학하려고 한다. 홍익대학교는 
	$N$개의 구역이 원형으로 배치된 모습이다. 
	$1$번 구역에서 시계 방향으로 각각 
	$2$번, ... , 
	$N$번 구역이 존재하고, 
	$N$번 구역에서 시계 방향으로 한 칸 더 갈 경우 
	$1$번 구역으로 도착한다. 
	
	홍익대학교에는 명소가 존재한다. 도현이는 알찬 투어를 위해 명소만을 방문하려 한다. 도현이는 
	$1$번 구역에 서있다.
	
	도현이를 위해 다음과 같은 쿼리를 수행하는 프로그램을 작성해보자.
	
	 
	$1$ 
	$i$ : 
	$i$번 구역이 명소가 아니었다면 명소로 지정되고, 명소였다면 지정이 풀리게 된다. (
	$1 \leq i \leq N$)
	 
	$2$ 
	$x$ : 도현이가 시계방향으로 
	$x$만큼 이동한다. (
	$1 \leq x \leq 10^9$)
	 
	$3$ : 도현이가 명소에 도달하기 위해 시계방향으로 최소 몇 칸 움직여야 하는 지 출력한다. 명소가 존재하지 않는 경우 
	$-1$을 출력한다.
 */
public class B_23326 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> ts = new TreeSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken());
			if (k == 1) {
				ts.add(i);
			}
		}
		
		int x = 0; //현재 위치. 
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			if (k == 1) {
				int place = Integer.parseInt(st.nextToken());
				
				if (ts.contains(place-1)) {
					ts.remove(place-1);
				} else {
					ts.add(place-1);
				}
				
			} else if (k == 2) {	
				x += Integer.parseInt(st.nextToken());
				if (x >= n) x %= n;
				
			} else if (k == 3) {
				if (ts.isEmpty()) sb.append("-1\n");
				else {
					int res = 0;
					if (ts.contains(x)) res = 0;
					else if (ts.higher(x) != null) {
						res = ts.higher(x) - x;
					} else {
						res = ts.first() + (n-x); 
					}
					sb.append(res+"\n");
				}
				
			}

		}
		System.out.println(sb);
		
		
		
	}
}
