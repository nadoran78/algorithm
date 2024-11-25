import java.util.*;

class Solution {
    PriorityQueue<int[]> pq;
    
    int[] answer;
    
    int scoreGap = 0;
    public int[] solution(int n, int[] info) {
        answer = new int[info.length];
        
        pq = new PriorityQueue<int[]>((x, y) -> {
            for (int i = info.length - 1; i >= 0; i--) {
                if (x[i] != y[i]) return y[i] - x[i];
            }
            return 0;
        });
        
        dfs(n, info, 0);
        
        if (pq.isEmpty()) {
            return new int[]{-1};
        } else {
            return pq.poll();
        }
    }
    
    private void dfs(int n, int[] info, int depth) {
        if (depth == info.length) {
            
            if (isLionWin(info, answer)) {
                pq.offer(answer.clone());
            }
            return;
        }
        
        if (n > info[depth]) {
            answer[depth] = info[depth] + 1;
            dfs(n - answer[depth], info, depth + 1);
        }
        
        answer[depth] = 0;
        if (depth == info.length - 1 && n > 0) {
                answer[depth] = n;
            }
        dfs(n - answer[depth], info, depth + 1);
    }
    
    private boolean isLionWin(int[] apeach, int[] lion) {
        int apeachScore = 0;
        int lionScore = 0;
        for (int i = 0; i < apeach.length; i++) {
            if (apeach[i] == 0 && lion[i] == 0) {
                continue;
            }
            
            if (apeach[i] >= lion[i]) {
                apeachScore += (10 - i);
            } else {
                lionScore += (10 - i);
            }
        }
        
        if (lionScore > apeachScore && (lionScore - apeachScore) >= scoreGap) {
            if (lionScore - apeachScore > scoreGap) {
                pq.clear();
                scoreGap = lionScore - apeachScore;
            }
            return true;
        } 
        
        return false;
    }
}