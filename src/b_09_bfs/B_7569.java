package b_09_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * ��� 5
 * 3���� �迭 ������ ��� �� �ִ� ���� �ð�!
 * 
 * ����
	ö���� �丶�� ���忡���� �丶�並 �����ϴ� ū â�� ������ �ִ�. �丶��� �Ʒ��� �׸��� ���� ���ڸ�� ������ ĭ�� �ϳ��� ���� ����, ���ڵ��� �������� �׾� �÷��� â�� �����Ѵ�.	
	â�� �����Ǵ� �丶��� �߿��� �� ���� �͵� ������, ���� ���� ���� �丶��鵵 ���� �� �ִ�. 
	���� �� �Ϸ簡 ������, ���� �丶����� ������ ���� �ִ� ���� ���� �丶����� ���� �丶���� ������ �޾� �Ͱ� �ȴ�. 
	�ϳ��� �丶�信 ������ ���� ��, �Ʒ�, ����, ������, ��, �� ���� ���⿡ �ִ� �丶�並 �ǹ��Ѵ�. 
	�밢�� ���⿡ �ִ� �丶��鿡�Դ� ������ ���� ���ϸ�, �丶�䰡 ȥ�� ������ �ʹ� ���� ���ٰ� �����Ѵ�. 
	ö���� â�� ������ �丶����� ��ĥ�� ������ �� �Ͱ� �Ǵ��� �� �ּ� �ϼ��� �˰� �;� �Ѵ�.
	
	�丶�並 â�� �����ϴ� ���ڸ���� ���ڵ��� ũ��� ���� �丶���� ���� ���� �丶����� ������ �־����� ��, ��ĥ�� ������ �丶����� ��� �ʹ���, �� �ּ� �ϼ��� ���ϴ� ���α׷��� �ۼ��϶�. 
	��, ������ �Ϻ� ĭ���� �丶�䰡 ������� ���� ���� �ִ�.
	
	�Է�
	ù �ٿ��� ������ ũ�⸦ ��Ÿ���� �� ���� M,N�� �׾ƿ÷����� ������ ���� ��Ÿ���� H�� �־�����. 
	M�� ������ ���� ĭ�� ��, N�� ������ ���� ĭ�� ���� ��Ÿ����. ��, 2 �� M �� 100, 2 �� N �� 100, 1 �� H �� 100 �̴�. 
	��° �ٺ��ʹ� ���� ���� ���ں��� ���� ���� ���ڱ����� ����� �丶����� ������ �־�����. ��, ��° �ٺ��� N���� �ٿ��� �ϳ��� ���ڿ� ��� �丶���� ������ �־�����. 
	�� �ٿ��� ���� �����ٿ� ����ִ� �丶����� ���°� M���� ������ �־�����. ���� 1�� ���� �丶��, ���� 0 �� ���� ���� �丶��, ���� -1�� �丶�䰡 ������� ���� ĭ�� ��Ÿ����. 
	�̷��� N���� ���� H�� �ݺ��Ͽ� �־�����.
	
	�丶�䰡 �ϳ� �̻� �ִ� ��츸 �Է����� �־�����.
	
	���
	�������� �丶�䰡 ��� ���� ������ �ּ� ��ĥ�� �ɸ������� ����ؼ� ����ؾ� �Ѵ�. ����, ����� ������ ��� �丶�䰡 �;��ִ� �����̸� 0�� ����ؾ� �ϰ�, �丶�䰡 ��� ������ ���ϴ� ��Ȳ�̸� -1�� ����ؾ� �Ѵ�.
 * 
 */
class Pair3 {
	int x,y,z;
	public Pair3(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
}
public class B_7569 {
	static int M, N, H;
	static int[][][] borad;
	static int[][][] dis;
	static Queue<Pair3> qu;
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());		
		borad = new int[H][N][M];
		dis = new int[H][N][M];
		qu = new LinkedList<>();
		int[] dx = {-1, 0, 1, 0, 0, 0};
		int[] dy = {0, 1, 0, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, -1, 1};
		for (int d[][] : dis) {
			for (int d2[] : d)
				Arrays.fill(d2,  -1);
		}
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < M; j++) {
					borad[h][i][j] = Integer.parseInt(st.nextToken());				
					if (borad[h][i][j] == 1) {
						qu.offer(new Pair3(i, j, h));
						dis[h][i][j] = 0;
					}
				}
			}
		}
		while (!qu.isEmpty()) {
			Pair3 p = qu.poll();
			for (int k = 0; k < 6; k++) {
				int xx = p.x + dx[k];
				int yy = p.y + dy[k];
				int zz = p.z + dz[k];
				
				
				if (xx >= N || xx < 0 || yy >= M || yy < 0 || zz >= H || zz < 0 ) continue;
				
				if (dis[zz][xx][yy] == -1 && borad[zz][xx][yy] == 0) {
					dis[zz][xx][yy] = dis[p.z][p.x][p.y]+1;
					qu.offer(new Pair3(xx, yy,zz));
					//System.out.println("-> " + xx + " " + yy);
				}
			}
		}	
		
		int max = 0; //���� ������ �� �̱� ���� ��. 
		boolean isOk = true;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					max = Math.max(dis[h][i][j], max);
					if (borad[h][i][j] == 0 && dis[h][i][j] == -1) {
						isOk = false;
						break;
					}
				}
				if (!isOk) break;
			}
		}
		
		if (!isOk) System.out.println("-1");
		else System.out.println(max);	
		
		
	}
}
