import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int[][] board = new int[101][101];
        
        Map<Integer, Integer>[][] mapArray = new Map[101][101];
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[i].length; j++) {
                mapArray[i][j] = new HashMap<>();
            }
        }
        
        for (int[] route : routes) {
            int[] start = points[route[0] - 1];
            mapArray[start[0]][start[1]].put(0, mapArray[start[0]][start[1]].getOrDefault(0, 0) + 1);
            int time = 1;
            for (int i = 1; i < route.length; i++) {
                int[] pre = points[route[i - 1] - 1];
                int[] end = points[route[i] - 1];
                
                // r이동
                int x = pre[0];
                int y = pre[1];
                while (x != end[0]) {
                    if (x < end[0]) {
                        x++;
                    } else if (x > end[0]) {
                        x--;
                    }
                    
                    mapArray[x][y].put(time, mapArray[x][y].getOrDefault(time, 0) + 1);
                    time++;
                }
                
                
                while (y != end[1]) {
                    if (y < end[1]) {
                        y++;
                    } else if (y > end[1]) {
                        y--;
                    }
                    
                    mapArray[x][y].put(time, mapArray[x][y].getOrDefault(time, 0) + 1);
                    time++;
                }
            }
        }
        
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[i].length; j++) {
                for (Integer key : mapArray[i][j].keySet()) {
                    if (mapArray[i][j].get(key) > 1) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}