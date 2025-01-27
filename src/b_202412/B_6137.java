package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 250127 문자열 생성
public class B_6137 {
    int n;
    char[] S, T;

    void solve() {

        int st = 0, en = n-1;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {

            if (st >= n || vis[st] && !vis[en]) {
                T[i] = S[en];
                vis[en] = true;
                en--;
            } else if (en < 0 || vis[en] && !vis[st]) {
                T[i] = S[st];
                vis[st] = true;
                st++;
            } else {
                // S의 앞뒤 중 사전 순 앞인 것부터 추가한다.
                if (S[st] < S[en]) {
                    T[i] = S[st];
                    vis[st] = true;
                    st++;
                } else if (S[st] > S[en]) {
                    T[i] = S[en];
                    vis[en] = true;
                    en--;
                } else {
                    // 같을 경우, 점점 줄여 가며 비교
                    int tmpSt = st, tmpEn = en;

                    boolean same = false;
                    while (tmpSt < n && tmpEn >= 0 && S[tmpSt] == S[tmpEn]) {
                        if (tmpSt == tmpEn) {
                            // 같은 글자임   -> 아무거나 넣어도됨.
                            same = true;
                            break;
                        }
                        tmpSt++;
                        tmpEn--;

//                        System.out.println(tmpSt + " " + tmpEn);
                    }
                    if (tmpSt >= n && tmpEn >= 0) {
                        T[i] = S[en];
                        vis[en] = true;
                        en--;
                    } else if (tmpSt < n && tmpEn < 0) {
                        T[i] = S[st];
                        vis[st] = true;
                        st++;
                    } else if (same || S[tmpSt] < S[tmpEn]) {
                        T[i] = S[st];
                        vis[st] = true;
                        st++;
                    } else {
                        T[i] = S[en];
                        vis[en] = true;
                        en--;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != 0 && i % 80 == 0) {
                System.out.println();
            }
            System.out.print(T[i]);
        }


    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
//            n = 164;
            S = new char[n];
            T = new char[n];
//            String[] sp = "A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A A B".split(" ");
            //String[] sp = "D D C A D D".split(" ");

            for (int i =0; i < n; i++) {
//                S[i] = 'A';
//                S[i] = sp[i].charAt(0);
                S[i] = br.readLine().charAt(0);
            }
            solve();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_6137 b = new B_6137();
        b.init();
    }
}
