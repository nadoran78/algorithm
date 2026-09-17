import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Set<String>> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            Set<String> set = map.getOrDefault(cloth[1], new HashSet<>());
            set.add(cloth[0]);
            map.put(cloth[1], set);
        }
        
        int combination = 1;
        for (String key : map.keySet()) {
            int length = map.get(key).size() + 1;
            combination *= length;
        }
        
        return combination - 1;
    }
}