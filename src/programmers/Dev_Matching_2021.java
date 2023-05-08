package programmers;

import java.io.*;
import java.util.*;

public class Dev_Matching_2021 {
	public int[] solution(int rows, int columns, int[][] qu) {
        int[] answer = {};
        int[][] borad = new int[rows+1][columns+1];
        for (int i = 1; i <= rows; i++) {
        	for (int j = 1; j <= columns; j++) {
        		borad[i][j] = (i-1) * columns + j;
        	}
        }
        for (int i = 0; i<= rows; i++) {
        	for (int j = 0; j <= columns; j++) {
        		System.out.print(borad[i][j] + "\t");
        	}
        	System.out.println();
        }
        
        for (int c = 0; c < qu.length; c++) {
        	int x1 = qu[c][0];
        	int y1 = qu[c][1];
        	int x2 = qu[c][2];
        	int y2 = qu[c][3];
        	
        	int tmp = borad[x1][y1];
        	int x = x1, y = y1;
        	while (true) {
        		tmp = borad[x1][y1+1];
        		if (y+1 < y2) {
        			borad[x][y+1] = borad[x][y];
        		} else if (x+1 < x2) {
        			
        		} 
        	}
        	
        }
        
        
        return answer;
    }
	public void work() throws NumberFormatException, IOException {
		int[][] qu = { {2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
		System.out.println(Arrays.toString(solution(6,6,qu)));
		
	}
}
