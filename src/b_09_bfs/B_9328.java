package b_09_bfs;

import java.io.*;
import java.util.*;

/*
 * 열쇠
 * bfs 조건 까다로왔다... 4시간 걸렸다... 하 .. 
 * door 큐 넣는 거 연습할 것. 
 */
public class B_9328 {
	static char[][] map;
	static HashMap<Character, Integer> key;
	static StringBuilder sb = new StringBuilder();
	static Queue<Pair> qu;
	static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};

	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		while (TC-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			qu = new LinkedList<>();
			for (int i = 0; i < h; i++) {
				String s = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = s.charAt(j);					
				}
			}
			
			key = new HashMap<>();
			String keys = br.readLine();
			int chi = 0;
			while ('A'+chi <= 'Z') {
				key.put((char) ('A'+chi), 0);
				chi++;
			}
			if (!keys.equals("0")) {
				for (int i = 0; i < keys.length(); i++) {
					char ch = (char)Character.toUpperCase(keys.charAt(i)); //소문자 -> 대문자. 
					key.put(ch, key.get(ch)+1);
				}
			}
			
			//모든 가장자리를 다 돌아보면서, qu에 넣어줘야함. 
			int res = 0; //줍는 갯수. 
			Queue<Pair>[] door = new LinkedList[26]; //대문자만 담음. 
			for (int i = 0; i < 26; i++) {
				door[i] = new LinkedList<>();
			}
			
			for (int i = 1; i < h-1; i++) {
				if (map[i][0] != '*') qu.add(new Pair(i,0));
				if (map[i][w-1] != '*') qu.add(new Pair(i,w-1));
			}
			
			for (int j = 0; j < w; j++) {
				if (map[0][j] != '*') qu.add(new Pair(0,j));
				if (map[h-1][j] != '*') qu.add(new Pair(h-1,j));
			}	
			
			boolean[][] vis = new boolean[h][w];
			while (!qu.isEmpty()) {
				Pair p = qu.poll();
				//sb.append(p.X + ", " + p.Y + " 입장\n");
				char pc = map[p.X][p.Y];
				if ( pc >= 'A' && pc <= 'Z' && key.get(pc) == 0) {
					door[pc-'A'].add(p);
					continue;
				} else if (pc >= 'a' && pc <= 'z') {
					char Pc = Character.toUpperCase(pc);
					key.put(Pc, key.get(Pc)+1);
					
					while (!door[Pc-'A'].isEmpty()) qu.add(door[Pc-'A'].poll());
				} else if (pc == '$') {
					map[p.X][p.Y] = '.';
					res++;
				}
				vis[p.X][p.Y] = true;
				
				for (int k = 0; k < 4; k++) {
					int xx = p.X + dx[k];
					int yy = p.Y + dy[k];
					
					if (xx < 0 || xx >= h || yy < 0 || yy >= w) continue;
						
					char nxt = map[xx][yy];
					if (nxt == '*'||vis[xx][yy]) continue;
					
					//문을 만났음. 
					if (nxt >= 'A' && nxt <= 'Z' && key.get(nxt) == 0) {
						//sb.append("(" + xx + " , " +yy + ") " + nxt + " : 새로운 문 !!\n");
						door[nxt-'A'].add(new Pair(xx,yy));
						continue;
					}

					//열쇠 주움. 
					if (nxt >= 'a' && nxt <= 'z') {
						char ch = (char)Character.toUpperCase(nxt); //소문자 -> 대문자. 
						key.put(ch, key.get(ch)+1);
						//sb.append("(" + xx + " , " +yy + ") " + nxt + " : 열쇠 발견 !!\n");
						while (!door[ch-'A'].isEmpty()) {
							qu.add(door[nxt-'a'].poll());
						}
						
					} else if (nxt == '$') { //문서일경우. 
						//sb.append("(" + xx + " , " +yy + ") " + nxt + " : 문서 발견 !!\n");
						map[xx][yy] = '.';
						res++;
					}
					
					vis[xx][yy] = true;
					qu.add(new Pair(xx,yy));
					
				}
			}
			
			
			sb.append(res+"\n");
			
		}
		System.out.println(sb);
	}
}









