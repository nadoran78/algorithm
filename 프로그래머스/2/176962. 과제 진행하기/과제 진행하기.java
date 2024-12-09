import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.start - y.start);
        
        for (String[] plan : plans) {
            String[] startTime = plan[1].split(":");
            int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            int playTime = Integer.parseInt(plan[2]);
            pq.offer(new Node(plan[0], start, playTime));
        }
        
        Stack<Node> stack = new Stack<>();
        
        Node cur = pq.poll();
        
        while (!pq.isEmpty()) {
            
            Node next = pq.peek();
            
            if (next.start >= cur.start + cur.playTime) {
                int restTime = next.start - (cur.start + cur.playTime);
                result.add(cur.name);
                
                while (!stack.isEmpty() && restTime > 0) {
                    if (stack.peek().playTime <= restTime) {
                        Node pop = stack.pop();
                        restTime -= pop.playTime;
                        result.add(pop.name);
                    } else {
                        stack.peek().playTime -= restTime;
                        restTime = 0;
                    }
                }
            } else {
                cur.playTime -= next.start - cur.start;
                stack.push(cur);
            }
            
            cur = pq.poll();
        }
        
        result.add(cur.name);
        
        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }
        
        return result.toArray(new String[result.size()]);
    }
    
    class Node{
        String name;
        int start;
        int playTime;
        
        public Node(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
}