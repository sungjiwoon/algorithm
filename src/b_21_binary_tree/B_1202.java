package b_21_binary_tree;

import java.io.*;
import java.util.*;
class Jew {
	int m, v;
	Jew(int m, int v) {
		this.m = m;
		this.v = v;
	}
	
}
public class B_1202 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Jew[] jew = new Jew[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jew[i] = new Jew(m, v);
		}
		
		/* 가격 정렬 타임 ~~ */
		Arrays.sort(jew, new Comparator<Jew>() {
			@Override
			public int compare(Jew j1, Jew j2) {
				if (j1.v == j2.v) {
					return j2.m-j1.m;
				} else {
					return j2.v-j1.v;
				}
			}
		});
		System.out.println(Arrays.toString(jew));
		
		TreeMap<Integer, Integer> bag = new TreeMap<>();
	
		for (int i = 0; i < k; i++) {
			int c = Integer.parseInt(br.readLine());
			if (bag.containsKey(c)) {
				bag.put(c, bag.get(c)+1);
			} else bag.put(c, 1);
		}
		
		int price = 0;
		for (int i = 0; i < n; i++) {
			Jew j = jew[i];
			//key 가격, m 무게
			int m = j.m;
			int c = -1;
			//System.out.println("m : " + m);
			if (bag.containsKey(m)) {
				c = m;
				int next = bag.get(c);
				if (next > 1) bag.put(c, next-1);
				else bag.remove(c);
				price+=j.v;
				//System.out.println(v + " " + c);
			} else {				
				if (bag.higherKey(m) == null) continue;
				c = bag.higherKey(m);
				int next = bag.get(c);
				if (next > 1) bag.put(c, next-1);
				else bag.remove(c);
				//System.out.println(v + " " + c);
				price += j.v;
			}
			
		}
		System.out.println(price);
		
		
	}
}
