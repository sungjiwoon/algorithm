package study;

public class S_221228 {
	//���α׷��ӽ� https://school.programmers.co.kr/learn/courses/30/lessons/17681
	/*
	 * �������
		�׿��� ��� ���ε��� ������ ���ܳ��� ��Ҹ� �˷��� ��������� �տ� �־���. 
		�׷��� �� ��������� ���ڷ� ��ȣȭ�Ǿ� �־� ��ġ�� Ȯ���ϱ� ���ؼ��� ��ȣ�� �ص��ؾ� �Ѵ�. 
		������ ���� ��ȣ�� �ص��� ����� ������� �޸� �Բ� �߰��ߴ�.
	 */
		public String[] solution(int n, int[] arr1, int[] arr2) {
			String[] answer = new String[n];
	        
	        for (int i = 0; i < n; i++) {
	        	//10�������� 2���� ��ȯ. String.format �Լ��� ����Ͽ� �ڸ����� �����ϰ� �ϵ��� ��. Integer�� ����� ��Ÿ�ӿ��� �߻�.
	        	String s1 = String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr1[i]))); 
	        	String s2 = String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr2[i])));
	        	
	        	String s = "";
	        	
	        	//������� String���� �� �� �ϳ��� 1�̸� # �ƴϸ� ����
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
