package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/*
 * 문제
	총 25명의 여학생들로 이루어진 여학생반은 5×5의 정사각형 격자 형태로 자리가 배치되었고, 얼마 지나지 않아 이다솜과 임도연이라는 두 학생이 두각을 나타내며 다른 학생들을 휘어잡기 시작했다. 곧 모든 여학생이 ‘이다솜파’와 ‘임도연파’의 두 파로 갈라지게 되었으며, 얼마 지나지 않아 ‘임도연파’가 세력을 확장시키며 ‘이다솜파’를 위협하기 시작했다.
	
	위기의식을 느낀 ‘이다솜파’의 학생들은 과감히 현재의 체제를 포기하고, ‘소문난 칠공주’를 결성하는 것이 유일한 생존 수단임을 깨달았다. ‘소문난 칠공주’는 다음과 같은 규칙을 만족해야 한다.
	
	이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
	강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
	화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
	그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
	여학생반의 자리 배치도가 주어졌을 때, ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 구하는 프로그램을 작성하시오.
	
	입력
	'S'(이다‘솜’파의 학생을 나타냄) 또는 'Y'(임도‘연’파의 학생을 나타냄)을 값으로 갖는 5*5 행렬이 공백 없이 첫째 줄부터 다섯 줄에 걸쳐 주어진다.
	
	출력
	첫째 줄에 ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 출력한다.
	
	예제 입력 1 
	YYYYY
	SYSYS
	YYYYY
	YSYYS
	YYYYY
	예제 출력 1 
	2
	힌트
	가능한 방법은 아래와 같다.
	
	.....    .....
	SYSYS    SYSYS
	....Y    .Y...
	....S    .S...
	.....    .....
 */
public class B_1941 {
	static char[][] map = new char[5][5];
	static int[] index_map = new int[25];
	static int[] result;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
	static boolean[] vis = new boolean[25];
	static int count = 0;
	
	private static boolean is_s_ok(int[] result) {
		int res = 0;
		for (int i = 0; i < 7; i++) {
			if (map[result[i]/5][result[i]%5] == 'S') res++;
		}
		if (res>=4) return true;
		return false;
	}
	
	private static void bfs(int[] result) {
		Queue<Pair> qu = new LinkedList<>();
		boolean[] vis2 = new boolean[7];
		int cnt = 1;
		qu.offer(new Pair(result[0]/5, result[0]%5));
		vis2[0] = true;
		
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			
			for (int k = 0; k < 4; k++) {
				int xx = p.X + dx[k];
				int yy = p.Y + dy[k];
				if (xx>=5||xx<0||yy>=5||yy<0) continue;
				
				for (int l = 1; l < 7; l++) {
					if (xx == result[l]/5 && yy == result[l]%5 && !vis2[l]) {
						qu.offer(new Pair(result[l]/5, result[l]%5));
						vis2[l]= true;
						cnt++;
						break;
					}
				}
			}
		}
		if (cnt == 7) {
//			for (int j = 0; j < 7; j++) {
//				System.out.print(result[j]+" ");
//			}
//			System.out.println();
			count++;
		}
	}
	
	private static void func(int idx, int st, int[] result) {
		
		if (idx == 7) {	
			
			if (is_s_ok(result)) {
//				for (int j = 0; j < 7; j++) {
//					System.out.print(result[j]+" ");
//				}
//				System.out.println();
				bfs(result);				
			}
			return;
		}
		
		for (int i = st; i < 25; i++) {
			if (!vis[i]) {
				vis[i] = true;
				result[idx] = i;
				func(idx+1, i, result);
				vis[i] = false;
			}
		}
		
	}
	
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 5; j++) 
				map[i][j] = s.charAt(j);
		}
		int n = 1;
		for (int i = 1; i < 25; i++) {
			index_map[i] = i;
		}
		result = new int[7];
		func(0,0, result);
		System.out.println(count);
	}
}
