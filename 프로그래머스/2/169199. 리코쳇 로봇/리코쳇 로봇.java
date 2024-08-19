import java.util.*;

class Solution {
    public int solution(String[] board) {
        
        int n = board.length;
        int m = board[0].length();
        int[] start = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        
        boolean[][] visited = new boolean[n][m];
        visited[start[0]][start[1]] = true;
        
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            
            int[] cur = q.poll();
            
            if (board[cur[0]].charAt(cur[1]) == 'G') {
                return cur[2];
            }
            
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                while (true) {
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx].charAt(ny) == 'D') {
                        break;
                    }
                    
                    nx += dx[i];
                    ny += dy[i];
                }
                
                nx -= dx[i];
                ny -= dy[i];
                
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        return -1;
    }
}