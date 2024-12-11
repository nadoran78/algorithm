import java.util.*;

class Solution {
    int[] combination;
    boolean[] visited;
    List<String> candidateKeys = new ArrayList<>();
    int answer = 0;
    int n, m;
    public int solution(String[][] relation) {
        n = relation.length;
        m = relation[0].length;
        
        combination = new int[m];
        visited = new boolean[m];
        
        dfs(relation, 0);
        
        for (int i = 0; i < candidateKeys.size(); i++) {
      boolean isPass = true;
      for (int j = i + 1; j < candidateKeys.size(); j++) {
        String target = candidateKeys.get(i);
        String temp = candidateKeys.get(j);


        int count = 0;
        for (int k = 0; k < target.length(); k++) {

            if (temp.contains(String.valueOf(target.charAt(k)))) {
                count++;
            }
        }

        if (count == temp.length()) {
            isPass = false;
        }
      }

      if (isPass) {
        answer++;
      }
    }
        
        return answer;
    }
    
    private void dfs(String[][] relation, int depth) {
        
        if (isUnique(relation, depth)) {
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < depth; i++) {
                sb.append(combination[i]);
            }
            
            if (isMinimal(sb.toString())) {
                candidateKeys.add(sb.toString());
            }                
            return;
        }
        
        if (depth == m) {
            return;
        }
        
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                
                combination[depth] = i;
                dfs(relation, depth + 1);
                visited[i] = false;
            }
             
        }
    }
    
    private boolean isUnique(String[][] relation, int depth) {
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < depth; j++) {
                sb.append(relation[i][combination[j]]);
            }
            
            if (!set.add(sb.toString())) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isMinimal(String temp) {
        
        for (String key : candidateKeys) {
            int count = 0;
            
            for (int i = 0; i < temp.length(); i++) {
                if (key.contains(String.valueOf(temp.charAt(i)))) {
                    count++;
                }
            }
            
            if (count == key.length()) {
                return false;
            }
        }
        return true;
    }
}