package study_alone;
//JadenCase 문자열

public class P_12951 {
    public String solution(String s) {
        String answer = "";
        String[] sp = s.split(" ");
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                sb.append(c);
                continue;
            }

            if (i == s.length() - 1) {
                sb.append(Character.toUpperCase(c));
                continue;
            }
            String str = "";
            c = Character.toUpperCase(c);
            str += c;
            int j = i + 1;
            char nxt = s.charAt(j);

            while (j < s.length() && (nxt = s.charAt(j))!= ' ') {
                nxt = Character.toLowerCase(nxt);
                str += nxt;
                j++;
            }
            System.out.println(str);
            if (j < s.length())
                System.out.println(s.charAt(j));
            sb.append(str);
            i = j-1;
        }

        return sb.toString();

    }
}
