import java.util.*;

class Solution {
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            if (bfs(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private boolean bfs(String[] place) {
        List<int[]> players = new ArrayList<>();
        
        int n = place.length;
        int m = place[0].length();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (place[i].charAt(j) == 'P') {
                    players.add(new int[]{i, j, 0});
                }
            }
        }
        
        for (int[] player : players) {
            Queue<int[]> q = new LinkedList<>();
            
            q.add(player);
            
            boolean[][] visited = new boolean[n][m];
            visited[player[0]][player[1]] = true;
            
            while(!q.isEmpty()) {
                int[] cur = q.poll();

                for (int i = 0; i < dx.length; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    int nDistance = cur[2] + 1;

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    
                    if (place[nx].charAt(ny) == 'X') {
                        continue;
                    }
                    
                    if (!visited[nx][ny] && nDistance <= 2) {
                        if (place[nx].charAt(ny) == 'P') {
                            return false;
                        }
                        
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, nDistance});
                    }
                }
            }
        }
        
        return true;
    }
}