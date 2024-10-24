import java.util.*;

class Solution {
    char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] visited;
    char[] result;
    int answer = 0;
    
    public int solution(int n, String[] data) {
        
        visited = new boolean[friends.length];
        result = new char[friends.length];
        
        dfs(n, data, 0);
        
        return answer;
    }
    
    private void dfs(int n, String[] data, int depth) {
        if (depth == result.length) {
            Map<Character, Integer> map = new HashMap<>();
            
            for (int i = 0; i < result.length; i++) {
                map.put(result[i], i);
            }
            
            boolean isPass = true;
            for (String condition : data) {
                char friend1 = condition.charAt(0);
                char friend2 = condition.charAt(2);
                
                char equalSign = condition.charAt(3);
                int requestGap = condition.charAt(4) - '0';
                
                int curGap = (int) Math.abs(map.get(friend1) - map.get(friend2)) - 1;
                
                if (equalSign == '=') {
                    if (requestGap != curGap) {
                        isPass = false;
                        break;
                    }
                } else if (equalSign == '>') {
                    if (curGap <= requestGap) {
                        isPass = false;
                        break;
                    }
                } else if (equalSign == '<') {
                    if (curGap >= requestGap) {
                        isPass = false;
                        break;
                    }
                }
            }
            
            if (isPass) {
                answer++;    
            }
            
            return;
        }
        
        for (int i = 0; i < friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = friends[i];
                dfs(n, data, depth + 1);
                visited[i] = false;
            }
        }
    }
}