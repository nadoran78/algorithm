import java.util.*;

class Solution {
    boolean[] visited;
    int dfsResult = 0;
    public int solution(int[] cards) {
        int answer = 0;
        visited = new boolean[cards.length];
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(cards, i, 0);
                list.add(dfsResult);
            }
        }
        
        list.sort((x, y) -> y - x);
        
        if (list.size() == 1) {
            return 0;
        }
        
        answer = list.get(0) * list.get(1);

        return answer;
    }
    
    private void dfs(int[] cards, int index, int count) {    
        int nextIdx = cards[index] - 1;
        
        if (visited[nextIdx]) {
            dfsResult = count + 1;
            return;
        }
        
        if (!visited[nextIdx]) {
            visited[nextIdx] = true;
            dfs(cards, nextIdx, count + 1);
        }
    }
}