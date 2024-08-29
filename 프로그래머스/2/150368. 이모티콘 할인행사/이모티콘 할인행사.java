class Solution {
    int[] applyDiscount;
    int[] answer;
    int[] discount;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        
        discount = new int[]{10, 20, 30, 40};
        
        applyDiscount = new int[emoticons.length];
        
        
        dfs(users, emoticons, 0);
        
        return answer;
    }
    
    private void dfs(int[][] users, int[] emoticons, int idx) {
        if (idx == emoticons.length) {
            int plusJoin = 0;
            int total = 0;
            for (int[] user : users) {
                int sum = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    if (applyDiscount[i] >= user[0]) {
                        sum += emoticons[i] * (100 - applyDiscount[i]) / 100;
                    }
                }
                
                if (sum >= user[1]) {
                    plusJoin++;
                } else {
                    total += sum;
                }
                
            }
            
            if (plusJoin > answer[0]) {
                answer[0] = plusJoin;
                answer[1] = total;
            } else if (plusJoin == answer[0] && total > answer[1]) {
                answer[1] = total;
            }
            return;
        }
        
        for (int i = 0; i < discount.length; i++) {
            applyDiscount[idx] = discount[i];
            dfs(users, emoticons, idx + 1);
        }
    }
}