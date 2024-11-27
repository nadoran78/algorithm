import java.util.*;

class Solution {
    
    public int solution(String name) {
        int answer = 0;
        
        int downSide = 'Z' + 1;
        int upSide = 'A';
        
        int leftRight = name.length() - 1;
        
        for (int i = 0; i < name.length(); i++) {
            int ch = name.charAt(i);
            answer += Math.min(downSide - ch, ch - upSide);
            
            int index = i + 1;
            while (index < name.length() && name.charAt(index) == 'A') {
                index++;
            }
            
            leftRight = Math.min(leftRight, i * 2 + (name.length() - index));
            
            leftRight = Math.min(leftRight, (name.length() - index) * 2 + i);
        }
        
        return answer + leftRight;
    }
    
    

}