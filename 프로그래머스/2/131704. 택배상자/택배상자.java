import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int curIdx = 0;
        int belt = 1;
        Stack<Integer> stack = new Stack<>();
        
        while (curIdx < order.length && belt <= order.length) {
            int cur = order[curIdx];
            stack.push(belt);

            while (!stack.isEmpty() && stack.peek() == cur) {
                answer++;
                curIdx++;
                
                if (curIdx < order.length) {
                  cur = order[curIdx];
                }
                
                stack.pop();
            }

            belt++;
            
        }
        
        return answer;
    }
}