package study;

import java.io.*;
import java.util.*;
/*
 * ���� : ���α׷��ӽ� lv2 �ؽ� (īī�� 2018)
 * ĳ��
�������������� �ٹ��ϴ� �������� �������� ���� �̸��� �˻��ϸ� �ش� ���ÿ� ���õ� ���� �Խù����� �����ͺ��̽����� �о� �����ִ� ���񽺸� �����ϰ� �ִ�.
�� ���α׷��� �׽��� ������ ����ϰ� �ִ� ����ġ�� ���񽺸� �����ϱ� �� �� ������ ���� ���� ������ �����Ͽ��µ�, �������� �ۼ��� �κ� �� �����ͺ��̽����� �Խù��� �������� �κ��� ����ð��� �ʹ� ���� �ɸ��ٴ� ���� �˰� �Ǿ���.
����ġ�� ���������� �ش� ������ �����϶�� �۴��ϱ� �����Ͽ���, �������� DB ĳ�ø� �����Ͽ� ���� ������ �õ��ϰ� ������ ĳ�� ũ�⸦ �󸶷� �ؾ� ȿ�������� ���� ������ ��Ȳ�̴�.

����ġ���� �ô޸��� �������� ����, DB ĳ�ø� ������ �� ĳ�� ũ�⿡ ���� ����ð� ���� ���α׷��� �ۼ��Ͻÿ�.
 */
public class S_230501_5 {
	
	public int solution(int cacheSize, String[] cities) {
		int cnt = 0;
        Queue<String> qu = new LinkedList<>();
        for (int i = 0; i < cities.length; i++) {
        	String s = cities[i].toLowerCase();        	
        	if (!qu.isEmpty() && qu.contains(s)) {
        		cnt++;
        		qu.remove(s);
        		qu.add(s);
        	} else {
        		if (qu.isEmpty() || qu.size() < cacheSize) {
        			qu.add(s);
        		} else if (qu.size() == cacheSize){
        			qu.poll();
        			qu.add(s);
        		}
        		cnt += 5;
        	}
        }
        return cnt;
        
    }
	public void work() throws NumberFormatException, IOException {
		String[] st = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
	    System.out.println(solution(5, st));
	}
}
