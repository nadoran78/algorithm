class Solution {
    public int solution(String[] board) {
        int answer = -1;
        
        int oCount = 0;
        int xCount = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char ch = board[i].charAt(j);
                if (ch == 'O') {
                    oCount++;
                } else if (ch == 'X') {
                    xCount++;
                }
            }
        }
        
        if (!(oCount - xCount == 0 || oCount - xCount == 1)) {
            return 0;
        } 
        
        int oBingoCount = 0;
        int xBingoCount = 0;

        for (int i = 0; i < 3; i++) {
            // 가로
            if (board[i].equals("OOO")) {
                oBingoCount++;
            } else if (board[i].equals("XXX")) {
                xBingoCount++;
            }

            if (board[0].charAt(i) == 'O'
                && board[1].charAt(i) == 'O'
                && board[2].charAt(i) == 'O') {
                oBingoCount++;
            } else if (board[0].charAt(i) == 'X'
                && board[1].charAt(i) == 'X'
                && board[2].charAt(i) == 'X') {
                xBingoCount++;
            }
        }

        // 대각선
        if (board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') {
            oBingoCount++;
        }
        if (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O') {
            oBingoCount++;
        }

        if (board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') {
            xBingoCount++;
        }

        if (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X') {
            xBingoCount++;
        }

        if (oBingoCount >= 1 && xBingoCount >= 1) {
            return 0;
        } 

        if (oBingoCount >= 1) {

            if (oCount - xCount != 1) {
                return 0;
            }
        } 

        if (xBingoCount >= 1) {

            if (oCount - xCount != 0) {
                return 0;
            }
        }
        
        
        
        return 1;
    }
}