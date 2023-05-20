import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {
	static int[][] usado;
	static int n;
	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		usado = new int[n+1][n+1];
		//usodo ют╥б. 
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int pi = Integer.parseInt(st.nextToken());
			int qi = Integer.parseInt(st.nextToken());
			int ri = Integer.parseInt(st.nextToken());
			
			usado[pi][qi] = usado[qi][pi] = ri;
		}
		
		for (int aa = 1; aa <= n; aa++) {
			for (int bb = 1; bb <= n; bb++) {
				for (int cc = 1; cc <= n; cc++) {
					if (aa == bb || bb == cc || aa == cc) continue;					
					if (usado[aa][bb] != 0 && usado[bb][cc] != 0 && usado[aa][cc] == 0) {
						usado[aa][cc] = usado[cc][aa] = Math.min(usado[aa][bb], usado[bb][cc]);
					} else if (usado[aa][bb] != 0 && usado[bb][cc] == 0 && usado[aa][cc] != 0) {
						usado[bb][cc] = usado[cc][bb] =Math.min(usado[aa][bb], usado[aa][cc]);
					} else if (usado[aa][bb] == 0 && usado[bb][cc] != 0 && usado[aa][cc] != 0) {
						usado[aa][bb] = usado[bb][aa] = Math.min(usado[bb][cc], usado[aa][cc]);
					}
				}
			}
		}
		
		//System.out.println(Arrays.deepToString(usado));
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ki = Integer.parseInt(st.nextToken());
			int index =  Integer.parseInt(st.nextToken());
			int cnt = 0;
			for (int k = 1; k <= n; k++) {
				if (usado[index][k] >= ki) cnt++;
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
		
	}
	
}
