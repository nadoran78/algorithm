import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                    continue;   
                }
            }
            stack.push(c);
        }
        
        return stack.size() == 0;
    }
}