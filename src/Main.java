import java.io.*;
import java.util.*;


public class Main {
	//이해못함 걍 포기~
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* 선언 및 초기화 부분 */
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				n /= i;
				sb.append(i+"\n");
			}
			if (n == 1) break;
		}
		System.out.println(sb);
		
	}
	
}
