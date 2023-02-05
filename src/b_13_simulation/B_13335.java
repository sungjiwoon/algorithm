package b_13_simulation;

import java.io.*;
import java.util.*;
/*
 * 문제명 : 트럭
 * 난이도 : 실버 1
 * 문제
	강을 가로지르는 하나의 차선으로 된 다리가 하나 있다. 이 다리를 n 개의 트럭이 건너가려고 한다. 트럭의 순서는 바꿀 수 없으며, 트럭의 무게는 서로 같지 않을 수 있다. 
	다리 위에는 단지 w 대의 트럭만 동시에 올라갈 수 있다. 다리의 길이는 w 단위길이(unit distance)이며, 각 트럭들은 하나의 단위시간(unit time)에 하나의 단위길이만큼만 이동할 수 있다고 가정한다. 
	동시에 다리 위에 올라가 있는 트럭들의 무게의 합은 다리의 최대하중인 L보다 작거나 같아야 한다. 참고로, 다리 위에 완전히 올라가지 못한 트럭의 무게는 다리 위의 트럭들의 무게의 합을 계산할 때 포함하지 않는다고 가정한다.
	
	예를 들어, 다리의 길이 w는 2, 다리의 최대하중 L은 10, 다리를 건너려는 트럭이 트럭의 무게가 [7, 4, 5, 6]인 순서대로 다리를 오른쪽에서 왼쪽으로 건넌다고 하자. 
	이 경우 모든 트럭이 다리를 건너는 최단시간은 아래의 그림에서 보는 것과 같이 8 이다.

	Figure 1. 본문의 예에 대해 트럭들이 다리를 건너는 과정.
	
	다리의 길이와 다리의 최대하중, 그리고 다리를 건너려는 트럭들의 무게가 순서대로 주어졌을 때, 모든 트럭이 다리를 건너는 최단시간을 구하는 프로그램을 작성하라.
	
	입력
	입력 데이터는 표준입력을 사용한다. 입력은 두 줄로 이루어진다. 입력의 첫 번째 줄에는 세 개의 정수 n (1 ≤ n ≤ 1,000) , w (1 ≤ w ≤ 100) and L (10 ≤ L ≤ 1,000)이 주어지는데, 
	n은 다리를 건너는 트럭의 수, w는 다리의 길이, 그리고 L은 다리의 최대하중을 나타낸다. 입력의 두 번째 줄에는 n개의 정수 a1, a2, ⋯ , an (1 ≤ ai ≤ 10)가 주어지는데, ai는 i번째 트럭의 무게를 나타낸다.
	
	출력
	출력은 표준출력을 사용한다. 모든 트럭들이 다리를 건너는 최단시간을 출력하라.
	
	예제 입력 1 
	4 2 10
	7 4 5 6
	예제 출력 1 
	8
 */
class Truck {
	int wei;
	int dis;
	public Truck(int wei, int dis) {
		this.wei = wei; //트럭의 무게
		this.dis = dis; //트럭이 다리 위를 건넌 거리. 
	}
}
public class B_13335 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Truck[] ts = new Truck[n];
		for (int i = 0; i < n; i++) {
			ts[i] = new Truck(0,0);
		}
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < n; i++) {
			ts[i].wei = Integer.parseInt(st.nextToken());
			ts[i].dis = 0;
		}
		
		int x = 0; //다리위에 올라가져 있는 트럭 무게의 합. 
		int first = 0; //선두 차량
		int tail = first; //맨 뒤 차량
		int count = 0; // 총 시간 (결과값)

		while (ts[n-1].dis!=w && first < n) { //단위시간 반복문
			if (ts[tail].dis == 0) { //후두 차량이 맨 마지막 차량일 경우를 대비 . 
				x += ts[tail].wei;
				if (x > l) {
					x -= ts[tail].wei;
					tail--;
				}
			}
			for (int i = first; i <= tail; i++) {
				ts[i].dis++;
			}
			if (ts[first].dis == w) {
				x -= ts[first].wei;
				first++;
			}
			count++;
			
			tail++;
			if (tail == n) tail--;
			
		}

		System.out.println(count+1);
			
	}
}
