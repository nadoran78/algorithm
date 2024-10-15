import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Node> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty()) {
                stack.push(new Node(prices[i], i));
                continue;
            }
            
            while (!stack.isEmpty() && prices[i] < stack.peek().price) {
                Node cur = stack.pop();
                answer[cur.idx] = i - cur.idx;
            }
            
            stack.push(new Node(prices[i], i));
        }
        
        int lastIdx = prices.length - 1;
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            answer[cur.idx] = lastIdx - cur.idx;
        }
        
        return answer;
    }
    
    class Node{
        int price, idx;
        public Node(int price, int idx) {
            this.price = price;
            this.idx = idx;
        }
    }
}