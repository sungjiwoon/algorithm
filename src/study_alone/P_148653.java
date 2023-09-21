package study_alone;

//마법의 엘리베이터

public class P_148653 {
    public int solution(int storey) {
        int answer = 0;

        // storey + 머시기 = 0
        // 머시기 = -storey
        //10의 n승 조합으로 -storey 만들기..

        //1의 자릿수부터 생각한다. 5보다 큰지 아닌지

        while (storey != 0) {
            int re = storey % 10;
            storey /= 10;
            if (re < 5) {
                answer += re;
            } else if (re > 5) {
                answer += (10-re);
                storey++;
            } else {
                if (storey % 10 >= 5) {
                    answer += (10-re);
                    storey++;
                } else {
                    answer += re;
                }
            }

        }


        return answer;
    }

}
