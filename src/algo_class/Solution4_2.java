package algo_class;
import java.util.*;

public class Solution4_2 {
    public int solution(int[][] nums){
        int answer = 0;

        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> b - a);
        Arrays.sort(nums, (a, b) -> b[1] - a[1]);

        int maxd = nums[0][1];
        int j = 0;
        for(int i = maxd; i >= 1; i--){
            for(; j<nums.length; j++){
                if(nums[j][1]<i) break;
                pQ.add(nums[j][0]);
            }
            if(!pQ.isEmpty()) answer += pQ.poll();
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution4_2 T = new Solution4_2();
        System.out.println(T.solution(new int[][]{{50, 2}, {20, 1}, {40, 2}, {60, 3}, {30, 3}, {30, 1}}));
        System.out.println(T.solution(new int[][]{{50, 2}, {40, 2}, {20, 1}, {10, 1}}));
        System.out.println(T.solution(new int[][]{{70, 5}, {60, 1}, {80, 2}, {70, 1}}));
    }
}
