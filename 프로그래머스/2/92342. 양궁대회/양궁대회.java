import java.util.*;

class Solution {
    int[] lion;
    int[] answer;
    int gap = 0;
    public int[] solution(int n, int[] info) {
        answer = new int[]{-1};
        
        lion = new int[info.length];
        
        dfs(n, info, 0);
        return answer;
    }
    
    private void dfs(int n, int[] info, int idx) {
        if (idx == info.length) {
            int apeachScore = 0;
            int lionScore = 0;
            
            for (int i = 0; i < info.length; i++) {
                if (info[i] != 0 && info[i] >= lion[i]) {
                    apeachScore += 10 - i;
                } else if (lion[i] != 0 && lion[i] > info[i]) {
                    lionScore += 10 - i;
                }
            }
            
            if (lionScore > apeachScore && lionScore - apeachScore == gap) {
                gap = lionScore - apeachScore;
                if (answer.length != 1) {
                
                    for (int i = lion.length - 1; i >= 0; i--) {
                        if (lion[i] > answer[i]) {
                            answer = Arrays.copyOf(lion, lion.length);
                            break;
                        } else if (lion[i] < answer[i]) {
                            break;
                        }
                    }
                } else {
                    answer = Arrays.copyOf(lion, lion.length);
                }
            } else if (lionScore > apeachScore && lionScore - apeachScore > gap) {
                gap = lionScore - apeachScore;
                answer = Arrays.copyOf(lion, lion.length);
            }
            return;
        }
        
        if (info[idx] < n) {
            lion[idx] = info[idx] + 1;
            dfs(n - lion[idx], info, idx + 1);
        }
        
        lion[idx] = 0;
        if (idx == info.length - 1 && n > 0) {
            lion[idx] = n;    
        }
        dfs(n - lion[idx], info, idx + 1);
    }
}