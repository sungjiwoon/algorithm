package study;

import java.io.*;
import java.util.*;

/*
 * ������ ǥ��
	���� ����
	Finn�� ���� ���а��ο� ���� �ֽ��ϴ�. ���� ���θ� �ϴ� Finn�� �ڿ��� n�� ������ �ڿ������ ǥ�� �ϴ� ����� ��������� ����� �˰� �Ǿ����ϴ�. ������� 15�� ������ ���� 4������ ǥ�� �� �� �ֽ��ϴ�.
	
	1 + 2 + 3 + 4 + 5 = 15
	4 + 5 + 6 = 15
	7 + 8 = 15
	15 = 15
	�ڿ��� n�� �Ű������� �־��� ��, ���ӵ� �ڿ������ n�� ǥ���ϴ� ����� ���� return�ϴ� solution�� �ϼ����ּ���.
	
	���ѻ���
	n�� 10,000 ������ �ڿ��� �Դϴ�.
	
	����� ��
	n	result
	15	4
 */

public class S_230501 {
	 private static int solution(int n) {
		 int cnt = 0;
		 for (int i = 1; i <= n; i++) {
	    		int sum = i;
	    		for (int j = i+1; j <= n; j++) {
	    			sum += j; 
	    			if (sum >= n) {	    				
	    				break;
	    			}
	    		}
	    		if (sum == n) cnt++;
	    	}
	    	
	        return cnt;
	    }
	public void work() throws NumberFormatException, IOException {
	    	System.out.println(solution(15));
	}
}
