package b_12_backtracking;

import java.io.*;
import java.util.*;
/*
 * 문제 명 : 암호만들기 
 * 난이도 : 골드 5(그정도 안되는듯???)
 * 후기 : 쉬웠음! 문자열도 sort 함수 된다. 
 * 문제
	바로 어제 최백준 조교가 방 열쇠를 주머니에 넣은 채 깜빡하고 서울로 가 버리는 황당한 상황에 직면한 조교들은, 702호에 새로운 보안 시스템을 설치하기로 하였다. 이 보안 시스템은 열쇠가 아닌 암호로 동작하게 되어 있는 시스템이다.
	
	암호는 서로 다른 L개의 알파벳 소문자들로 구성되며 최소 한 개의 모음(a, e, i, o, u)과 최소 두 개의 자음으로 구성되어 있다고 알려져 있다. 또한 정렬된 문자열을 선호하는 조교들의 성향으로 미루어 보아 암호를 이루는 알파벳이 암호에서 증가하는 순서로 배열되었을 것이라고 추측된다. 즉, abc는 가능성이 있는 암호이지만 bac는 그렇지 않다.
	
	새 보안 시스템에서 조교들이 암호로 사용했을 법한 문자의 종류는 C가지가 있다고 한다. 이 알파벳을 입수한 민식, 영식 형제는 조교들의 방에 침투하기 위해 암호를 추측해 보려고 한다. C개의 문자들이 모두 주어졌을 때, 가능성 있는 암호들을 모두 구하는 프로그램을 작성하시오.
	
	입력
	첫째 줄에 두 정수 L, C가 주어진다. (3 ≤ L ≤ C ≤ 15) 다음 줄에는 C개의 문자들이 공백으로 구분되어 주어진다. 주어지는 문자들은 알파벳 소문자이며, 중복되는 것은 없다.
	
	출력
	각 줄에 하나씩, 사전식으로 가능성 있는 암호를 모두 출력한다.
	
	예제 입력 1 
	4 6
	a t c i s w
	예제 출력 1 
	acis
	acit
	aciw
	acst
	acsw
	actw
	aist
	aisw
	aitw
	astw
	cist
	cisw
	citw
	istw
 */
public class B_1759 {
	static int l, c;
	static char[] map;
	static StringBuilder sb = new StringBuilder();
	private static void func(int st, String res) {
		if (res.length() == l) {
			int mos = 0;			
			if (res.contains("a")) mos++;
			if (res.contains("e")) mos++;
			if (res.contains("o")) mos++;
			if (res.contains("i")) mos++;
			if (res.contains("u")) mos++;
			if (mos >= 1 && l- mos >= 2) sb.append(res).append("\n");
			
			
			return;
		}
		
		for (int i = st; i < c; i++) {
			String tmp = res;
			res += map[i];
			func(i+1, res);
			res = tmp;
		}
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[c];
		String s = br.readLine();
		for (int i = 0; i < c; i++)
			map[i] = s.charAt(i*2);
		Arrays.sort(map);
		
		func(0,"");
		System.out.println(sb);
	}
}
