package b_202502;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
// 색깔 트리 연습 (외우자 걍)
public class Samsung_24FirstPm02_prac {
    int Q;

    final int COLOR_MAX = 5;
    final int MAX_ID = 1000005;

    Node[] nodes = new Node[MAX_ID];
    boolean[] isRoot = new boolean[MAX_ID];

    {
        System.out.println("NODE MAKE");
        for (int i = 0; i < MAX_ID; i++) {
            nodes[i] = new Node();
        }
    }

    static {
        System.out.println("static START");
    }


    class Node {
        int mid, pid, color, maxDepth, lastUpdate;
        public Node (int mid, int pid, int color, int maxDepth, int lastUpdate) {
            this.mid = mid;
            this.pid = pid;
            this.color = color;
            this.maxDepth = maxDepth;
            this.lastUpdate = lastUpdate;
        }
        List<Integer> childIds = new ArrayList<>();

        public Node() {

        }
    }

    class ColorCount {
        int[] cnt = new int[COLOR_MAX+1];

        ColorCount add(ColorCount obj) {
            ColorCount res = new ColorCount();
            for (int i = 1; i <= COLOR_MAX; i++) {
                res.cnt[i] = this.cnt[i] + obj.cnt[i];
            }
            return res;
        }

        int score() {
            int res = 0;
            for (int i = 1; i <= COLOR_MAX; i++) {
                if (this.cnt[i] > 0) res++;
            }
             return res * res;
        }
    }

    Object[] getBeauty(Node curr, int color, int lastUpdate) {
        // root에서 내려온 색 정보보다 현재 색이 최신이라면 갱신
        if (lastUpdate < curr.lastUpdate) {
            lastUpdate = curr.lastUpdate;
            color = curr.color;
        }

        int res = 0;
        ColorCount colorCount = new ColorCount();
        colorCount.cnt[color] = 1;
        for (int childIdx : curr.childIds) {
            Node child = nodes[childIdx];
            Object[] subResult = getBeauty(child, color, lastUpdate);
            colorCount = colorCount.add((ColorCount) subResult[1]);
            res += (Integer) subResult[0];
        }
        res += colorCount.score();
        return new Object[] {res, colorCount};

    }

    boolean canMakeChild(Node curr, int needDepth) {
        if (curr.mid == 0) return true;
        if (curr.maxDepth <= needDepth) return false;
        return canMakeChild(nodes[curr.pid], needDepth+1);
    }

    int[] getColor(Node curr) { // 색 정보와, 해당 색이 설정된 시간
        if (curr.mid == 0) return new int[] {0, 0}; // root 값을 출력하기 위함

        int[] info = getColor(nodes[curr.pid]);
        if (info[1] > curr.lastUpdate) {
            return info; // 부모의 색이 나이므로,
        } else {
            // 아니라면 나의 색 출력
            return new int[] {curr.color, curr.lastUpdate};
        }

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Q = Integer.parseInt(br.readLine());
            for (int q = 0; q < Q; q++) {
                String[] str = br.readLine().split(" ");
                int value = Integer.parseInt(str[0]);
                if (value == 100) {
                    int mid = Integer.parseInt(str[1]);
                    int pid = Integer.parseInt(str[2]);
                    int color = Integer.parseInt(str[3]);
                    int maxDepth = Integer.parseInt(str[4]);

                    if (pid == -1) {
                        isRoot[mid] = true;
                        pid = 0;
                    }

                    if (isRoot[mid] || canMakeChild(nodes[pid], 1)) {
                        nodes[mid] = new Node(mid, pid, color, maxDepth, q);
                        if (!isRoot[mid]) {
                            nodes[pid].childIds.add(mid);
                        }
                    }

                } else if (value == 200) { // 색 변경 (특정 노드의 자식들)
                    int mid = Integer.parseInt(str[1]);
                    int color = Integer.parseInt(str[2]);
                    // 색 변화 명령에 대해 lazy update 진행
                    // 즉 바로 update가 아니라, 조회 시 update
                    nodes[mid].color = color;
                    nodes[mid].lastUpdate = q;
                } else if (value == 300) {
                    int mid = Integer.parseInt(str[1]);
                    int[] info = getColor(nodes[mid]);
                    System.out.println(info[0]);
                } else if (value == 400) {
                    int sum = 0;
                    for (int i = 1; i < MAX_ID; i++) {
                        if (isRoot[i]) {
                            sum += (Integer) getBeauty(nodes[i], nodes[i].color, nodes[i].lastUpdate) [0];
                        }
                    }
                    System.out.println(sum);
                }
            }

        } catch (Exception e) {}
    }
    public static void main(String[] args) {
        System.out.println("BB");
        Samsung_24FirstPm02_prac b = new Samsung_24FirstPm02_prac();
        System.out.println("START");
        b.init();
    }
}

