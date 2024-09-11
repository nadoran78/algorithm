import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            boolean isFill = true;
            for (int j = 0; j < want.length; j++) {
                if (map.containsKey(want[j])) {
                    if (map.get(want[j]) < number[j]) {
                        isFill = false;
                        break;
                    }    
                } else {
                    isFill = false;
                    break;
                }
                
            }
            
            if (isFill) {
                answer++;
            }
            
            if (i < discount.length - 10) {
                map.put(discount[i], map.get(discount[i]) - 1);
                map.put(discount[i + 10], map.getOrDefault(discount[i + 10], 0) + 1);
            }
        }
        
        return answer;
    }
}