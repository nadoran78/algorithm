class Solution {
    int[][] board;
    int[][] t;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] beginning, int[][] target) {
        
        t = target;
        
        board = new int[beginning.length][];
        for (int i = 0; i < beginning.length; i++) {
            board[i] = beginning[i].clone();
        }
        
        dfs(0, 0);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    private void reverseRow(int idx) {
        for (int i = 0; i < board[idx].length; i++) {
            board[idx][i] = (board[idx][i] + 1) % 2;
        }
    }
    
    private int checkCol(int idx) {
        int check = 0;
        for (int i = 0; i < board.length; i++) {
            if (t[i][idx] == board[i][idx]) {
                check++;
            }
        }
        
        if (check == board.length) {
            return 0;
        } else if (check == 0) {
            return 1;
        } else {
            return -1;
        }
    }
    
    private void dfs(int row, int count) {
        if (row == board.length) {
            boolean isPass = true;
            for (int i = 0; i < board[0].length; i++) {
                int temp = checkCol(i);
                if (temp == -1) {
                    isPass = false;
                    break;
                }
                count += temp;
            }
            
            if (isPass) {
                answer = Math.min(answer, count);
            }
            return;
        }
        
        reverseRow(row);
        dfs(row + 1, count + 1);
        
        reverseRow(row);
        dfs(row + 1, count);
        
    }
}