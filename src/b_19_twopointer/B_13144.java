package b_19_twopointer;
import java.io.*;
import java.util.*;
/*
 * List of Unique Numbers ����
 
�ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	32 MB	4005	1471	1087	35.898%
����
���̰� N�� ������ �־��� ��, �������� ������ 1�� �̻��� ���� �̾��� �� ���� ���� ���� �� �������� �ʴ� ����� ���� ���ϴ� ���α׷��� �ۼ��Ͽ���.

�Է�
ù ��° �ٿ��� ������ ���� N�� �־�����. (1 �� N �� 100,000)

�� ��° �ٿ��� ������ ��Ÿ���� N���� ������ �־�����. ������ ��Ÿ���� ���� ��� 1 �̻� 100,000 �����̴�.

���
������ �����ϴ� ����� ���� ����Ѵ�.
 */
public class B_13144 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/* ���� �� �ʱ�ȭ �κ� */		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int res =0;
		int en = 0;
		
		boolean[] cnt = new boolean[100002];
		cnt[a[0]]=true;
		for (int srt = 0; srt < n; srt++) {
			while (en < n-1 && !cnt[a[en+1]]) {
				en++;
				cnt[a[en]]= true;
			}
			res += en-srt+1;
			cnt[a[srt]]=false;
		}
		System.out.println(res);
		
	}
}
