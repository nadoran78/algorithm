import java.util.*;

class Solution {
    int[] discount;
    int join = 0;
    int sales = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        
        discount = new int[emoticons.length];
        
        dfs(users, emoticons, 0);
        
        int[] answer = new int[]{join, sales};
        
        return answer;
    }
    
    private void dfs(int[][] users, int[] emoticons, int depth) {
        if (depth == emoticons.length) {
            joinCount(users, emoticons);
            return;
        }
        
        for (int i = 10; i <= 40; i += 10) {
            discount[depth] = i;
            dfs(users, emoticons, depth + 1);
        }
        
    }
    
    private void joinCount(int[][] users, int[] emoticons) {
        int tempJoin = 0;
        int tempSales = 0;
        
        for (int i = 0; i < users.length; i++) {
            int userDiscount = users[i][0];
            int userAmount = users[i][1];
            int amount = 0;
            for (int j = 0; j < discount.length; j++) {
                if (discount[j] >= userDiscount) {
                    amount += emoticons[j] * (100 - discount[j]) / 100;
                }
            }
            
            if (amount >= userAmount) {
                tempJoin++;
            } else {
                tempSales += amount;
            }
        }
        
        if (tempJoin > join) {
            join = tempJoin;
            sales = tempSales;
        } else if (tempJoin == join) {
            if (tempSales > sales) {
                sales = tempSales;
            }
        }
    }
}