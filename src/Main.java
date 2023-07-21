import java.io.*;
import java.util.*;

public class Main {
	private static String[][] data = new String[9][9];
	private static int ans = -1;
	private static HashMap<String, Integer> sqrt_map = new HashMap<>();

	private static void fill_sqrt() {
		double max_num = Math.sqrt(999999999); //나올 수 있는 최대 숫자의 제곱근까지 넣는다.
		for (int i = 0; i <= max_num+1; i++ ) {
			sqrt_map.put(String.valueOf(i*i), 1);
		}
	}

	private static boolean is_sqrt(String s) {
		int num = Integer.parseInt(s);
		if (Math.pow((int) Math.sqrt(num),2) == num) return true;
		return false;
	}

	private static void func(int n, int m) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				for (int x = -n; x < n; x++) {
					for (int y = -m; y < m; y++) {
						if (x == 0 && y == 0) continue;
						int ii = i, jj = j;
						String now = "";

						while (ii >= 0 && ii < n && jj >= 0 && jj < m) {
							now += data[ii][jj];
							if (is_sqrt(now)) ans = Math.max(ans, Integer.parseInt(now));
							ii += x;
							jj += y;
						}
						if (is_sqrt(now)) ans = Math.max(ans, Integer.parseInt(now));
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			data[i] = br.readLine().split("");
		}

		fill_sqrt();
		func(n,m);
		System.out.println(ans);
	
	}

}














