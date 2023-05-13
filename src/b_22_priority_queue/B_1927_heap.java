package b_22_priority_queue;
import java.io.*;
import java.util.*;

public class B_1927_heap {
	static int[] heap = new int[100005];
	static int sz = 0;
	private static void push(int x) { //삽입. 
		heap[++sz] = x;
		int idx = sz;
		while (idx != 1) {
			int par = idx/2;
			if (heap[par] <= heap[idx]) break;
			swap(par, idx);
			idx = par;
		}
	}
	private static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	private static int top() {
		if (sz == 0) return 0;
		return heap[1]; //루트 반환. 
	}
	private static void pop() {
		if (sz == 0) return;
		heap[1] = heap[sz--];
		int idx = 1;
		while (2*idx <= sz) {
			int lc = 2*idx, rc = 2*idx+1; //왼쪽 자식, 오른쪽 자식
			int min_child = lc; //왼쪽 자식을 넣는다. 
			if(rc <= sz && heap[rc] < heap[lc]) { //만약 오른쪽 자식이 더 작으면 오른쪽 자식을 넣는다. 
				min_child = rc;
			} 
			if (heap[idx] <= heap[min_child]) break;
			swap(idx, min_child);
			idx = min_child; 
		}
	}
	public void work() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				sb.append(top()).append("\n");
				pop();
			} else {
				push(x);
			}
		}
		System.out.println(sb);
	}
}
