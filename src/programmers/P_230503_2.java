package programmers;

import java.io.IOException;
import java.util.Arrays;
/*
 * 점프와 순간 이동 (lv 2)
 * 문제 설명
OO 연구소는 한 번에 K 칸을 앞으로 점프하거나, (현재까지 온 거리) x 2 
에 해당하는 위치로 순간이동을 할 수 있는 특수한 기능을 가진 아이언 슈트를 개발하여 판매하고 있습니다. 
이 아이언 슈트는 건전지로 작동되는데, 순간이동을 하면 건전지 사용량이 줄지 않지만, 
앞으로 K 칸을 점프하면 K 만큼의 건전지 사용량이 듭니다. 
그러므로 아이언 슈트를 착용하고 이동할 때는 순간 이동을 하는 것이 더 효율적입니다. 
아이언 슈트 구매자는 아이언 슈트를 착용하고 거리가 N 만큼 떨어져 있는 장소로 가려고 합니다. 
단, 건전지 사용량을 줄이기 위해 점프로 이동하는 것은 최소로 하려고 합니다. 
아이언 슈트 구매자가 이동하려는 거리 N이 주어졌을 때, 
사용해야 하는 건전지 사용량의 최솟값을 return하는 solution 함수를 만들어 주세요.
 */
public class P_230503_2 {
	
	public int solution(int n) {
		int cnt = 0;
		while (n > 0) {
			if (n % 2 == 1) {
				cnt++;
				n -= 1;
			} else {
				n /= 2;
			}
		}
		return cnt;
		
		
    }	
	public void work() throws NumberFormatException, IOException {
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(5000));
		System.out.println(solution(1000000000));
		
	}
}
