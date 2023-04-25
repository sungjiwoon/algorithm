import java.io.*;
import java.util.*;

public class Main {
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
			if (vis[i] < 1) res++;
		}
		
		return res;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			nums = new int[n+1];
			String[] sn = br.readLine().split(" ");
			for (int i = 1; i <= n; i++) {
				nums[i] = Integer.parseInt(sn[i-1]);
			}
			
			vis = new int[n+1];
			System.out.println(bfs());	
		}
	}
	
}
