class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for (int i = 1; i <= r2; i++) {
            double tempH2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
            double tempH1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
            
            long h2 = (long) Math.floor(tempH2);
            long h1 = (long) (tempH1 < 0 ? 0 : Math.ceil(tempH1));
            
            answer += h2 - h1 + 1;
        }
        
        return answer * 4;
    }
    
}