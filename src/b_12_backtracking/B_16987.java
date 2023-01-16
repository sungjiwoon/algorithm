package b_12_backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Egg {
	int dur;
	int weight;
	public Egg(int dur, int weight) {
		super();
		this.dur = dur;
		this.weight = weight;
	}
	
}
public class B_16987 {
	static int n;
	static Egg[] eggs;
	static int mx;
	private void func(int st, Egg[] eggs, int cnt) {
		
		if (st == n) {
			mx = Math.max(cnt, mx);			
			return;
		}
		if (eggs[st].dur <= 0 || cnt == n-1) {
			func(st+1, eggs, cnt);
			return;
		}
		
		for (int j = 0; j < n; j++) {
			if (st == j || eggs[j].dur <= 0) continue;
				
			hitEggs(eggs, st, j);
			if (eggs[st].dur <= 0) cnt++;
			if (eggs[j].dur <= 0) cnt++;
			
			func(st+1, eggs, cnt);
			
			if (eggs[st].dur <= 0) cnt--;
			if (eggs[j].dur <= 0) cnt--;
			recoverEggs(eggs, st, j);			
		
		}
	
	}

	private void hitEggs(Egg[] eggs, int i, int j) {
		eggs[i].dur -= eggs[j].weight;
		eggs[j].dur -= eggs[i].weight;
	}
	
	private void recoverEggs(Egg[] eggs, int i, int j) {
		eggs[i].dur += eggs[j].weight;
		eggs[j].dur += eggs[i].weight;
	}
	
	public void work() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		eggs = new Egg[n];
		
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int dur=Integer.parseInt(st.nextToken());
			int weight=Integer.parseInt(st.nextToken());
			eggs[i] = new Egg(dur, weight);
		}
	
		func(0, eggs, 0);
		
		System.out.print(mx);
	}
}
