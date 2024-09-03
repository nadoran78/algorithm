import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        int left = 0;
        int right = enemy.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int[] array = Arrays.copyOfRange(enemy, 0, mid + 1);
            
            if (isPass(array, k, n)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer + 1;
    }
    
    private boolean isPass(int[] array, int k, int n) {
        Arrays.sort(array);
        if (array.length < k) {
            return true;
        }
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] > n) {
                if (array.length > i + k) {
                    return false;
                } else {
                    return true;
                }
            } else {
                n -= array[i];
            }
        }
        
        return true;
    }
}