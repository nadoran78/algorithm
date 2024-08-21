import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] bookTime = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            for (int j = 0; j < book_time[i].length; j++) {
                String[] split = book_time[i][j].split(":");
            
                int minute = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
                bookTime[i][j] = minute;
            }
        }
        
        Arrays.sort(bookTime, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            }
            return x[0] - y[0];
        });
        
        List<int[]> roomList = new ArrayList<>();
        for (int i = 0; i < bookTime.length; i++) {
            boolean isChange = false;
            for (int j = 0; j < roomList.size(); j++) {
                int endTime = roomList.get(j)[1] + 10;
                
                if (bookTime[i][0] >= endTime) {
                    isChange = true;
                    roomList.set(j, bookTime[i]);
                    break;
                }
            }
            
            if (!isChange) {
                answer++;
                roomList.add(bookTime[i]);
            }
        }
        
        return answer;
    }
}