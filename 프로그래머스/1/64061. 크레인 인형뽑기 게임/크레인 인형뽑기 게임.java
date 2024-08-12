import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int pick = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][move - 1] != 0) {
                    pick = board[i][move - 1];
                    board[i][move - 1] = 0;
                    break;
                }
            }
            
            if (!stack.isEmpty() && stack.peek() == pick) {
                answer += 2;
                stack.pop();
            } else {
                if (pick != 0) {
                    stack.push(pick);    
                }
            }
        }
        
        return answer;
    }
}