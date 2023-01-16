import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;




class Pair {
	int X, Y;
	Pair(int x, int y) {
		super();
		X = x;
		Y = y;
	}
}

public class Main {
	static int n;
	static int cnt = 0;
	static int[] res;
	static boolean[] vis;
	static int[] dx = {1,1,1}, dy= {-1,0,1};
	private static void func(int idx) {
		if (idx == n) {
			if (bfs())	{
				cnt++;
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			res[idx] = idx*n+i;
			func(idx+1);
		}
	}
	private static boolean bfs() {
		Queue<Pair> qu = new LinkedList<>();
		int x = res[0]/n;
		int y = res[0]%n;
		int i = 1;
		qu.offer(new Pair(x, y));
		while (!qu.isEmpty()) {
			Pair p = qu.poll();
			for (int j = 1; j < n-p.X; j++) {
				
				int xx = p.X + j;
				
				for (int k = 0; k < 3; k++) {
					
					int yy = p.Y + dy[k] * j;
					if (yy >= n || yy < 0 ) continue;
					
					if (yy == res[p.X+j] % n) {
						return false;
					}				
					
				}
			}
			qu.offer(new Pair(res[i]/n, res[i]%n));
			i++;
			if (i == n) break;
		}
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		res = new int[n];
		vis = new boolean[n*n];
		func(0);
		System.out.println(cnt);		
		
	}
}
