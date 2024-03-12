package hell_study;

import java.io.*;
import java.util.*;
/** 240312 백준 1325 효율적인 해킹 DFS */
public class B_1325 {
    static int N, M;
    static ArrayList <Integer>[] arr;
    static boolean isVisited[];
    static int max;
    static int cntArr[];

    static void DFS(int start) {
        isVisited[start] = true;
        for (int i : arr[start]) {
            if (isVisited[i]) continue;
            cntArr[i]++; // i가 해킹할 수 있는 숫자 증가
            DFS(i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1];
        cntArr = new int[N+1];

        // 신뢰 관계 입력
        arr = new ArrayList[N+1];
        for (int i=0; i<N+1; i++) arr[i] = new ArrayList <Integer>();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b); // a가 b를 신뢰, a는 b에게 해킹 당할 수 있음
        }

        // 1번부터 N번까지 search
        for (int i=1; i<N+1; i++) {
            isVisited = new boolean[N+1];
            DFS(i); // 메모리↓ 시간↑

        }

        // 해킹할 수 있는 최댓값 찾기
        for (int i=1; i<N+1; i++) {
            if (max<cntArr[i]) max = cntArr[i];
        }

        // 최댓값인 컴퓨터 출력
        for (int i=1; i<N+1; i++) if (max == cntArr[i]) System.out.print(i+" ");

    }

}
