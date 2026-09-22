class Solution {
    private final char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    private String target;
    private int count;
    
    public int solution(String word) {
        target = word;
        dfs("");
        return count;
    }
    
    private boolean dfs(String current) {
        if (current.length() == 5) {
            return false;
        }
        
        for (char vowel : vowels) {
            String next = current + vowel;
            
            count++;
            
            if (next.equals(target)) {
                return true;
            }
            
            if (dfs(next)) {
                return true;
            }
        }
        
        return false;
    }
}