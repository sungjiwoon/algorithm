package b_15_dp;

import java.io.*;
/*
 * LCS (���5) 0.1��
 * LCS(Longest Common Subsequence, ���� ���� �κ� ����)������ �� ������ �־����� ��, 
 * ����� �κ� ������ �Ǵ� ���� �� ���� �� ���� ã�� �����̴�.

	���� ���, ACAYKP�� CAPCAK�� LCS�� ACAK�� �ȴ�.
	
	�ذ� ��� : LCS �˰��� !!!  <- �̰� ��ĳ �����س� ���̤�
	���� https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
 */
public class B_9251 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		String a = br.readLine();
		String b = br.readLine();
		
		int[][] lcs = new int[1001][1001];
		int res = 0;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					if (i == 0 || j == 0) lcs[i][j] = 1;
					else lcs[i][j] = lcs[i-1][j-1]+1;
				} else if (i != 0 && j != 0){
					lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				} else if (j == 0 && i > 0) {
					lcs[i][j] = lcs[i-1][j];
				} else if (j > 0 && i == 0){
					lcs[i][j] = lcs[i][j-1];
				}
				res = Math.max(lcs[i][j], res);
			}
		}
		System.out.println(res);
		
		
		
		
		
	}
}
