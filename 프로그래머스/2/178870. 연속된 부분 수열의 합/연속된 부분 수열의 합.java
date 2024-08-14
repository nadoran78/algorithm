class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int left = 0;
        int right = 0;
        
        int minLength = Integer.MAX_VALUE;
        int sum = sequence[0];
        while (left <= right && left < sequence.length) {
            
            if (sum > k) {
                sum -= sequence[left];
                left++;
            } else if (sum <= k) {
                if (sum == k && right - left < minLength) {
                    answer[0] = left;
                    answer[1] = right;
                    minLength = right - left;
                }
                right++;
                if (right < sequence.length) {
                    sum += sequence[right];    
                } else {
                    sum -= sequence[left];
                    left++;
                }
            }
        }
        return answer;
    }
}