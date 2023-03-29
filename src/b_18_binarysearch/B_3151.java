package b_18_binarysearch;

import java.io.*;
import java.util.*;

public class B_3151 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		/* ���� �� �ʱ�ȭ �κ� */	
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) 
			a[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(a);
		//�ϴ� �� ���� �� ���Ѵ�. 
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				int tmp = a[i]+a[j];
				if (Arrays.binarySearch(a, j+1,n, (-1) * tmp) >= 0) cnt++;
			}
		}
		//Arrays.sort(two,0,index-1);
		
		//a[i]+a[j]+a[k] = 0
		//0-a[k] = a[i]+a[j] -> a[k]*(-1) = a[i]+a[j] �� �� ã��.
		//�ߺ�����.. ��� ����.. 
		
		
		
		System.out.println(cnt);
		return;	
			
	}
}
