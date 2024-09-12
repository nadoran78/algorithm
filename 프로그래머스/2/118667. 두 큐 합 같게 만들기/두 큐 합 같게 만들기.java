import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long oneSum = 0;
        long twoSum = 0;
        
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            
            oneSum += queue1[i];
            twoSum += queue2[i];
        }
        
        while (answer <= (queue1.length * 3)) {
            
            if (oneSum > twoSum) {
                int cur = q1.poll();
                q2.add(cur);
                
                oneSum -= cur;
                twoSum += cur;
                answer++;
            } else if (oneSum < twoSum) {
                int cur = q2.poll();
                q1.add(cur);
                
                oneSum += cur;
                twoSum -= cur;
                answer++;
            } else {
                return answer;
            }
        }
        
        return -1;
    }
}