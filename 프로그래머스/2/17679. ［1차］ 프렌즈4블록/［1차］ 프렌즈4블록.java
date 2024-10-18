import java.util.*;

class Solution {
    char[][] newBoard;
    int[] dx, dy;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        newBoard = new char[m][n];
        
        for (int i = 0; i < board.length; i++) {
            newBoard[i] = board[i].toCharArray();
        }
        
        Set<Node> set = new HashSet<>();
        Map<Integer, Set<Node>> map = new HashMap<>();
        
        boolean isEnd = false;
        
        dx = new int[]{0, 0, 1, 1};
        dy = new int[]{0, 1, 0, 1};
        
        while (!isEnd) {
            
            for (int i = 0; i < newBoard.length; i++) {
                for (int j = 0; j < newBoard[i].length; j++) {
                    if (newBoard[i][j] == 'x') {
                        continue;
                    }
                    
                    if (isTwoByTwo(i, j)) {
                        for (int k = 0; k < dx.length; k++) {
                            Node cur = new Node(i + dx[k], j + dy[k]);

                            Set<Node> value =
                                map.getOrDefault(cur.y, new TreeSet<>((a, b) -> a.x - b.x));
                            value.add(cur);
                            map.put(cur.y, value);  
                        }
                        
                    }
                }
            }
            
            if (map.isEmpty()) {
                isEnd = true;
            } else {
                for (Integer key : map.keySet()) {
                    answer += map.get(key).size();
                }
                
                for (int i = 0; i < n; i++) {
                    if (map.get(i) == null) {
                        continue;
                    }
                    
                    for (Node node : map.get(i)) {
                        down(node.x, i);
                    }    
                }
                
                map.clear();
                set.clear();   
            }
        }
        
        return answer;
    }
    
    private void down(int x, int y) {
        for (int i = x; i > 0; i--) {
            newBoard[i][y] = newBoard[i - 1][y];
        }
        newBoard[0][y] = 'x';
    }
    
    private boolean isTwoByTwo(int x, int y) {
        char cur = newBoard[x][y];
        for (int k = 0; k < dx.length; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if (nx < 0 || ny < 0 || nx >= newBoard.length || ny >= newBoard[nx].length) {
                return false;
            }
            
            if (cur != newBoard[nx][ny]) {
                return false;
            }
        }
        return true;
    }
    
    class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}