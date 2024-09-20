class Solution {
    boolean[] visited;
    int answer = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons, 0);
        return answer;
    }
    
    private void dfs(int depth, int k, int[][] dungeons, int count) {
        answer = Math.max(count, answer);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                if (k >= dungeons[i][0]) {
                    visited[i] = true;
                    dfs(depth + 1, k - dungeons[i][1], dungeons, count + 1);
                    visited[i] = false;    
                } 
            }
        }
    }
}