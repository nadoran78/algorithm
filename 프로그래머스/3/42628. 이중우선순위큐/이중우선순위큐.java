import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> counts = new TreeMap<>();
        
        for (String operation : operations) {
            char command = operation.charAt(0);
            int value = Integer.parseInt(operation.substring(2));
            
            if (command == 'I') {
                counts.merge(value, 1, Integer::sum);
            } else if (!counts.isEmpty()) {
                int target = (value == 1) ? counts.lastKey() : counts.firstKey();
                removeOne(counts, target);
            }
        }
        
        if (counts.isEmpty()) {
            return new int[]{0, 0};
        }
        
        return new int[]{counts.lastKey(), counts.firstKey()};
    }
    
    private void removeOne(TreeMap<Integer, Integer> counts, int key) {
        int count = counts.get(key);
        
        if (count == 1) {
            counts.remove(key);
        } else {
            counts.put(key, count - 1);
        }
    }
}