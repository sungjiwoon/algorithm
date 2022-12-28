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


class Pair {
	int X, Y;
	public Pair(int x, int y) {
		super();
		X = x;
		Y = y;
	}
}
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28};
		//char[][] map_result = new char[n][n];
		String[] answer = new String[n];
	        
	        for (int i = 0; i < n; i++) {
	        	String s1 = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
	        	String s2 = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));
	        	
	        	String s = "";
	        	for (int j = 0; j < n; j++) {
	        		if (s1.charAt(j)=='1' || s2.charAt(j)=='1') {
	        			s += "#";
	        		}else {
	        			s += " ";
	        		}
	        	}
	        	answer[i] = s;
	        	
	        }
	        for (int i = 0; i <n;i++) {
	        	System.out.println(answer[i]);
//	        	System.out.println();
	        }
	}
}
