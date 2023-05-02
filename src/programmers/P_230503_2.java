package programmers;

import java.io.IOException;
import java.util.Arrays;
/*
 * ������ ���� �̵� (lv 2)
 * ���� ����
OO �����Ҵ� �� ���� K ĭ�� ������ �����ϰų�, (������� �� �Ÿ�) x 2 
�� �ش��ϴ� ��ġ�� �����̵��� �� �� �ִ� Ư���� ����� ���� ���̾� ��Ʈ�� �����Ͽ� �Ǹ��ϰ� �ֽ��ϴ�. 
�� ���̾� ��Ʈ�� �������� �۵��Ǵµ�, �����̵��� �ϸ� ������ ��뷮�� ���� ������, 
������ K ĭ�� �����ϸ� K ��ŭ�� ������ ��뷮�� ��ϴ�. 
�׷��Ƿ� ���̾� ��Ʈ�� �����ϰ� �̵��� ���� ���� �̵��� �ϴ� ���� �� ȿ�����Դϴ�. 
���̾� ��Ʈ �����ڴ� ���̾� ��Ʈ�� �����ϰ� �Ÿ��� N ��ŭ ������ �ִ� ��ҷ� ������ �մϴ�. 
��, ������ ��뷮�� ���̱� ���� ������ �̵��ϴ� ���� �ּҷ� �Ϸ��� �մϴ�. 
���̾� ��Ʈ �����ڰ� �̵��Ϸ��� �Ÿ� N�� �־����� ��, 
����ؾ� �ϴ� ������ ��뷮�� �ּڰ��� return�ϴ� solution �Լ��� ����� �ּ���.
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
