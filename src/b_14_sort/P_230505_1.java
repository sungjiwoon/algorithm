package b_14_sort;
import java.io.*;
import java.util.*;

//���� ���� 
//���α׷��ӽ� ���� ū�� lv2
public class P_230505_1 {
public String solution(int[] numbers) {
        
        String[] str = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        
        Integer[] nums = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, Collections.reverseOrder());
        
        
//        Arrays.sort(str, Collections.reverseOrder());
//        System.out.println("���ڿ� �������� : " + Arrays.toString(str));
        
        //���ڿ��� �ٿ��� ������. �� 30,3 -> 303 330 �ؼ� 330���� �����ϵ�����. 
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        });
        System.out.println("���ڿ� �������� : " + Arrays.toString(str));
        
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (a+b).compareTo(b+a);
            }
        });
        System.out.println("���ڿ� �������� : " + Arrays.toString(str));
        
        if (str[0].equals("0")) return "0";
        
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            answer.append(str[i]);
        }
        
        
        return answer.toString();
    }
	public void work() throws NumberFormatException, IOException {

		int[] nums = {3, 30, 23, 34, 5, 9};
		System.out.println(solution(nums));
		
		//���̺� ���� 
		String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};
		//���� ��������
		Arrays.sort(arr, new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        return s2.length() - s1.length();
		    }
		});
		System.out.println("���̺��� ���� " + Arrays.toString(arr));
		//���� ��������
		Arrays.sort(arr, new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		        return s1.length() - s2.length();
		    }
		});
		System.out.println("���̺��� ���� " + Arrays.toString(arr));
		
		
		
	}
}
