package b_21_binary_tree;

import java.util.Map.Entry;
import java.util.TreeMap;

public class TreeMapTest {
	public void work() {
		TreeMap<Integer, String> tmap = new TreeMap<>();
		tmap.put(10, "t10");
		tmap.put(2, "t2");
		tmap.put(1, "t1");
		tmap.put(13, "t13");
		tmap.put(9, "t9");
		tmap.put(8, "t8");
		
		for (int i : tmap.keySet()) {
			System.out.print(tmap.get(i) + " ");
		}
		System.out.println();
//		
		System.out.println("--------------");
		
		tmap.put(5,"t5");
		for (int i : tmap.keySet()) {
			System.out.println(tmap.get(i));
		}
		
		for (Entry<Integer,String> e : tmap.entrySet()) {
			System.out.println(e.getValue());
		}
		
		for (String s : tmap.values()) {
			System.out.print(s + " ");
		}
		
		System.out.println();
//		
		System.out.println("--------------");
		
		System.out.println("tmap.lowerEntry(10) : " + tmap.lowerEntry(10));
		/* ���ڷ� ���� key���� ���� ���� key�� ������ �ִ� Entry�� ��, 
		 * ���� ���� ���� key�� ������ �ִ� Entry�� �����Ѵ�. ���� ���� ������ null�� return �Ѵ�.
		 */
		
		System.out.println("tmap.floorEntry(10) : " + tmap.floorEntry(10));
		//key�� ���ų� ���� ���� key�� ������ �ִ� Entry�� ��, 
		//���� ���� ���� key�� ������ �ִ� Entry�� �����Ѵ�. ���� ���� ������ null�� return �Ѵ�.
		
		System.out.println("tmap.ceilingEntry(10) : " + tmap.ceilingEntry(10));
		/* ���ڷ� ���� key�� ���ų� ���� ���� key�� ������ �ִ� Entry�� ��, 
		 * ���� ���� ���� key�� ������ �ִ� Entry�� �����Ѵ�. ���� ���� ������ null�� return �Ѵ�.
		 */
		
		System.out.println("tmap.higherEntry(10) : " + tmap.higherEntry(10));
		/*
		 * ���ڷ� ���� key���� ū ���� �߿��� ���� ���� ���� key�� ���� entry�� ��ȯ. 
		 */
		
		System.out.println("tmap.firstEntry() : " + tmap.firstEntry());
		//treemap ù���� entry
		
		System.out.println("tmap.lastEntry() : " + tmap.lastEntry());
		//treemap ���� ������ entry
		
		System.out.println("tmap.descendingMap() : " + tmap.descendingMap());
		//treemap �������� �����Ͽ� map���� ����. 
		
		System.out.println("tmap.descendingKeySet() : " + tmap.descendingKeySet());
		//treemap �������� �����Ͽ� keySet���� ����. 
		
		
		
	}
}
