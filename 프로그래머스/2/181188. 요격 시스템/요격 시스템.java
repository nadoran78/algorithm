import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        
        for (int[] target: targets) {
            pq.offer(target);
        }
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int maxStart = cur[0];
            
            while (!pq.isEmpty() && pq.peek()[1] > maxStart) {
                maxStart = Math.max(pq.poll()[0], maxStart);
            }
            
            answer++;
        }
        
        return answer;
    }
}