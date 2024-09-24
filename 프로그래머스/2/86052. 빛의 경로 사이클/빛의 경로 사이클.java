import java.util.*;

class Solution {
    boolean[][][] visited;
    int[] directions;
    int n, m;
    public int[] solution(String[] grid) {
        
        n = grid.length;
        m = grid[0].length();
        visited = new boolean[n][m][4];
        directions = new int[]{0, 90, 180, 270};
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < directions.length; k++) {
                    if (!visited[i][j][k]) {
                        result.add(bfs(i, j, directions[k], grid));    
                    }
                }
            }
        }
        
        return result.stream().sorted().mapToInt(x -> x).toArray();
        
    }
    
    private int bfs(int x, int y, int direction, String[] grid) {
        Queue<Light> q = new LinkedList<>();
        
        q.add(new Light(x, y, direction, 0));

        while (!q.isEmpty()) {
            Light cur = q.poll();

            int nx = 0;
            int ny = 0;
            int nDirection = 0;
            if (cur.direction == 0) {
                nx = cur.x;
                ny = cur.y - 1 < 0 ? m - 1 : cur.y - 1;
            } else if (cur.direction == 90) {
                nx = cur.x - 1 < 0 ? n - 1 : cur.x - 1;
                ny = cur.y;
            } else if (cur.direction == 180) {
                nx = cur.x;
                ny = (cur.y + 1) % m;
            } else if (cur.direction == 270) {
                nx = (cur.x + 1) % n;
                ny = cur.y;
            }
            

            if (grid[nx].charAt(ny) == 'L') {
                nDirection = cur.direction - 90;
                nDirection = nDirection < 0 ? 360 + nDirection : nDirection;
            } else if (grid[nx].charAt(ny) == 'R') {
                nDirection = cur.direction + 90;
                nDirection = nDirection >= 360 ? 0 : nDirection;
            } else {
                nDirection = cur.direction;
            }

            if (visited[nx][ny][nDirection / 90]) {
                return cur.count;
            } else {
                visited[nx][ny][nDirection / 90] = true;
                q.add(new Light(nx, ny, nDirection, cur.count + 1));
            }
        }
        return 0;
    }
    
    class Light{
        int x, y, direction;
        int count;
        public Light(int x, int y, int direction, int count) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.count = count;
        }
    }
}