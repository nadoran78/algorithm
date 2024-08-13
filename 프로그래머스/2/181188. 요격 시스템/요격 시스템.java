import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        
        int pre = -1;
        for (int[] target : targets) {
            if (pre <= target[0]) {
                answer++;
                pre = target[1];
            }
        }
        return answer;
    }
}