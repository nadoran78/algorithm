class Solution {
    public long solution(int n) {
        int answer = 0;
        
        long[] dp = new long[n + 1];
        
        dp[2] = 3;
        dp[4] = 11;
        
        if (n > 4) {
            for (int i = 6; i < dp.length; i += 2) {
                long temp = dp[i - 2] * 3 + 2;
                
                for (int j = i - 4; j >= 2; j -= 2) {
                    temp += (dp[j] * 2);
                }
                
                dp[i] = temp % 1000000007;
                
            }
        }
        
        return dp[n];
    }
}