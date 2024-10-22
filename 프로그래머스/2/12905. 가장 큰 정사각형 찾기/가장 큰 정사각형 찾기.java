import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        
        int[][] dp = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            dp[i] = new int[board[i].length];
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = 1;
                    
                    int ni = i - 1;
                    int nj = j - 1;
                    
                    if (ni < 0 || nj < 0) {
                        answer = Math.max(answer, dp[i][j]);
                        continue;
                    }
                    
                    dp[i][j] = dp[i][j] + Math.min(dp[ni][nj], Math.min(dp[i][nj], dp[ni][j]));
            
                    
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        
        return answer * answer;

    }
    
}