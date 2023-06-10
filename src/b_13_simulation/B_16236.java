package b_13_simulation;

import java.io.*;
import java.util.*;

class Fish {
	int size, d, x, y;
	Fish(int size, int d, int x, int y) {
		this.size = size;
		this.d = d;
		this.x = x;
		this.y = y;
	}
}
public class B_16236 {
	static int n;
	static PriorityQueue<Fish> qu;
	static int sh_x, sh_y, sh_size; //�Ʊ� ����� ��ġ . 
	static Queue<Fish> qu2; // ���� ���ϴ� ������ ����. 
	static int cnt = 0; //������� ����. 
	static int[] dy = {-1,0,1,0}, dx = {0,-1,0,1};
	
	private static int measure(Fish f) {
		//�Ʊ���� �Ÿ� �����ϱ�.
		//�ڱ⺸�� ū �� ��ġ�� ������.. �ȵ�. 
		return 0;
	}
	
	private static void func() {
		for (int i = 0; i < cnt; i++) {
			Fish f = qu2.poll();
			f.d = measure(f);
			if (f.size < sh_size ) {
				qu.add(f);
			} else {
				qu2.add(f);
			}
		}
	}
	
	public void work() throws Exception {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		qu = new PriorityQueue<Fish>(new Comparator<Fish>() {
			@Override
			public int compare(Fish f1, Fish f2) {
				if (f1.d == f2.d) { //�Ʊ������ �Ÿ��� ���ٸ�. 
					if (f1.y == f2.y) {
						return f1.x - f2.x;
					}
					return f1.y - f2.y;
				} else {
					return f1.d - f2.d;
				}
			}
		});
		qu2 = new LinkedList<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(st.nextToken());
				if (v == 9) { //�Ʊ� ���. 
					sh_x = j;
					sh_y = i;			
					sh_size = 2;
				} else if (v >= 1 && v <= 6){
					Fish f = new Fish(v, 0, j, i);
					qu2.add(f);
					cnt++;
				}
			}
		}
		
		
			
	}
}





