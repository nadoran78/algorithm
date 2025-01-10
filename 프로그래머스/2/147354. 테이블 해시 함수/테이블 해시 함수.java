import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        int colIdx = col - 1;
        
        Arrays.sort(data, (a, b) -> {
            if (a[colIdx] == b[colIdx]) {
                return b[0] - a[0];
            }
            return a[colIdx] - b[colIdx];
        });
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int[] target = data[i];
            
            int sum = 0;
            for (int num : target) {
                sum += num % (i + 1);
            }
            
            answer = answer ^ sum;
        }
        
        return answer;
    }
}