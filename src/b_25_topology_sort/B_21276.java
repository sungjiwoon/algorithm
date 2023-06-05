package b_25_topology_sort;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * �躸 ������ ȣ�� 
 * ��� 2
 * �޸��ʰ�
 * �ֶ߳İ�~~~~~~~~~~
 */
public class B_21276 {

	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		String[] values = new String[n+1];
		values[0] = "A";
		HashMap<String, Integer> hs = new HashMap<>(); //index ������.
		int[] anc = new int[n+1]; //arr[i] = k -> i�� ������ ��  
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>(); //string�� ������� ��� ������.
		HashMap<Integer, ArrayList<String>> child = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			String value = st.nextToken();
			values[i] = value;
			
			hs.put(value, i);
			hm.put(i, new ArrayList<>());
			child.put(i, new ArrayList<>());
		}
		
		int m = Integer.parseInt(br.readLine());
		while (m-- > 0 ) {
			st = new StringTokenizer(br.readLine(), " ");
			String xx = st.nextToken();
			String yy = st.nextToken(); //x�� ���� y y- > x 
			
			int x = hs.get(xx);
			int y = hs.get(yy);
			
			ArrayList<Integer> list = hm.get(y);
			list.add(x);
			hm.put(y, list);
			
			//int index = hs.get(x);
			anc[x]++; //x�� ������ �� ++
		}
		
		/* root ã�� : ���Ͽ� ���ε� �̿�. */
		ArrayList<String> roots = new ArrayList<>();
		Queue<Integer> qu = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (anc[i]==0) {
				roots.add(values[i]);
				qu.add(hs.get(values[i]));
			}
		}
		
		while (!qu.isEmpty()) {
			int q = qu.poll();
			
			ArrayList<Integer> par = hm.get(q);
			for (int p : par) {				
				//root�� �ڽĵ� . 
				//int index = hs.get(p);
				anc[p]--;
				if (anc[p] == 0) {
					ArrayList<String> ch = child.get(q);
					ch.add(values[p]);
					child.put(q, ch);
					qu.add(p);
				} 
				
	
			}
		}

		Collections.sort(roots);
		sb.append(roots.size()+"\n");
		for (String ro : roots) {
			sb.append(ro + " ");
		}
		sb.append("\n");
		Arrays.sort(values, 1, values.length);
		for (int i = 1; i <= n; i++) {
			String key = values[i];
			int index = hs.get(key);
			ArrayList<String> list = child.get(index);
			sb.append(values[i] + " " + list.size() + " ");
			Collections.sort(list);
			for (String s : list) {
				sb.append(s+" ");
			}
			sb.append("\n");	
		}
		System.out.println(sb);
		
		
	}
}









