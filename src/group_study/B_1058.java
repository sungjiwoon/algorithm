package group_study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    친구 (실버2)
 */
public class B_1058 {
    public void work() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] friends = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'N') friends[i][j] = 100; //50보다 큰 숫자.
                else friends[i][j] = 1;
            }
        }

        //a와 b가 c와 친구면, friends[a][c] = friends[b][c] = 1,
        // friends[a][b] = friends[a][c] + friends[c][b] = 2;
        //단계가 거치는게 많을수록 거치는 친구수만큼 배열에 담기게된다.
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    friends[i][j] = Math.min(friends[i][k]+friends[k][j], friends[i][j]);
                }
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(friends[i][j]+" ");
//            }
//            System.out.println();
//        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i==j) continue;
                if (friends[i][j] <= 2) sum++;
            }
            ans = Math.max(sum,ans);
        }

        System.out.println(ans);

    }
}
