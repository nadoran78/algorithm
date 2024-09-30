import java.util.*;

class Solution {
    boolean[] visited;
    List<String> result;
    int count;
    Map<Character, Set<Integer>> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        map = new HashMap<>();
        
        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < orders[i].length(); j++) {
                Set<Integer> set = map.getOrDefault(orders[i].charAt(j), new HashSet<>());
                set.add(i);
                map.put(orders[i].charAt(j), set);
            }
        }
        
        List<Character> keyList = new ArrayList<>(map.keySet());
        
        for (int i = 0; i < course.length; i++) {
            visited = new boolean[keyList.size()];
            result = new ArrayList<>();
            count = 0;
            dfs(course[i], new StringBuilder(), keyList, 0);
            
            answer.addAll(result);
        }
        
        Collections.sort(answer);
        
        return answer.toArray(new String[answer.size()]);
    }
    
    private void dfs(int courseLength, StringBuilder sb, List<Character> keyList, int idx) {
        if (sb.length() == courseLength) {
            int num = combination(sb.toString());
            if (num < 2) {
                return;
            }
            
            if (num > count) {
                count = num;
                result = new ArrayList<>();
                result.add(sb.toString());
            } else if (num == count) {
                result.add(sb.toString());
            }
            return;
        }
        
        for (int i = idx; i < keyList.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(courseLength, new StringBuilder(sb).append(keyList.get(i)), keyList, i + 1);
                visited[i] = false;
            }
        }
    } 
    
    private int combination(String candidate) {
        Set<Integer> set = new HashSet<>(map.get(candidate.charAt(0)));
        
        for (int i = 1; i < candidate.length(); i++) {
            Character key = candidate.charAt(i);
            
            set.retainAll(map.get(key));
        }
        
        return set.size();
    }
}