package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1759 {
	static int l, c;
	static char[] map;
	private static void func(int st, String res) {
		if (res.length()==l) {
			if (have_aeiou(res)==0 || l-have_aeiou(res) < 2) return;
			System.out.println(res);
			return;
		}
		
		for (int i = st; i < c; i++) {
			res += String.valueOf(map[i]); //추가!
			func(i+1, res);
			res = res.substring(0,res.length()-1); //다시 원상 복구용.
		}
	}
	private static int have_aeiou(String res) {
			int cnt=0;
			if (res.contains("a")) cnt++;
			if (res.contains("e")) cnt++;
			if (res.contains("i")) cnt++;
			if (res.contains("o")) cnt++;
			if (res.contains("u")) cnt++;
			return cnt;
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[c];
		String s = br.readLine();
		for (int i = 0; i < c; i++)
			map[i] = s.charAt(i*2);
		Arrays.sort(map);
		
		func(0,"");
	}
}
