import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        
        int[] sum = new int[m];
        
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (land[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    
                    Queue<int[]> q = new LinkedList<>();
                    Set<Integer> set = new HashSet<>();
                    int total = 0;
                    
                    q.offer(new int[]{i, j, 1});
                    
                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        total++;
                        set.add(cur[1]);
                        
                        for (int k = 0; k < dx.length; k++) {
                            int nx = cur[0] + dx[k];
                            int ny = cur[1] + dy[k];
                            
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m || land[nx][ny] == 0) {
                                continue;
                            }
                            
                            if (!visited[nx][ny]) {
                                visited[nx][ny] = true;
                                q.offer(new int[]{nx, ny, cur[2] + 1});
                            }
                        }
                    }
                    
                    for (Integer idx : set) {
                        sum[idx] += total;
                        answer = Math.max(answer, sum[idx]);
                    }
                }
                
            }
        }
        
        return answer;
    }
}