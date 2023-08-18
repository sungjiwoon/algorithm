package group_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B_12919 {
    static StringBuilder S, T;
    static HashSet<String> has_string = new HashSet<>();
    private static int recursion(StringBuilder sb) {
        if (sb.length() < S.length()) return 0;
        if (has_string.contains(sb.toString())) return 0;

        if (sb.compareTo(S) == 0) {
            return 1;
        }

        has_string.add(sb.toString());
        StringBuilder tmp1 = new StringBuilder(sb.toString());
        StringBuilder tmp2 = new StringBuilder(sb.toString());

        int res = 0;
        if (tmp1.charAt(tmp1.length()-1) == 'A') res += recursion(tmp1.deleteCharAt(tmp1.length()-1));
        if (tmp2.reverse().charAt(tmp2.length()-1) == 'B'){
            res += recursion(tmp2.deleteCharAt(tmp2.length()-1));
        }

        return res;
    }
    public static void main(String[] args) throws IOException{
        input();

        int res = recursion(T);
        if (res > 0) System.out.println(1);
        else System.out.println(0); //만약 문자열이 만들어지지 않는다면 0

        /*
        처음에는 재귀로 돌며 완탐으로 풀었다. 시간복잡도 최악일 경우 2의 49승 = 약 1조 넘음 -> 안 됨.
        S->T 로 만들어가는 게 아닌, T -> S 로 가는 방법으로 바꿔 풀었다. (128ms)
        T -> S 로 가면 조건을 더 세워야하므로 S->T보다 재귀를 덜 돌게된다.

        1) 만들어진 문자열의 길이가 S의 문자열 길이보다 짧다면 return
        2) HashSet 을 통해 이미 검사했던 문자열이 또 들어오면 return (없으면 132ms, 거의 차이 없어서 안해도 무방)
        3) 문자열 끝에 'A' 가 있다면 A를 없애는 조건을 걸어 재귀를 돌렸다.
        4) 문자열을 뒤집어 끝에 'B' 가 있다면 B를 없애는 조건을 걸어 재귀를 돌렸다.

        String 대신 StringBuilder를 사용한 이유 : StringBuilder는 내부적으로 가변적인 char[]을 사용하므로
        String 보다 문자열을 변경, 삽입하는데 훨씬 시간이 덜 소요된다.

        문자 삭제 방법 StringBuilder deleteCharAt(int index)
        문자가 같은 문자인지 비교 방법 StringBuilder.compareTo(StringBuilder sb) == 0 -> 같음.

         */

    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        S = new StringBuilder(br.readLine());
        T = new StringBuilder(br.readLine());
    }
}
