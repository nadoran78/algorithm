import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        Queue<Node> q = new LinkedList<>();
        
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
            q.offer(new Node(i, priorities[i]));
        }
        
        while (!pq.isEmpty()) {
            int priority = pq.poll();
            
            while (q.peek().priority < priority) {
                q.offer(q.poll());
            }
            
            Node cur = q.poll();
            answer++;
            if (cur.idx == location) {
                return answer;
            }
            
        }
        
        return answer;
    }
    
    class Node {
        int idx, priority;
        
        public Node(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
}