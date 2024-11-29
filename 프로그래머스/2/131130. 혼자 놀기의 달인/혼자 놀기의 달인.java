import java.util.*;

class Solution {
    boolean[] visited;
    List<Integer> score = new ArrayList<>();
    int[] board;
    public int solution(int[] cards) {
        int answer = 0;
        
        visited = new boolean[cards.length];
        board = cards;
        
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, 0);
            }
        }
        
        if (score.size() == 1) {
            return 0;
        } else {
            score.sort((x, y) -> y - x);
            answer = score.get(0) * score.get(1);
        }
        
        return answer;
    }
    
    private void dfs(int idx, int count) {
        if (visited[board[idx] - 1]) {
            score.add(count + 1);
            return;
        } 
        
        if (!visited[board[idx] - 1]) {
            visited[board[idx] - 1] = true;
            int newCount = count + 1;
            dfs(board[idx] - 1, newCount);
        }
    }
}