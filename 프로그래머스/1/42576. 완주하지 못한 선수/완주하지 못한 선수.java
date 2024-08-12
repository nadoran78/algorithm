import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        for (String name : completion) {
            int num = map.get(name);
            if (num > 1) {
                map.put(name, num - 1);
            } else if (num == 1) {
                map.remove(name);
            }
        }
        
        for (String name : map.keySet()) {
            answer += name;
        }
        return answer;
    }
}