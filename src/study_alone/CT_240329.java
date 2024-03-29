package study_alone;
import java.io.*;
import java.util.*;

/** 240329 코드 트리 왕실의 기사 대결 골3 */

public class CT_240329 {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int EMPTY = 0, TRAP = 1, WALL = 2;
    final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    Person[] knights = new Person[31];
    boolean[] kLive = new boolean[31];
    boolean[] vis = new boolean[31];
    int l, n, q;
    int[][] map = new int[42][42];
    int[][] locMap = new int[42][42];
    Queue<Integer> moveQ;
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    int dir = 0, pi = 0;

    class Person {
        int r, c, h, w, k, a;
        Person (int r, int c, int h, int w, int k) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
            this.a = 0;
        }
    }


    private boolean check(int idx) {
        Person p = knights[idx];
        boolean res = true;
        int nxR = p.r, nxC = p.c;
        moveQ.add(idx);

        if (dir == UP) {
            nxR = p.r - 1;
            if (nxR == 0) return false;
            for (int nx = p.c; nx < p.c + p.w; nx++) {
                if (map[nxR][nx] == WALL) return false;
                if (locMap[nxR][nx] > 0) {
                    int nxIdx = locMap[nxR][nx];
                    if (!vis[nxIdx] && !kLive[nxIdx]) {
                        res = check(nxIdx);
                        vis[nxIdx] = true;
                        if (!res) {
                            break;
                        }
                    }
                }
            }

        } else if (dir == RIGHT) {

            nxC = p.c + p.w;
            if (nxC == l + 1) return false;
            for (int nx = p.r; nx < p.r + p.h; nx++) {
                if (map[nx][nxC] == WALL) return false;
                if (locMap[nx][nxC] > 0) {
                    int nxIdx = locMap[nx][nxC];
                    // System.out.println(nxIdx +"번 만났습니다.");
                    if (!vis[nxIdx] && !kLive[nxIdx]) {
                        res = check(nxIdx);
                        vis[nxIdx] = true;
                        if (!res) {
                            break;
                        }
                    }
                }
            }

        } else if (dir == DOWN) {

            nxR = p.r + p.h;
            if (nxR == l + 1) return false;
            for (int nx = p.c; nx < p.c + p.w; nx++) {
                if (map[nxR][nx] == WALL) return false;

                if (locMap[nxR][nx] > 0) {
                    int nxIdx = locMap[nxR][nx];
                    if (!vis[nxIdx] && !kLive[nxIdx]) {

                        res = check(nxIdx);
                        // System.out.println(String.format("아래 이동 결과 res = ") + res);
                        vis[nxIdx] = true;
                        if (!res) {
                            break;
                        }
                    }
                }
            }

        } else if (dir == LEFT) {
            nxC = p.c - 1;
            if (nxC == 0) return false;
            for (int nx = p.r; nx < p.r + p.h; nx++) {
                if (map[nx][nxC] == WALL) return false;
                if (locMap[nx][nxC] > 0) {
                    int nxIdx = locMap[nx][nxC];
                    if (!vis[nxIdx] && !kLive[nxIdx]) {
                        res = check(nxIdx);
                        vis[nxIdx] = true;
                        if (!res) {
                            break;
                        }
                    }
                }
            }
        }

        return res;
    }

    private void moveAndAttack() {
        while (!moveQ.isEmpty()) {
            int idx = moveQ.poll();
            Person p = knights[idx];
            p.r += dx[dir];
            p.c += dy[dir];

            if (idx == pi) continue;

            // 대결 대미지 하락
            int attack = 0;
            for (int i = p.r; i < p.r + p.h; i++) {
                for (int j = p.c; j < p.c + p.w; j++) {
                    if (map[i][j] == TRAP) {
                        attack++;
                    }
                }
            }

            if (p.k <= attack ) {
                kLive[idx] = true;
            } else {
                p.k -= attack;
                p.a += attack;
            }

        }
    }

    private void fillLocMap() {
        locMap = new int[42][42];
        for (int idx = 1; idx <= n; idx++) {
            if (kLive[idx]) continue;
            Person p = knights[idx];
            for (int rr = p.r; rr < p.r + p.h; rr++) {
                for (int cc = p.c; cc < p.c + p.w; cc++) {
                    locMap[rr][cc] = idx;
                }
            }
        }
    }

    private void print() {
        System.out.println("= 출력 = ");
        for (int i = 1; i <= l; i++) {
            for (int j = 1; j <= l; j++) {
                System.out.print(locMap[i][j] + " ");
            }
            System.out.println();
        }
    }



    private void solve() throws Exception {
        for (int i = 1; i <= q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            pi = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());

            // 기사 이동
            if (kLive[pi]) continue; // 죽은 기사를 옮기는 거면, continue;
            vis = new boolean[31];
            moveQ = new LinkedList<>();

            // 1. 기사가 이동이 가능한지 확인
            if (!check(pi)) {
                // System.out.println("이동할 수 없어서 return");
                continue;
            }

            // 2. 기사들 이동 시킨다.
            // 3. (본인 제외) 밀려난 기사들의 대결 대미지를 체크한다.
            // 대결 대미지
            moveAndAttack();

            // locMap 재정비

            fillLocMap();
            // System.out.println(i+"번째 시도 후 변화");
            // print();
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (!kLive[i]) {
                res += knights[i].a;
            }
        }

        System.out.println(res);

    }

    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.
        CT_240329 m = new CT_240329();
//        Main m = new Main();
        m.input();
        // m.print();
        m.solve();
    }

    private void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        l = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= l; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            knights[i] = new Person(r, c, h, w, k);
            for (int rr = r; rr < r + h; rr++) {
                for (int cc = c; cc < c + w; cc++) {
                    locMap[rr][cc] = i;
                }
            }
        }

    }
}
