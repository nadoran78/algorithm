class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] numberCount = new int[10];
        
        for (int num : numbers) {
            numberCount[num]++;
        }
        
        for (int i = 0; i < numberCount.length; i++) {
            if (numberCount[i] == 0) {
                answer += i;
            }
        }
        return answer;
    }
}