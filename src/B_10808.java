import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_10808 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int[] alp = new int[26];
		for (int i = 0; i < 26; i++) alp[i] = 0;
		for (int i = 0; i < s.length(); i++) {
			alp[s.charAt(i)-'a']++;
		}
		for (int i = 0; i < 26; i++) {
			System.out.print(alp[i] + " ");
		}
	}
}
