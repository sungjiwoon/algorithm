package b_16_greedy;
import java.io.*;
import java.util.*;

/*
 * ���ִ��� ���� (��� 3)
 * 
 * �ð� ����	�޸� ����	����	����	���� ���	���� ����
1 ��	192 MB	12396	3025	2110	25.164%
����
������ ���ִ��� �¾ ��罺���� ���̴�. ���� �� ���� ����ϱ� ���� �� ���� �Ǿ��ִ� ���� ������ ������ �����ߴ�.

�� N���� ���� �ִ� ��, ���� ��� ���� �ؿ� �Ǿ ���� �ؿ� ����. �ϳ��� ���� �Ǵ� ���� ���� ���� ������ �ִ�. ���� ���, 5�� 8�� �Ǿ 6�� 13�� ���� ���� 5�� 8�Ϻ��� 6�� 12�ϱ����� ���� �Ǿ� �ְ�, 6�� 13���� �����Ͽ� ���ķδ� ���� �� �� ���ٴ� �ǹ��̴�. (���ش� 4, 6, 9, 11���� 30�ϱ��� �ְ�, 1, 3, 5, 7, 8, 10, 12���� 31�ϱ��� ������, 2���� 28�ϱ����� �ִ�.)

�̷��� N���� �ɵ� �߿��� ������ �� ������ �����ϴ� �ɵ��� �����ϰ� �ʹ�.

���ְ� ���� �����ϴ� ������ 3�� 1�Ϻ��� 11�� 30�ϱ��� ���� ���� �� ���� �̻� �Ǿ� �ֵ��� �Ѵ�.
������ ���� �����Ƿ� ������ �ɴ� �ɵ��� ���� ������ ���� �Ѵ�. 
N���� �ɵ� �߿��� ���� �� ������ �����ϴ�, �� 3�� 1�Ϻ��� 11�� 30�ϱ��� ���� ���� �� ���� �̻� �Ǿ� �ֵ��� �ɵ��� ������ ��, ������ �ɵ��� �ּ� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 

�Է�
ù° �ٿ��� �ɵ��� �� ���� N (1 �� N �� 100,000)�� �־�����. ���� N���� �ٿ��� �� ���� �Ǵ� ��¥�� ���� ��¥�� �־�����. �ϳ��� ��¥�� ���� ���� ��Ÿ���� �� ���ڷ� ǥ���ȴ�. ���� ��, 3 8 7 31�� ���� 3�� 8�Ͽ� �Ǿ 7�� 31�Ͽ� ���ٴ� ���� ��Ÿ����. 

���
ù° �ٿ� ������ �ɵ��� �ּ� ������ ����Ѵ�. ���� �� ������ �����ϴ� �ɵ��� ������ �� ���ٸ� 0�� ����Ѵ�.

���� �Է� 1 
4
1 1 5 31
1 1 6 30
5 15 8 31
6 10 12 10
���� ��� 1 
2

�������� �׸��� ���� . ����� . 
 */
class Flower {
	int d1, d2;

	public Flower(int d1,int d2) {
		this.d1 = d1;
		this.d2 = d2;
	}

	public int getD1() {
		return d1;
	}


}


public class B_2457 {
	
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); 
		
		/* ���� �� �ʱ�ȭ �κ� */
		int n = Integer.parseInt(br.readLine());
		Flower[] fs = new Flower[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int d1 = Integer.parseInt(st.nextToken()) * 100 +  Integer.parseInt(st.nextToken());
			int d2 = Integer.parseInt(st.nextToken()) * 100 +  Integer.parseInt(st.nextToken());
			fs[i] = new Flower(d1,d2);
		}
		
		
//		Arrays.sort(fs, new Comparator<Flower>() {
//			@Override
//			public int compare(Flower a, Flower b) {
//				return a.getD1() - b.getD1();
//			}
//		} );
		
//		for (int i = 0; i < n; i++) {
//			System.out.println(fs[i].d1 + " " + fs[i].d2);
//		}
//		
		int ans = 0;
		int t = 301; //3�� 1�Ϻ��� �ʼ� �̹Ƿ�. 
		
		while (t < 1201) {
			int nxt_t = t;
			for (int i = 0; i < n; i++) {
				if (fs[i].d1 <= t && fs[i].d2 > nxt_t) {
					nxt_t = fs[i].d2;
				}
			}
			
			if (t == nxt_t) {
				ans = 0;
				break;
			} //�ð��� ���ٴ� �� (������ ����.)
			
			ans++;
			t = nxt_t;
		}
		System.out.println(ans);
		
		
		
		
		
	}
}
