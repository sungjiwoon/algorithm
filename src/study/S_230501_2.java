package study;

import java.io.IOException;

public class S_230501_2 {
	private static int solution(int n) {
		//n의 2진수 값 구하기. 
		//String tmp = Integer.toBinaryString(n);
		int tmp_n = n;
		String tmp = "";
		while (tmp_n > 0) {
			tmp += String.valueOf(tmp_n%2);
			tmp_n /= 2;
		}
		int n_1_cnt = 0;
		for (int i = 0; i < tmp.length(); i++) {
			if (tmp.charAt(i) == '1') n_1_cnt++;
		}
		int t = n;
		while (true) {
			t = t+1;
			tmp = "";
			tmp_n = t;
			while (tmp_n > 0) {
				tmp += String.valueOf(tmp_n%2);
				tmp_n /= 2;
			}
					
			int t_1_cnt = 0;
			for (int i = 0; i < tmp.length(); i++) {
				if (tmp.charAt(i) == '1') t_1_cnt++;
			}
			if (n_1_cnt == t_1_cnt) return t;
		}
	}
	public void work() throws NumberFormatException, IOException {
	    	System.out.println(solution(78));
	}
}
