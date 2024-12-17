import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            String repeat = s.substring(0, i);
            
            int idx = i;
            int count = 1;
            StringBuilder sb = new StringBuilder();
            
            while (idx < s.length()) {
                String check;
                if (idx + i <= s.length()) {
                    check = s.substring(idx, idx + i);
                } else {
                    check = s.substring(idx);
                }
                
                if (repeat.equals(check)) {
                    count++;
                } else {
                    if (count != 1) {
                        sb.append(count).append(repeat);    
                    } else {
                        sb.append(repeat);
                    }
                    
                    count = 1;
                    repeat = check;
                }
                
                idx += i;
            }
            
            if (count != 1) {
                sb.append(count).append(repeat);
            } else {
                sb.append(repeat);
            }
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}