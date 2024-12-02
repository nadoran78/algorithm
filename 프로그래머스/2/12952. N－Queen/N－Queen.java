class Solution {
    int[] result;
    int answer = 0;
    public int solution(int n) {
        result = new int[n];
        
        dfs(0, n);
        
        return answer;
    }
    
    private void dfs(int depth, int n) {
        if (depth == n) {
            answer++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            result[depth] = i;
            
            boolean isPass = true;
            for (int j = 0; j < depth; j++) {
                if (result[j] == i || Math.abs(j - depth) == Math.abs(result[j] - i)) {
                    isPass = false;
                    break;
                }
            }
            
            if (isPass) {
                dfs(depth + 1, n);
            }
        }
    }
}