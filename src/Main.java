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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();		
		Stack<String> stack = new Stack<>();
		int sum = 0;
		boolean ispop = false;
		for (int i = 0; i < s.length(); i++) {
			
			String value = String.valueOf(s.charAt(i));
			
			if (value.equals("(")) {
				stack.push("(");
				ispop = false;
			
			} else if (value.equals(")")) {
				stack.pop();
				
				if (!ispop) {	
					sum += stack.size();
				} else {
					sum++;
				}
				ispop = true;
									
			}			
			
		}
		System.out.println(sum);
	}
}
