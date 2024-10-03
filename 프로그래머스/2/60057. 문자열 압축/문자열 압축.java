class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            String base = s.substring(0, i);
            
            int left = i;
            int right = Math.min(left + i, s.length());
            int count = 1;
            StringBuilder sb = new StringBuilder();
            
            while (left < s.length()) {
                String compare = s.substring(left, right);
                
                if (base.equals(compare)) {
                    count++;
                } else {
                    if (count >= 2) {
                        sb.append(count);
                    }
                    sb.append(base);
                    base = compare;
                    count = 1;
                }
                
                left += i;
                right = Math.min(right + i, s.length());
            }
        
            
            if (count >= 2) {
                sb.append(count);
            }
            sb.append(base);
            
            answer = Math.min(answer, sb.length());
            
        }
        
        return answer;
    }
    
}