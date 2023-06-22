package b_09_bfs;

import java.io.*;
import java.util.*;

/*
 * ����
 * bfs ���� ��ٷοԴ�... 4�ð� �ɷȴ�... �� .. 
 * door ť �ִ� �� ������ ��. 
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
					char ch = (char)Character.toUpperCase(keys.charAt(i)); //�ҹ��� -> �빮��. 
					key.put(ch, key.get(ch)+1);
				}
			}
			
			//��� �����ڸ��� �� ���ƺ��鼭, qu�� �־������. 
			int res = 0; //�ݴ� ����. 
			Queue<Pair>[] door = new LinkedList[26]; //�빮�ڸ� ����. 
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
				//sb.append(p.X + ", " + p.Y + " ����\n");
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
					
					//���� ������. 
					if (nxt >= 'A' && nxt <= 'Z' && key.get(nxt) == 0) {
						//sb.append("(" + xx + " , " +yy + ") " + nxt + " : ���ο� �� !!\n");
						door[nxt-'A'].add(new Pair(xx,yy));
						continue;
					}

					//���� �ֿ�. 
					if (nxt >= 'a' && nxt <= 'z') {
						char ch = (char)Character.toUpperCase(nxt); //�ҹ��� -> �빮��. 
						key.put(ch, key.get(ch)+1);
						//sb.append("(" + xx + " , " +yy + ") " + nxt + " : ���� �߰� !!\n");
						while (!door[ch-'A'].isEmpty()) {
							qu.add(door[nxt-'a'].poll());
						}
						
					} else if (nxt == '$') { //�����ϰ��. 
						//sb.append("(" + xx + " , " +yy + ") " + nxt + " : ���� �߰� !!\n");
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









