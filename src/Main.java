import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int l, c;
	static char[] map;
	private static void func(int st, String res) {
		if (res.length()==l) {
			System.out.println(res);
			return;
		}
		
		for (int i = st; i < c; i++) {
			res += String.valueOf(map[i]); //추가!
			func(i+1, res);
			res = res.substring(0,res.length()-1); //다시 원상 복구용.
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[c];
		String s = br.readLine();
		for (int i = 0; i < c; i++)
			map[i] = s.charAt(i*2);
		System.out.println(Arrays.toString(map));
		Arrays.sort(map);
		System.out.println(Arrays.toString(map));
		
		func(0,"");
		
	}
}
