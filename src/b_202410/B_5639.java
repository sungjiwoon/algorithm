package b_202410;

import java.io.*;
import java.util.*;

/** 241012 이진검색트리 (골4)
 * 재귀
 */

public class B_5639 {

    // 2의 10000승까지 가야하므로, 배열 사용하면 안됨.

    class Node {
        int value;
        Node left, right;
        Node(int value) {
            this.value = value;
        }
    }

    void insert(int value, Node node) {
        if (value < node.value) {
            if (node.left != null) {
                insert(value, node.left);
            } else {
                Node newNode = new Node(value);
                node.left = newNode;
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(value, node.right);
            } else {
                Node newNode = new Node(value);
                node.right = newNode;
            }
        }
    }

    List<Integer> list = new ArrayList<>();

//    public void search(int value, int idx) {
//        if (arr[idx] == 0) {
//            arr[idx] = value;
//            return;
//        }
//
//        if (arr[idx] < value) {
//            search(value, idx * 2 + 1);
//        } else if (arr[idx] > value) {
//            search(value, idx * 2);
//        }
//    }

    public void post(Node node) {
        // 왼 > 오 > 출력
        if (node.left != null) post(node.left);
        if (node.right != null) post(node.right);
        System.out.println(node.value);
    }

    public void solve() {
        Node node = new Node(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            insert(list.get(i), node);
        }

        post(node);
    }

    public static void main(String[] args) throws Exception {
        B_5639 b = new B_5639();
        b.init();
        b.solve();
    }

    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st;
        while (true) {
            st = br.readLine();
            if (st == null || st.equals("")) break;
            list.add(Integer.parseInt(st));
        }

    }
}
