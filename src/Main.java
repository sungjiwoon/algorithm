import java.io.*;
import java.util.*;

public class Main {	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] prioity = new int[10];
			int max_pri = 1;
			Queue<int[]> qu = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				int[] num = new int[2];
				num[0] = i;
				num[1] = Integer.parseInt(st.nextToken());
				qu.add(num);
				prioity[num[1]]++;
				if (num[1] > max_pri) max_pri = num[1];
			}
			int ans = 0;
			while (!qu.isEmpty()) {
				int[] q = qu.poll();
				if (q[1] < max_pri) {
					qu.add(q);
					continue;
				} else if (q[1] == max_pri) { //인쇄되는 경우.
					prioity[max_pri]--;
					while (max_pri > 1 && prioity[max_pri] == 0) max_pri--;
					ans++;
				}
				if (q[0] == m) break;
			}
			System.out.println(ans);

		}
	
	}

}














