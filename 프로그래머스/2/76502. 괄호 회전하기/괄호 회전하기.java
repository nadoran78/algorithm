import java.util.*;

class Solution {
    int n;
    public int solution(String s) {
        int answer = 0;
        
        n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (isCorrect(i, s)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean isCorrect(int i, String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int j = i; j < n + i; j++) {
            int idx = j % n;

            if (stack.isEmpty()) {
                if (s.charAt(idx) == '(' || s.charAt(idx) == '[' || s.charAt(idx) == '{') {
                    stack.push(s.charAt(idx));
                } else {
                    return false;
                }
            } else {
                if (s.charAt(idx) == '(' || s.charAt(idx) == '[' || s.charAt(idx) == '{') {
                    stack.push(s.charAt(idx));
                } else {
                    if (
                        (s.charAt(idx) == ')' && stack.peek() == '(') ||
                        (s.charAt(idx) == ']' && stack.peek() == '[') ||
                        (s.charAt(idx) == '}' && stack.peek() == '{')
                       ) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    
                    
                }
            }
        }
        
        return stack.isEmpty();
        
        
    }
}