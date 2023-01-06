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
	public static void hanoi(int N, int start, int mid, int end) {
		if (N == 1) {
			System.out.println(start + " " + end);
			return;
		}
		
		// 1) ���� n-1 ���� �̵� �߰��� �̵��ؾ���. 
		hanoi(N-1, start, end, mid);
		// 2) ���� 1���� start -> end�������� �̵�.
		System.out.println(start + " " + end);
		//3) ���� N-1���� mid -> end �������� �̵�. 
		hanoi(N-1, mid ,start, end);
		
	
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = (int) (Math.pow(2, N)-1);
		System.out.println(count);
		hanoi(N, 1, 2, 3);
	}
}
