import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length;
        
        int[][] dp = new int[n][m];
        for (int[] ele : dp) {
            Arrays.fill(ele, -1);
        }
        
        dp[0][0] = 1;
        
        Queue<Node> q = new LinkedList<>();
        
        q.offer(new Node(0, 0));
        
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx < 0 || ny < 0|| nx >= n || ny >= m || maps[nx][ny] == 0) {
                    continue;
                }
                
                if (dp[nx][ny] == -1) {
                    dp[nx][ny] = dp[cur.x][cur.y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        
        return dp[n - 1][m - 1];
    }
    
    class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}