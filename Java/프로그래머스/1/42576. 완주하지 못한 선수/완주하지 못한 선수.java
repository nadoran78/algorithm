import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> nameToCount = new HashMap<>();
        
        for (String name : participant) {
            Integer count = nameToCount.getOrDefault(name, 0);
            nameToCount.put(name, count + 1);
        }
        
        for (String name : completion) {
            Integer count = nameToCount.get(name);
            
            if (count == null) {
                continue;
            }
            
            count--;
            
            if (count == 0) {
                nameToCount.remove(name);
            } else {
                nameToCount.put(name, count);
            }
        }
        
        Set<String> keys = nameToCount.keySet();
        if (keys.size() == 0) {
            return null;
        }
        
        return keys.iterator().next();
    }
}