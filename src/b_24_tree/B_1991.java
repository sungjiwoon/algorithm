package b_24_tree;

import java.io.*;
import java.util.*;

/*
 * 문제 : 트리순회 실버1
 * 이진 트리를 입력받아 
 * 전위 순회(preorder traversal), 
 * 중위 순회(inorder traversal), 
 * 후위 순회(postorder traversal)한 
 * 결과를 출력하는 프로그램을 작성하시오.
 * 
 */
public class B_1991 {
	static Character[] tree;
	private static void dfs(int p, char key, HashMap<Character, Character[]> hs) {
		
		tree[p] = key; 
		
		Character[] list = hs.get(key);
		if (list[0] != '.') dfs(p*2, list[0], hs);
		if (list[1] != '.') dfs(p*2+1, list[1], hs);
		
	}
	private static void preorder(int p) { //전위
		//왼자->부모->오자
		if (tree[p] == '.') return;
		
		System.out.print(tree[p]);
		preorder(p*2);		
		preorder(p*2+1);
	}
	private static void inorder(int p) { //중위
		
		//부모->왼자->오자
		
		if (tree[p] == '.') return;
		
		inorder(p*2);
		System.out.print(tree[p]);
		inorder(p*2+1);
		
		
	}
	private static void postorder(int p) { //후위
		//왼자->오자->부모
		
		if (tree[p] == '.') return;
		
		postorder(p*2);
		postorder(p*2+1);
		System.out.print(tree[p]);
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		
		HashMap<Character, Character[]> hs = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char key = st.nextToken().charAt(0);
			Character[] tmp = {st.nextToken().charAt(0), st.nextToken().charAt(0)};
			hs.put(key, tmp);
		}
		
		tree = new Character[1000];
		Arrays.fill(tree, '.');
		dfs(1, 'A', hs);	
		
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
		
	}
}
