package b_202412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/** 240120 모독 https://www.acmicpc.net/problem/16678 */
public class B_16678 {

    int n;
    int[] members;

    void solve() {
        init();

//        1) 모든 국회의원을 모독해서 각각의 명예 점수를 1씩 감소시킨다.
//        2) (1)로 인해 1명이라도 국회의원에서 박탈당한 사람이 발생했다면 국민들의 분노를 이용해 (1)로 돌아간다.
//        3) (1)에 의해 국회의원에서 박탈당한 사람이 없다면 프로젝트를 종료한다.
        Arrays.sort(members);

        // 1씩 차이나는 순열을 만들면 됨. (1의 갯수가 있으면 넘기기)
        // 맨처음 값은 1로 만들기

        long sum = 0;
        if (members[0] != 1) {
            sum += (members[0]-1);
            members[0] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (members[i-1] + 1 < members[i]) {
                sum += (members[i]-(members[i-1]+1));
                System.out.print(members[i]+"->");
                members[i] = members[i-1]+1;
                System.out.println(members[i] +" sum = " + sum);
            }
        }

        System.out.println(sum);

    }

    void init() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            members = new int[n];
            for (int i = 0; i < n; i++) {
                members[i] = Integer.parseInt(br.readLine());
            }
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        B_16678 b = new B_16678();
        b.solve();
    }
}
