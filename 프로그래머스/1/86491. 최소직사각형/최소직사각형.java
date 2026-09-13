import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int totalMax = 0;
        int totalMin = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int[] size = sizes[i];
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);
            
            totalMax = Math.max(totalMax, max);
            totalMin = Math.max(totalMin, min);
        }
        
        
        return totalMax * totalMin;
    }
}