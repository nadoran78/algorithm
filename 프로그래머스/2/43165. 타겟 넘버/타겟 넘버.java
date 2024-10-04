class Solution {
    int answer;
    boolean[] visited;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        visited = new boolean[numbers.length];
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    private void dfs(int[] numbers, int depth, int sum, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
//         for (int i = depth; i < numbers.length; i++) {
//             if (!visited[i]) {
//                 visited[i] = true;
//                 dfs(numbers, depth + 1, sum - numbers[i], target);
//                 visited[i] = false;
//             }
            
//             if (!visited[i]) {
//                 visited[i] = true;
//                 dfs(numbers, depth + 1, sum + numbers[i], target);
//                 visited[i] = false;
//             }
            
//         }
        
        dfs(numbers, depth + 1, sum - numbers[depth], target);
        dfs(numbers, depth + 1, sum + numbers[depth], target);
        
    }
}