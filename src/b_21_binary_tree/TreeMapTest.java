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
		/* 인자로 받은 key보다 작은 값을 key로 가지고 있는 Entry들 중, 
		 * 가장 높은 값의 key를 가지고 있는 Entry를 리턴한다. 만약 값이 없으면 null을 return 한다.
		 */
		
		System.out.println("tmap.floorEntry(10) : " + tmap.floorEntry(10));
		//key와 같거나 작은 값을 key로 가지고 있는 Entry들 중, 
		//가장 높은 값의 key를 가지고 있는 Entry를 리턴한다. 만약 값이 없으면 null을 return 한다.
		
		System.out.println("tmap.ceilingEntry(10) : " + tmap.ceilingEntry(10));
		/* 인자로 받은 key와 같거나 작은 값을 key로 가지고 있는 Entry들 중, 
		 * 가장 높은 값의 key를 가지고 있는 Entry를 리턴한다. 만약 값이 없으면 null을 return 한다.
		 */
		
		System.out.println("tmap.higherEntry(10) : " + tmap.higherEntry(10));
		/*
		 * 인자로 받은 key보다 큰 값들 중에서 가장 작은 값의 key를 가진 entry를 반환. 
		 */
		
		System.out.println("tmap.firstEntry() : " + tmap.firstEntry());
		//treemap 첫번쨰 entry
		
		System.out.println("tmap.lastEntry() : " + tmap.lastEntry());
		//treemap 가장 마지막 entry
		
		System.out.println("tmap.descendingMap() : " + tmap.descendingMap());
		//treemap 내림차순 정렬하여 map으로 리턴. 
		
		System.out.println("tmap.descendingKeySet() : " + tmap.descendingKeySet());
		//treemap 내림차순 정렬하여 keySet으로 리턴. 
		
		
		
	}
}
