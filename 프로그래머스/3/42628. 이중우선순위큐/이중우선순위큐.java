import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                String[] seperate = operation.split(" ");
                Integer key = Integer.valueOf(seperate[1]);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            
            if (operation.equals("D -1")) {
                if (map.size() != 0) {
                    Integer minKey = map.firstKey();
                    if (map.get(minKey) == 1) {
                        map.remove(minKey);
                    } else {
                        map.put(minKey, map.get(minKey) - 1);
                    }
                }
            }
            
            if (operation.equals("D 1")) {
                if (map.size() != 0) {
                    Integer maxKey = map.lastKey();
                    if (map.get(maxKey) == 1) {
                        map.remove(maxKey);
                    } else {
                        map.put(maxKey, map.get(maxKey) - 1);
                    }
                }
            }
        }
        
        System.out.println(map.size());
        if (map.size() == 0) {
            return new int[]{0, 0};
        }
        return new int[]{map.lastKey(), map.firstKey()};
    }
}