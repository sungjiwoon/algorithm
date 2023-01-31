import java.io.*;
import java.util.*;

class Truck {
	int wei;
	int dis;
	public Truck(int wei, int dis) {
		this.wei = wei; //트럭의 무게
		this.dis = dis; //트럭이 다리 위를 건넌 거리. 
	}
}
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Truck[] ts = new Truck[n];
		for (int i = 0; i < n; i++) {
			ts[i] = new Truck(0,0);
		}
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < n; i++) {
			ts[i].wei = Integer.parseInt(st.nextToken());
			ts[i].dis = 0;
		}
		
		int x = 0;
		int first = 0;
		int tail = first;
		int count = 0;

		while (ts[n-1].dis!=w && first < n) { //단위시간 반복문
			if (ts[tail].dis == 0) {
				x += ts[tail].wei;
				if (x > l) {
					x -= ts[tail].wei;
					tail--;
				}
			}
			for (int i = first; i <= tail; i++) {
				ts[i].dis++;
			}
			if (ts[first].dis == w) {
				x -= ts[first].wei;
				first++;
			}
			count++;
			tail++;
			if (tail == n) tail--;
			
		}

		System.out.println(count+1);
	}
	
}
