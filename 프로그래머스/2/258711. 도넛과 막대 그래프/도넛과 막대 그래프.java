import java.util.*;

class Solution {
  
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        
        int[] startCount = new int[1000001];
        int[] endCount = new int[1000001];
        for (int i = 0; i < edges.length; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            
            startCount[start]++;
            endCount[end]++;
        }
        
        int newOne = 0;
        int stick = 0;
        int eight = 0;
        int doughnut = 0;
        for (int i = 1; i < startCount.length; i++) {
            if (startCount[i] >= 2 && endCount[i] == 0) {
                newOne = i;
            }
            
            if (startCount[i] >= 2 && endCount[i] >= 1) {
                eight++;
            }
            
            if (startCount[i] == 0 && endCount[i] >= 1) {
                stick++;
            }
        }
        
        doughnut = startCount[newOne] - stick - eight;
        
        answer[0] = newOne;
        answer[1] = doughnut;
        answer[2] = stick;
        answer[3] = eight;
        
        return answer;
    }
    
    
}