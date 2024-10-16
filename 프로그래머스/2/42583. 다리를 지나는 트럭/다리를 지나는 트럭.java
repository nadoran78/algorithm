import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        int idx = 0;
        int sum = 0;
        
        while (idx < truck_weights.length) {
            
            if (q.size() == bridge_length) {
                sum -= q.poll();
            } else {
                if (sum + truck_weights[idx] <= weight) {
                    q.offer(truck_weights[idx]);
                    sum += truck_weights[idx];
                    
                    idx++;
                } else {
                    q.offer(0);
                }
                
                time++;
            }
        }
        return time + bridge_length;
    }
}