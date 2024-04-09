package study_alone;
import java.io.*;
import java.util.*;

/** 240409 삼성 기출문제 예술성 골드 3 회전, 구현 */

public class CT_240409 {

    final int N = 30;
    int n;
    int[][] map = new int[N][N];
    int[][] newMap = new int[N][N];
    int[][] groupMap = new int[N][N];
    int[][] tmpMap = new int[N][N];
    int[][] copyMap = new int[N][N];
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    int groupCnt;
    Map<Integer, Integer> cntMap;

    public int bfs(int x, int y, int idx) {

        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{x, y});
        groupMap[x][y] = idx;
        int v = map[x][y];
        int cnt = 1;

        while (!qu.isEmpty()) {
            int[] q = qu.poll();
            int xx = q[0], yy = q[1];

            for (int k = 0; k < 4; k++) {
                int nx = xx + dx[k], ny = yy + dy[k];
                if (nx <= 0 || ny <= 0 || nx > n || ny > n) continue;
                if (groupMap[nx][ny] > 0 || map[nx][ny] != v) continue;
                groupMap[nx][ny] = idx;
                qu.add(new int[]{nx, ny});
                cnt++;
            }
        }

        return cnt;
    }

    public long calculate(int idx1, int idx2) {
        // idx1, idx2의 계산

        int idx1Cnt = cntMap.get(idx1);
        int idx2Cnt = cntMap.get(idx2);
        int idx1Value = 0, idx2Value = 0;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (groupMap[i][j] == idx1) {
                    idx1Value = map[i][j];
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k], nj = j + dy[k];
                        if (ni <= 0 || nj <= 0 || ni > n || nj > n || groupMap[ni][nj] != idx2) continue;
                        idx2Value = map[ni][nj];
                        cnt++;
                    }
                }
            }
        }

        return (idx1Cnt + idx2Cnt) * idx1Value * idx2Value * cnt;


    }

    public long cntHarmony() {
        long ans = 0;
        // 예술 점수 계산
        for (int i = 1; i < groupCnt; i++) {
            for (int j = i + 1; j < groupCnt; j++) {
                ans += calculate(i, j);
            }
        }
        return ans;
    }

    public void groupInit() {
        groupCnt = 1;
        cntMap = new HashMap<>();
        groupMap = new int[N][N];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (groupMap[i][j] >= 1) continue;
                int cnt = bfs(i, j, groupCnt);
                cntMap.put(groupCnt, cnt);
                groupCnt++;
            }
        }
    }

    public void print() {
        System.out.println("맵 프린트");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void rotate90(int stX, int stY) {
        int size = (n-1) / 2;

        // 원본 맵에 복사를 한다.
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                copyMap[i][j] = map[stX + i][stY + j];
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                tmpMap[i][j] = copyMap[size-j+1][i];
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                newMap[stX + i][stY + j] = tmpMap[i][j];
            }
        }
    }

    public void rotate270() {
        int mid = (n-1)/2 + 1;

        for (int i = 1; i <= n; i++) {
            newMap[mid][i] = map[i][mid];
            newMap[i][mid] = map[mid][n-i+1];
        }

    }

    public void ratate() {
        newMap = new int[N][N];
        int size = (n-1)/2;
        rotate90(0, 0);
        rotate90(0, size+1);
        rotate90(size+1, 0);
        rotate90(size+1, size+1);
        rotate270();

        map = newMap;
    }


    public void solve() {
        long res = 0;
        for (int t = 1; t <= 4; t++) {
            // 1. 그룹 선정
            groupInit();

            // 2. 조화로움 계산 (예술 점수)
            long v =  cntHarmony();
            res += v;

            // 3. 회전
            ratate();
            // print();

        }
        System.out.println(res);
    }

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
//        Main m = new Main();
        CT_240409 m = new CT_240409();
        m.init();
        m.solve();
    }
    public void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
