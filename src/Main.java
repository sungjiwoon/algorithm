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
	static long mod(long a, long b, long c) {
//		long mod = a % c;
		if (b == 1) return a % c;
		long val = mod(a, b/2, c);
		val = val * val % c;
		if (b % 2 == 0) return val;
		return val * a % c;
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		System.out.println(mod(a,b,c));
	}
}
