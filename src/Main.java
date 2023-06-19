import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {	
	private static String before(String be, String s, String ans) {
		if (be.equals("")) return ans;
		
		if (s.equals("INT") || s.equals("LONG") ) {
			while (ans.length() % 8 != 0) {
				ans += ".";
			}
		} else {
			
			if (be.equals("BOOL")) {
				if (s.equals("BOOL")) return ans;
				
				if (s.equals("FLOAT")) {
					//4น่. 
					while (ans.length() % 4 != 0) {
						ans += ".";
					}
				} else if (s.equals("SHORT")) {
					if (ans.length() % 2 != 0) ans += ".";
					
				}
			}
			
		}
		return ans;
		
	}
	private static void solution(String[] arr) {
		String ans = "";
		String be = "";
		for (int i = 0; i < arr.length; i++) {
			
			String s = arr[i];
			ans = before(be,s,ans);
			if (s.equals("BOOL")) {
				ans += "#";
			} else if (s.equals("SHORT")) {
				ans += "##";
			} else if (s.equals("FLOAT")) {
				ans += "####";
			} else if (s.equals("INT")) {
				ans += "########";
			} else if (s.equals("LONG")) {
				ans += "################";
			}
			
			//if (s.length()%8 == 0) ans += "\n";
			be = s;
			
			if (ans.length() > 128) {
				ans = "HALT";
				break;
			}
			
		}
		
		while (ans.length() % 8 != 0) ans += ".";
		
		for (int i = 1; i <= ans.length(); i++) {			
			
			System.out.print(ans.charAt(i-1));
			if (i % 8 == 0) System.out.println();
			
		}
		
	}
	public static void main(String[] args) throws Exception {	
//		int[] arr = {3,2,4,4,2,5,2,5,5};
//		String[] arr = {"INT", "INT", "BOOL", "SHORT", "LONG"};
		String[] arr = {"BOOL", "SHORT", "FLOAT","SHORT"};
		
//		String[] arr = {"FLOAT", "SHORT", "BOOL", "BOOL", "BOOL", "INT"};
		
//		String[] arr = {"BOOL", "LONG", "SHORT", "LONG", "BOOL", "LONG", "BOOL", "LONG", "SHORT", "LONG", "LONG"};
		solution(arr);
	}
}
