package b_30_bitmasking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_13701 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N의 범위는 2의 25승이다. int는 32bit형이기 때문에, 배열의 한 원소당 32bit만큼 검사를 해야한다.

        // 1. 2의 25승 / 32(2의 5승) ->. 25 - 5 = 20
        // 2. 위의 20이 a[i]를 32로 나눈 몫의 범위이다. int[] nums = new int[1<<20];
        // 3. 각 몫마다 나머지를 기록한다. 몫 * 나머지는 a가 된다.
        // 즉 nums[i]는 i의 몫에 나머지는 0부터 ~ 32 나머지까지 들어갈 수 있다.
        // 4. 만약 같은 수가 뒤에 들어오면, 몫의 배열을 확인하여 해당 나머지가 있으면 이미 있는 수이므로, out한다.
        // 5. 나머지가 0이면 1 << y -> 1 이 된다.

        int[] nums = new int[(int)Math.pow(2, 20)];
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            int x = n / 32;
            int y = n % 32;
            if ((nums[x] & (1 << y)) == (1 << y)) continue;
            nums[x] |= (1 << y);
            sb.append(n +" ");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
