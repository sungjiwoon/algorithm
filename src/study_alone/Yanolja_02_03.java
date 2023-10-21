package study_alone;

import java.util.*;

public class Yanolja_02_03 {
    ArrayList<Integer>[] levels;
    PriorityQueue<Integer> pq;
    class Node {
        int idx;
        ArrayList<Node> left, right;
        Node(int idx) {
            this.idx = idx;
            this.left = new ArrayList<>();
            this.right = new ArrayList<>();
        }

        void add(Node node) {
            if (node.idx < this.idx) {
                this.left.add(new Node(node.idx));
                this.right.add(new Node(this.idx));
            } else {
                this.right.add(new Node(node.idx));
                this.left.add(new Node(this.idx));
            }
        }
    }
    public int getLevel(int n) {
        int res = 1;
        int cnt = 0;
        while (res != n) {
            res *= 2;
            cnt++;
        }
        return cnt;
    }

    public int[] solve(int n, int[] winner) {
        int level = getLevel(n);

        pq = new PriorityQueue<>((o1, o2) -> {
            if (winner[o1] != winner[o2]) return winner[o2] - winner[o1];
            return o1 - o2;
        });

        boolean[] vis = new boolean[n+1];

        // winner의 승리횟수를 기준으로 레벨별로 값을 나눔.
        int rootIdx = pq.poll();

        //1. root값 (우승자)를 기준으로 노드를 만든다.
        Node root = new Node(rootIdx);
        vis[rootIdx] = true;
        Deque<Integer> dq = new LinkedList<>();

        while (!pq.isEmpty()) {
            int idx = pq.poll();
            if (dq.isEmpty()) {
                dq.addLast(idx);
                continue;
            }




        }




        //2. 다음 노드값 기준으로 루트 노드와 비교한다.
        int secondLevIdx = levels[level-1].get(0);
        Node secondLevNode = new Node(secondLevIdx);
        if (rootIdx < secondLevIdx) {
            root.left.add(root);
            root.right.add(secondLevNode);
        } else {
            root.left.add(secondLevNode);
            root.right.add(root);
        }






        return new int[]{0,0};
    }
    public static void main(String[] args) {
        Yanolja_02_03 y = new Yanolja_02_03();
        int[] ans = y.solve(8, new int[]{0,0,3,2,1,1,0,0});
        System.out.println(Arrays.toString(ans));
    }
}
