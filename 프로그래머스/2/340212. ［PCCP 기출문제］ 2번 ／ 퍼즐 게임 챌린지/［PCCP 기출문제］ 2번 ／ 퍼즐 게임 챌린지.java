import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            
            if (isPass(mid, diffs, times, limit)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        
        return answer;
    }
    
    private boolean isPass(int level, int[] diffs, int[] times, long limit) {
        
        long totalTime = (long) times[0];
        
        for (int i = 1; i < diffs.length; i++) {
            int diff = diffs[i];
            int timeCur = times[i];
            int timePrev = times[i - 1];
            
            if (diff <= level) {
                totalTime += (long) timeCur;
            } else {
                totalTime += (long) ((timeCur + timePrev) * (diff - level) + timeCur);
            }
        }
        
        return totalTime <= limit;
    }
}