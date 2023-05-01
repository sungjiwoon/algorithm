package study;

import java.io.IOException;
import java.util.Arrays;
/*
 * 문제명 : 카펫 (프로그래머스 lv2)
 * Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 
 * 전체 카펫의 크기는 기억하지 못했습니다.

Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 
세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
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
