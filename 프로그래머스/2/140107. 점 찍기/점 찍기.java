class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (int i = 0; i <= d; i += k) {
            double y = Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            
            int count = (int) (y / k) + 1;
            
            answer += (long) count;
        }
        return answer;
    }
}