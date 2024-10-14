import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] completeDays = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            int restProgress = 100 - progresses[i];
            int speed = speeds[i];
            
            completeDays[i] = (int) Math.ceil((double) (restProgress) / (double) speed);
        }
        
        int curIdx = 0;
        List<Integer> result = new ArrayList<>();
        while (curIdx < completeDays.length) {
            int cur = completeDays[curIdx];
            
            int tempIdx = curIdx + 1;
            int count = 1;
            while (tempIdx < completeDays.length && completeDays[tempIdx] <= cur) {
                count++;
                tempIdx++;
            }
            
            result.add(count);
            curIdx = tempIdx;
        }
        
        return result.stream().mapToInt(i -> i.intValue()).toArray();
    }
}