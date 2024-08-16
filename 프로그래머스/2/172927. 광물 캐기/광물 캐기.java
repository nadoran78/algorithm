import java.util.*;

class Solution {
    int[] pickOrder;
    int[] mineralNumbers;
    int[][] fatigue;
    int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        
        fatigue = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        pickOrder = new int[Arrays.stream(picks).sum()];
        mineralNumbers = new int[minerals.length];
        for (int i = 0; i < minerals.length; i++) {
            String mineral = minerals[i];
            if (mineral.equals("diamond")) {
                mineralNumbers[i] = 0;
            } else if (mineral.equals("iron")) {
                mineralNumbers[i] = 1;
            } else if (mineral.equals("stone")) {
                mineralNumbers[i] = 2;
            }
        }
        
        dfs(picks, 0);
        
        return answer;
    }
    
    private void dfs(int[] picks, int depth) {
        if (depth == pickOrder.length) {
            int sum = 0;
            int idx = 0;
            for (int pick : pickOrder) {
                if (idx >= mineralNumbers.length) {
                    continue;
                }
                
                for (int i = idx; i < Math.min(idx + 5, mineralNumbers.length); i++) {
                    sum += fatigue[pick][mineralNumbers[i]];
                }
                idx += 5;
            }
            answer = Math.min(sum, answer);
            return;
        }
        
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) {
                pickOrder[depth] = i;
                picks[i]--;
                dfs(picks, depth + 1);
                picks[i]++;
            }
        }
    }
}