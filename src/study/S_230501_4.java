package study;

import java.io.IOException;
import java.util.Arrays;
/*
 * ������ : ī�� (���α׷��ӽ� lv2)
 * Leo�� ������ ���ƿͼ� �Ʊ� �� ī���� ������� �������� ��ĥ�� ������ ������ ���������, 
 * ��ü ī���� ũ��� ������� ���߽��ϴ�.

Leo�� �� ī�꿡�� ���� ������ �� brown, ����� ������ �� yellow�� �Ű������� �־��� �� ī���� ����, 
���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 */
public class S_230501_4 {
	 public int[] solution(int brown, int yellow) {
		 int b_ = (brown-4)/2;
		 int[] res = new int[2];
		 res[0] = 0;
		 res[1] = 0;
		 
		 for (int i = 1; i <= yellow; i++) {
			 for (int j = 1; j <= yellow; j++) {
				 if (i+j==b_ && i*j == yellow) {
					 if (i >= j) {
						 res[0] = i+2;
						 res[1] = j+2;
					 } else {
						 res[0] = j+2;
						 res[1] = i+2;
					 }
					 return res;
				 }
			 }
		 }
		 return res;	        
	 }
	public void work() throws NumberFormatException, IOException {
		
	    System.out.println(Arrays.toString(solution(8,1)));
	}
}
