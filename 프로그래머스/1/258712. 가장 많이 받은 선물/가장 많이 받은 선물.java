import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] score = new int[friends.length][friends.length];
        
        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            String from = temp[0];
            String to = temp[1];
            
            int x = 0;
            int y = 0;
            for (int i = 0; i < friends.length; i++) {
                
                if (friends[i].equals(from)) {
                    x = i;
                }
                
                if (friends[i].equals(to)) {
                    y = i;
                }
            }
            
            score[x][y]++;
        }
        
        int[] index = new int[friends.length];
        for (int i = 0; i < index.length; i++) {
            int give = Arrays.stream(score[i]).sum();
            int recive = 0;
            for (int j = 0; j < score.length; j++) {
                recive += score[j][i];
            }
            index[i] = give - recive;
        }
        
        for (int i = 0; i < score.length; i++) {
            int sum = 0;
            for (int j = 0; j < score[i].length; j++) {
                if (i == j) {
                    continue;
                }
                
                if (score[i][j] > score[j][i]) {
                    sum++;
                } else if (score[i][j] == score[j][i]) {
                    if (index[i] > index[j]) {
                        sum++;
                    }
                }
            }
            answer = Math.max(answer, sum);
            
        }
        
        return answer;
    }
}