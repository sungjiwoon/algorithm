package b_13_simulation;

import java.io.*;
import java.util.*;

/*
 * 직사각형
 * 포기^^!
 */
class Square {
	int x1, y1, x2, y2;
	Square(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}

public class B_2527 {
	
	private static char func(Square s1, Square s2) {
		
		/*
		 * 직사각형	a
			선분	b
			점	c
			공통부분이 없음	d
		 */
		
		
		//포함인 경우 a		
//		if (s1.x1 <= s2.x1 && s2.x2 <= s1.x2 && s1.y1 <= s2.y1 && s2.y2 <= s1.y2) return 'a';
//		if (s2.x1 <= s1.x1 && s1.x2 <= s2.x2 && s2.y1 <= s1.y1 && s1.y2 <= s2.y2) return 'a';
		
		if (s1.x1 <= s2.x1 && s2.x1 <= s1.x2) {
			System.out.println("case 1 :" );
			
			if (s1.y2 < s2.y1) return 'd';
			if (s2.y2 < s1.y1) return 'd';
			
			if (s1.y2 == s2.y1) return 'b';
			if (s1.y1 == s2.y2) return 'b';
			
			return 'a';
		}
		
		//점인 경우 c
		if (s1.x2 == s2.x1 && s1.y1 == s2.y1) return 'c';
		if (s1.x2 == s2.x1 && s1.y2 == s2.y1) return 'c';
		if (s1.x1 == s2.x2 && s1.y2 == s2.y1) return 'c';
		if (s1.x1 == s2.x2 && s1.y1 == s2.y2) return 'c';
		
		if (s2.x1 < s1.x1 && s1.x1 < s2.x2) {
			System.out.println("case 2 :" );
			if (s1.y2 < s2.y1) return 'd';
			if (s2.y2 < s1.y1) return 'd';
			
			if (s1.y2 == s2.y1) return 'b';
			if (s1.y1 == s2.y2) return 'b';
			return 'a';
		}
		
		if (s1.y1 < s2.y1 && s2.y1 < s1.y2) {
			System.out.println("case 3 :" );
			if (s1.x2 < s2.x1) return 'd';
			if (s2.x2 < s1.x1) return 'd';
			
			if (s1.x2 == s2.x1) return 'b';
			if (s1.x1 == s2.x2) return 'b';
			return 'a';
		}
		
		if (s2.y1 < s1.y1 && s1.y1 < s2.y2) {
			System.out.println("case 4 :" );
			if (s1.x2 < s2.x1) return 'd';
			if (s2.x2 < s1.x1) return 'd';
			
			if (s1.x2 == s2.x1) return 'b';
			if (s1.x1 == s2.x2) return 'b';
			return 'a';
		}
		
		
		//선분인 경우 b
//		if (s1.y1 == s2.y2 && s1.x1 < s2.x1 && s2.x1 < s1.x2) return 'b';
//		if (s1.y1 == s2.y2 && s2.x1 < s1.x1 && s1.x2 < s2.x2) return 'b';
//		
//		if (s1.y2 == s2.y1 && s1.x1 < s2.x1 && s2.x1 < s1.x2) return 'b';
//		if (s1.y2 == s2.y1 && s2.x1 < s1.x1 && s1.x2 < s2.x2) return 'b';
//		
//		if (s1.x2 == s2.x1 && s1.y1 < s2.y1 && s2.y1 < s1.y2) return 'b';
//		if (s1.x2 == s2.x1 && s2.y1 < s1.y1 && s1.y1 < s2.y2) return 'b';
//		
//		if (s1.x1 == s2.x2 && s1.y1 < s2.y1 && s2.y1 < s1.y2) return 'b';
//		if (s1.x1 == s2.x2 && s2.y1 < s1.y1 && s1.y1 < s2.y2) return 'b';
		
		
		

		return 'd';
	}
	public void work() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Square s1 = null, s2 = null;
			for (int j = 0; j < 2; j++) {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				
				if (j == 0) s1 = new Square(x1,y1,x2,y2);
				else s2 = new Square(x1,y1,x2,y2);
			}
			
			System.out.println(func(s1,s2));
		}
		
		
		
	}
}











