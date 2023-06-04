package b_24_tree_unionfind;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
 * 유니온 파인드를 이용한 풀이를 진행해야함. 
 * 
 * 민서의 응급수술 
 * 난이도 : 골4
 * 
 */
public class B_20955 {
	static int n;
	static int res =0;
	
	/*유니온 파인드 */
	static int[] parent;
	private static int find(int x) {
		if (parent[x] == x || parent[x] == 0) //배열의 인덱스와 값이 같다면 해당 값 리턴. or 부모를 아직 모를 경우. 
			return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void merge(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) return; //이미 연결되어 있다는 뜻. 
		parent[y] = x;
	}
	
	private static boolean isUnion(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y) return true;
		return false;
	}
	
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n+1];
		
		/*
		유니온 파인드를 활용한 별해입니다.

		간선을 입력 받으면서 merge를 시도합니다.
		두 정점의 부모가 동일하지 않다면 merge를 수행합니다.
		두 정점의 부모가 동일한 경우
		해당 간선은 불필요한 간선이므로
		자르는 연산 횟수인 cnt를 증가시킵니다.

		이 연산을 완료한 뒤에 남은 간선 수는 총 (m - cnt)개가 됩니다.
		여기서 간선을 연결해 (n - 1)개의 간선을 확보해야 트리가 구성됩니다.
		따라서 연결해야 하는 간선 수는 (n - 1) - (m - cnt)개가 됩니다.

		그러므로 간선을 잇고 자르는 총 연산 수는
		(n - 1) - (m - cnt) + cnt = n - m - 1 + 2*cnt이며,
		이를 답으로 출력합니다.
		*/
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (!isUnion(a,b)) merge(a,b); //병합 시도.
			else {
				res++; //불필요한 간선. 
			}
		}
		//System.out.println(Arrays.toString(parent));
		
		//남은 간선의 수 m-res
		res+= (n-1) - (m-res);
		System.out.println(res);
		
		
	}
}
