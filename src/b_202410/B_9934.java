package b_202410;

import java.io.*;
import java.util.*;

/** 241013 완전이진트리 (실버1) */

public class B_9934 {

    int k, max;
    int[] nodes = new int[20];
    int[] list;
    int idx2 = 1;

    public void fill(int idx) {
        if (idx >= max) return;

        fill(idx * 2);
        nodes[idx] = list[idx2++];
        //System.out.println(list[idx2++]);
        fill(idx * 2 + 1);
    }

    public void print() {
        int idx = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < Math.pow(2, i); j++) {
                System.out.print(nodes[idx++] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        B_9934 b = new B_9934();
        b.init();
        b.fill(1);
        b.print();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        max = (int) Math.pow(2, k);
        list = new int[max];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int i = 1;
        while (st.hasMoreTokens()) {
            list[i++] = Integer.parseInt(st.nextToken());
        }

    }
}
