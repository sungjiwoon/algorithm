package b_09_bfs;

import java.util.*;
import java.io.*;

import b_13_simulation.Pair;
/*
 * tc
 * 6
2 3 4 5 6 2
output : 1

5
2 5 4 5 2
output : 3

6
1 3 4 3 2 6
output : 2

13
2 4 5 2 4 1 8 9 10 11 9 10 10
output : 8

10
2 5 7 1 6 8 8 3 5 10
output : 6

10
2 7 10 5 3 3 9 10 6 3
output : 8

6
2 1 1 2 6 3
output : 4
 * 
 */
public class B_9466 {
	static int n;
	static int[] nums, vis;
	static StringBuilder sb = new StringBuilder();
	private static int bfs() {
		Queue<Integer> qu = new LinkedList<>(); //bfs 용	
		
		int res = 0;
		for (int i = 1; i <= n; i++) {
			if (vis[i] == 0) {
				qu.add(i); 
				ArrayList<Integer> list = new ArrayList<>();
				list.add(i);
				while (!qu.isEmpty()) {
					int k = qu.poll(); 
					
					if (vis[k] == 0) {
						int key = 0;
						for (int l : list) {
							if (l == nums[k]) {
								key = l;
							} 
							if (key != 0) {
								vis[l] = key;
							} 
						}
						if (key != 0) { //사이클이 있다는 뜻. 
							for (int l : list) {
								if (vis[l] != key) {
									vis[l] = -1;
								} else {
									break;
								}
								
							}
						} else {
							qu.add(nums[k]);
							list.add(nums[k]); //1 2 3 4 5 6 
						}

						
					} else { //0이 아닌경우 -> 즉 값이 있거나, 쓰레기 값인 경우. 
						break;
					}
					
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			sb.append(vis[i] + " ");
			if (vis[i] < 1) res++;
		}
		//System.out.println("vis 값 : \n" +sb);
		return res;
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		int T = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine()); 
		while (n != 0) {
			nums = new int[n+1];
			String[] sn = br.readLine().split(" ");
			Queue<Integer> qu = new LinkedList<>();
			for (int i = 1; i <= n; i++) {
				nums[i] = Integer.parseInt(sn[i-1]);
				qu.offer(nums[i]);
			}
			
			vis = new int[n+1];
			
			sb.append("output :: " + bfs() + "\n");	
			
			n = Integer.parseInt(br.readLine()); 
		}
		System.out.println(sb);
	}
	
}
