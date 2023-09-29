package study_alone;
import java.util.*;

/*
쿼드 압축 후 개수 세기
프로그래머스 : https://school.programmers.co.kr/learn/courses/30/lessons/68936
기본 dfs
 */
public class P_68936 {
    int[] answer = new int[2];
    public void dfs(int n, int[][] arr, int r, int c) {
        if (n == 1) {
            answer[arr[r][c]]++;
            return;
        }

        int tmp = arr[r][c];
        boolean ok = true;
        for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if (arr[i][j] != tmp) {
                    ok = false;
                    break;
                }
            }
            if(!ok) break;
        }
        if (!ok) {
            dfs(n/2, arr, r, c);
            dfs(n/2, arr, r+n/2,c);
            dfs(n/2, arr, r, c+n/2);
            dfs(n/2, arr, r+n/2, c+n/2);
        } else {
            answer[tmp]++;
            return;
        }


    }
    public int[] solution(int[][] arr) {
        int len = arr.length; //변의 길이.
        dfs(len, arr, 0, 0);
        return answer;
    }
}
