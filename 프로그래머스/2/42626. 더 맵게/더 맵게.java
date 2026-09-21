import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : scoville) {
            pq.add(num);
        }
        
        int min = pq.poll();
        int count = 0;
        while (min < K) {
            if (pq.isEmpty()) {
                return -1;
            }
            int nextMin = pq.poll();
            
            pq.add(min + nextMin * 2);
            
            min = pq.poll();
            count++;
        }
        
        return count;
    }
}