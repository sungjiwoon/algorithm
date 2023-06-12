package b_27_floyd;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * 가운데서 만나기 (골드 4)
 * 플로이드 워샬 
 */
public class B_21940 {
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = 3000; //임의의 큰 숫자 채워 넣는다. 
			}
			map[i][i] = 0;
		}
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken()); //걸리는 시간. 
			map[a][b] = t;
		}
		
		int K = Integer.parseInt(br.readLine()); //인원 수. 
		ArrayList<Integer> ci = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int k = 0; k < K; k++) ci.add(Integer.parseInt(st.nextToken()));
		//도시 담겼음. 
		
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		//왕복 시간의 합 . map[i][k] + map[k][i]
		//공통된 k의 시간을 확인해야함. 
		//모든 도시마다가 아니라, 사람의 수만 따르면 된다. 
		PriorityQueue<int[]> path = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] arg0, int[] arg1) {
				// TODO Auto-generated method stub
				if(arg0[1] == arg1[1]) return arg0[0] - arg1[0];
				return arg0[1]-arg1[1];
			}
		});
		
		//왕복시간들의 최댓값이 -> 최솟값이 되는 경유지의 값
		for (int i = 1; i <= n; i++) { //경유 x
			int len = 0;
			for (int c : ci) {
				len = Math.max(map[i][c] + map[c][i], len);
			}
			int[] tmp = {i, len};
			path.add(tmp);
		}
		
		int[] res = path.poll();
		System.out.print(res[0] + " ");
		while (!path.isEmpty() && res[1] == path.peek()[1]) {
			System.out.print(path.poll()[0] + " ");
		}
		
		
	}
}









