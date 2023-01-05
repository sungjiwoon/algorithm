package b_11_square;

import java.util.Scanner;

public class B_1629 {
	long mod(long a, long b, long c) {
//		long mod = a % c;
		int val = 1;
		while (b > 0) {
			if (b % 2 == 1) {
				val *= (a%c);
				val %= c;
			}
			a = ( (a%c) * (a%c)) % c;
			b /=2;
		}
		return a%c;
	}
	
	public void work() {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextInt();
		long b = sc.nextInt();
		long c = sc.nextInt();
		System.out.println(mod(a,b,c));
	}
}
