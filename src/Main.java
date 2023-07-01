import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class State {
	int x, t;
	State(int x, int t){
		this.x = x;
		this.t = t;
	}
}

public class Main {	

	public static void main(String[] args) throws Exception {	
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] map = new int[100001];
		int[] dx = {-1,1};
		
		PriorityQueue<State> qu = new PriorityQueue<>(new Comparator<State>() {
			@Override
			public int compare(State o1, State o2) {
				
				return o1.t - o2.t;
			}
		});
		qu.add(new State(n,0));
		int ans = 100000;
		while (!qu.isEmpty()) {
			State q = qu.poll();
			
			if (q.x == k) {
				ans = Math.min(q.t, ans);
				break;
			}
			
			for (int kk = 0; kk < 2; kk++) {
				int xx = q.x + dx[kk];
				if (xx < 0 || xx >= 100001) continue;
				qu.add(new State(xx, q.t+1));
			}
			
			if (q.x * 2 < 100001) qu.add(new State(q.x*2, q.t)); 
		}
		
		System.out.println(ans);
	
	}
}
