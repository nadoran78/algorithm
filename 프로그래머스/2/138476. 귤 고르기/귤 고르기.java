import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        keySet.sort((x, y) -> {
            return map.get(y) - map.get(x);
        });
        
        for (int i = 0; i < keySet.size(); i++) {
            k -= map.get(keySet.get(i));
            
            
            if (k <= 0) {
                answer = i + 1;
                break;
            }
            
            
        }
        
        return answer;
    }
}