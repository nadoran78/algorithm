import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        visited = new boolean[numbers.length()];
        
        dfs(0, new StringBuilder(), numbers);
        
        for (Integer num : set) {
            if (isPrimeNumber(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int depth, StringBuilder num, String numbers) {
        if (depth == numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                if (depth == 0 && numbers.charAt(i) - '0' == 0) {
                    continue;
                }
                
                visited[i] = true;
                StringBuilder nextNum = new StringBuilder(num).append(numbers.charAt(i));
                
                int n = Integer.parseInt(nextNum.toString());
                
                set.add(n);
                
                dfs(depth + 1, nextNum, numbers);
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrimeNumber(int num) {
        int half = num / 2;
        if (num < 2) {
            return false;
        }
        
        for (int i = half; i > 1; i--) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}