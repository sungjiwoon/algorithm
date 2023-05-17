import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class Main {

	public static void main(String[] args) throws Exception {		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String a = br.readLine();
		String b = br.readLine();
		if (b.length() < a.length()) {
			String tmp = b;
			b = a;
			a = tmp;
		}
		
		int[] dp = new int[1001];

		int k = 0;
		dp[0] = 0;
		for (int i = 0; i < a.length(); i++) {
			int j = 0;
			//if (i > 0 && k != 0) j = k+1;
			boolean isSame = false;
			while (j < b.length()) {
				if (a.charAt(i) == b.charAt(j)) {
					if (i > 0)
						dp[i] = Math.max(dp[i-1] + 1, dp[i]);
					else dp[i] = 1;
					//k = j;
					isSame = true;
					break;
				}
				j++;
			}
			if (!isSame && i > 0) dp[i] =  Math.max(dp[i-1], dp[i]);
		}
		System.out.println(dp[a.length()-1]);
	}
	
}
