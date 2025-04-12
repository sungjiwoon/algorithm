package b_202502;
import java.io.*;
import java.util.*;
public class Samsung_24FirstAM01 {

    int K, m;
    int[][] map = new int[5][5];
    int[] wallNumber;
    int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    PriorityQueue<int[]> clearQ;

    void rotate(int[][] board, int x, int y) {
        // 90도 회전
        int[][] tmp = new int[3][3];
        int stX = x - 1, stY = y - 1; // 시작 좌표
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tmp[i][j] = board[stY + 3 - j-1][stX+i];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[stY+i][stX+j] = tmp[i][j];
            }
        }
        // if (y == 2 && x == 1) {
        //     System.out.println("= (" + y + ", " + x+") =");
        //     for (int i = 0; i < 5; i++) {
        //         for (int j = 0; j < 5; j++) {
        //             System.out.print(board[i][j] + " ");
        //         }
        //         System.out.println();
        //     }
        // }


    }

    int getValue(int[][] board) {
        int value = 0;

        Queue<int[]> qu = new LinkedList<>();
        boolean[][] vis = new boolean[5][5];
        vis[0][0] = true;

        clearQ = new PriorityQueue<>((o1, o2)-> {
            if (o1[1] != o2[1]) return o1[1] - o2[1]; // 열번호 작은 순
            return o2[0] - o1[0]; // 행번호 큰 순
        });

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (vis[i][j]) continue;
                qu.add(new int[]{i, j});
                int look = board[i][j];
                boolean[][] vis2 = new boolean[5][5];
                vis2[i][j] = true;
                List<int[]> list = new ArrayList<>();
                while (!qu.isEmpty()) {
                    int[] q = qu.poll();
                    vis[q[0]][q[1]] = true;
                    list.add(q);
                    for (int k =0; k < 4; k++) {
                        int ni = q[0]+dy[k], nj = q[1] + dx[k];
                        if (ni < 0 || nj < 0 || ni >= 5 || nj >= 5) continue;
                        if (!vis2[ni][nj] && board[ni][nj] == look) {
                            qu.add(new int[]{ni,nj});
                        }
                        vis2[ni][nj] = true;
                    }
                }
                if (list.size() >= 3) {
                    value += list.size();
                    for (int[] l : list) {
                        clearQ.add(l);
                    }
                }
            }
        }
        return value;

    }


    void explore() {
        // 3*3 격자 선택
        // 1. 유물의 1차 가치를 최대화하는 방법

        // 중심 좌표를 옮기며 생각하기
        // 열이 가장 작고 -> 행이 가장 작은 구간
        // 가치 -> 열 -> 행 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]) return o2[0] - o1[0]; // 가치
            if (o1[1] != o2[1]) return o1[1] - o2[1]; // 열
            if (o1[2] != o2[2]) return o1[2] - o2[2]; // 행
            return o1[3] - o2[3];
        });

        for (int x = 1; x <= 3; x++) { // 열
            for (int y = 1; y <= 3; y++) { // 행
                int[][] copyMap = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        copyMap[i][j] = map[i][j];
                    }
                }
                for (int de = 1; de <= 3; de++) {
                    int value = 0;
                    rotate(copyMap, x, y); // 회전
                    value = getValue(copyMap);
                    pq.add(new int[]{value, de, x, y});
                }
            }
        }

        int[] best = pq.poll();
        int x = best[2], y = best[3];
        for (int de = 1; de <= best[1]; de++) {
            rotate(map, x, y);
        }
        // System.out.println(String.format("= (x: %d, y: %d, de: %d, value: %d) =", x, y, best[1], best[0]));
        // for (int i = 0; i < 5; i++) {
        //     for (int j = 0; j < 5; j++) {
        //         System.out.print(map[i][j] + " ");
        //     }
        //     System.out.println();
        // }

    }

    void solve() {

        int idx = 0;
        for (int k = 0; k < K; k++) {
            int res = 0;
            // 1. 탐사 진행
            explore();

            // 2. 유물 획득
            while (true) {
                int value = getValue(map);
                if (value == 0) break;
                res += value;
                while (!clearQ.isEmpty()) {
                    int[] q = clearQ.poll();
                    if (idx >= m) break;
                    map[q[0]][q[1]] = 0;
                    map[q[0]][q[1]] = wallNumber[idx++];
                }

                // System.out.println(String.format("= (value: %d) =", value));
                // for (int i = 0; i < 5; i++) {
                //     for (int j = 0; j < 5; j++) {
                //         System.out.print(map[i][j] + " ");
                //     }
                //     System.out.println();
                // }
            }
            if (res == 0) break;
            System.out.print(res + " ");
        }

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] sp = br.readLine().split(" ");
            K = Integer.parseInt(sp[0]);
            m = Integer.parseInt(sp[1]);
            for (int i = 0; i < 5; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            wallNumber = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        // Please write your code here.
        Samsung_24FirstAM01 m = new Samsung_24FirstAM01();
        m.init();
        m.solve();
    }
}