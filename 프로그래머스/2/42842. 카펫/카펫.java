import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= yellow / 2; i++) {
            if (yellow % i != 0) {
                continue;
            }
            
            int width = yellow / i + 2;
            int height = i + 2;
            
            if (width < height) {
                continue;
            }
            
            if (width * height == brown + yellow) {
                return new int[]{width, height};
            }
        }
        
        return new int[]{3, yellow + 2};
    }
}