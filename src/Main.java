import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static int head, tail;
	static int[] deque;
	static int front() {
		if (isEmpty()== 1) return -1;
		return deque[head];
	}
	static int back() {
		if (isEmpty()== 1) return -1;
		return deque[tail-1];
	}
	static void push_front(int X) {
		deque[--head] = X;
	}
	static void push_back(int X) {
		deque[tail++] = X;
	}
	static int pop_front() {
		if (isEmpty() == 1) return -1;
		return deque[head++];
	}
	static int pop_back() {
		if (isEmpty() == 1) return -1;
		int n = deque[tail-1];
		tail--;
		return n;
	}
	static int size() {
		return tail-head;
	}
	static int isEmpty() {
		if (size() == 0) return 1;
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		deque = new int[N*2+1]; //앞 뒤에서 추출해야하므로, 2배+1
		head = N/2;
		tail = N/2;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n;
			switch (st.nextToken()) {
			
			case "push_back" :
				push_back(Integer.parseInt(st.nextToken()));
				break;
				
			case "push_front" :
				push_front(Integer.parseInt(st.nextToken()));
				break;
			
			case "pop_front" :
				n = pop_front();
				sb.append(n + "\n");
				break;
			
			case "pop_back" :
				n = pop_back();
				sb.append(n + "\n");
				break;
				
			case "front" :
				n = front();
				sb.append(n + "\n");
				break;
			
			case "back" :
				n = back();
				sb.append(n + "\n");
				break;
			
			case "empty" :
				n = isEmpty();
				sb.append(n + "\n");
				break;
				
			case "size" :
				n = size();
				sb.append(n + "\n");
				break;
		
			}
						
		}
		System.out.println(sb);
	}
}
