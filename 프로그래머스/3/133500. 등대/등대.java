import java.util.*;

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int N, result;

    public int solution(int n, int[][] lighthouse) {
        N =n;
        result = 0;
        
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int[] node : lighthouse) {
            list.get(node[0]).add(node[1]);
            list.get(node[1]).add(node[0]);    
        }
        
        dfs(1, 0);
        
        return result;
    }
    
    private int dfs(int cur, int before) {
        
        if (list.get(cur).size() == 1 && list.get(cur).get(0) == before) {
            return 1;
        }
        
        int tempRes = 0;
        for (Integer next : list.get(cur)) {
            if (next == before) {
                continue;
            }
            tempRes += dfs(next, cur);
        }
        
        if (tempRes == 0) {   
            return 1;
        }
        
        result++;
        return 0;
    }
}