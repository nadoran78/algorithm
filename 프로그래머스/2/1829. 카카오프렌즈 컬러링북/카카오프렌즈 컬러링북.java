import java.util.*;

class Solution {
    int[][] board;
    boolean[][] visited;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    int M, N;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        M = m;
        N = n;
        
        board = picture;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    int temp = bfs(picture[i][j], i, j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, temp);
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private int bfs(int color, int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        
        q.offer(new int[]{startX, startY});
        
        visited[startX][startY] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;
            
            for (int i = 0; i < dx.length; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= M || ny >= N || board[nx][ny] == 0) {
                    continue;
                }
                
                if (!visited[nx][ny] && board[nx][ny] == color) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return count;
    }
}