package study;

public class S_221228 {
	//프로그래머스 https://school.programmers.co.kr/learn/courses/30/lessons/17681
	/*
	 * 비밀지도
		네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 
		그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 
		다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
	 */
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];
	        
	        for (int i = 0; i < n; i++) {
	        	//10진수에서 2진수 변환. String.format 함수를 사용하여 자릿수를 일정하게 하도록 함. Integer를 썼더니 런타임에러 발생.
	        	String s1 = String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr1[i]))); 
	        	String s2 = String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr2[i])));
	        	
	        	String s = "";
	        	
	        	//만들어진 String에서 둘 중 하나라도 1이면 # 아니면 공백
	        	for (int j = 0; j < n; j++) {
	        		if (s1.charAt(j)=='1' || s2.charAt(j)=='1') {
	        			s += "#";
	        		}else {
	        			s += " ";
	        		}
	        	}
	        	answer[i] = s;
	        	
	        }
	        for (int i = 0; i <n;i++) {
	        	System.out.println(answer[i]);       
	        }
	        
	        
	        return answer;
	    }
}
