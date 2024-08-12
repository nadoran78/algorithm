import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            boolean isBorrow = false;
            if (lost[i] < 0) {
                continue;
            }
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1) {
                    isBorrow = true;
                    reserve[j] = -1;
                    break;
                }
            }
            
            if (!isBorrow) {
                answer++;
            }
        }
        return n - answer;
    }
}