package b_21_binary_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
/*
 * treemap 연습 .
 * 문제
tony9402는 최근 깃헙에 코딩테스트 대비 문제를 직접 뽑아서 "문제 번호, 난이도"로 정리해놨다.

깃헙을 이용하여 공부하시는 분들을 위해 새로운 기능을 추가해보려고 한다.

만들려고 하는 명령어는 총 3가지가 있다. 아래 표는 각 명령어에 대한 설명이다.

recommend 
$x$ 	
 
$x$가 1인 경우 추천 문제 리스트에서 가장 어려운 문제의 번호를 출력한다.

만약 가장 어려운 문제가 여러 개라면 문제 번호가 큰 것으로 출력한다.

 
$x$가 -1인 경우 추천 문제 리스트에서 가장 쉬운 문제의 번호를 출력한다.

만약 가장 쉬운 문제가 여러 개라면 문제 번호가 작은 것으로 출력한다.

add 
$P$ 
$L$ 	추천 문제 리스트에 난이도가 
$L$인 문제 번호 
$P$를 추가한다. (추천 문제 리스트에 없는 문제 번호 
$P$만 입력으로 주어진다. 이전에 추천 문제 리스트에 있던 문제 번호가 다른 난이도로 다시 들어 올 수 있다.)
solved 
$P$ 	추천 문제 리스트에서 문제 번호 
$P$를 제거한다. (추천 문제 리스트에 있는 문제 번호 
$P$만 입력으로 주어진다.)
명령어 recommend는 추천 문제 리스트에 문제가 하나 이상 있을 때만 주어진다.

명령어 solved는 추천 문제 리스트에 문제 번호가 하나 이상 있을 때만 주어진다.

위 명령어들을 수행하는 추천 시스템을 만들어보자. 
 */
public class B_21939 {
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TreeMap<Integer, TreeSet<Integer>> tmap = new TreeMap<>();
		TreeMap<Integer, Integer> solve = new TreeMap<>(); //문제 담는 곳.
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			if (tmap.containsKey(l)) {
				TreeSet<Integer> ts = tmap.get(l);
				ts.add(p);
				tmap.put(l, ts);
			} else {
				TreeSet<Integer> ts = new TreeSet<>();
				ts.add(p);	
				tmap.put(l, ts);
			}
			solve.put(p,l);
		}
		
		int m = Integer.parseInt(br.readLine());
		for (int i = 0;i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			if (s.equals("add")) {
				
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				
				if (tmap.containsKey(l)) {
					TreeSet<Integer> ts = tmap.get(l);
					ts.add(p);
					tmap.put(l, ts);
				} else {
					TreeSet<Integer> ts = new TreeSet<>();
					ts.add(p);	
					tmap.put(l, ts);
				}
				solve.put(p,l);
				
			} else if (s.equals("recommend")) {
				int k = Integer.parseInt(st.nextToken());
				int p = 0;
				if (k == 1) {					
					int last = tmap.lastKey();
					TreeSet ts = tmap.get(last);
					p = (int) ts.last();
					
				} else {
					int first = tmap.firstKey();
					TreeSet ts = tmap.get(first);
					p = (int) ts.first();
				}
				sb.append(p+"\n");
				
			} else if (s.equals("solved")) {
				int p = Integer.parseInt(st.nextToken());
				int l = solve.get(p);
				TreeSet ts = tmap.get(l);
				ts.remove(p);
				if (!ts.isEmpty()) 
					tmap.put(l, ts);
				else
					tmap.remove(l);
				solve.remove(p);				
			}

		}
		System.out.println(sb);
		
	}
}
