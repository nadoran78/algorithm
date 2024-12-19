import java.util.*;

class Solution {
    int[] pickResult;
    int[][] tired;
    int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        
        int picksTotal = Arrays.stream(picks).sum();
        
        tired = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        pickResult = new int[picksTotal];
        
        dfs(picks, minerals, 0);
        
        return answer;
    }
    
    private void dfs(int[] picks, String[] minerals, int depth) {
        if (depth == pickResult.length) {
            updateTired(minerals);
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                int[] newArray = Arrays.copyOfRange(picks, 0, picks.length);
                newArray[i]--;
                pickResult[depth] = i;
                dfs(newArray, minerals, depth + 1);
            }
        }
    }
    
    private void updateTired(String[] minerals) {
        int totalTired = 0;
        
        int pickIdx = 0;
        int mineralIdx = 0;
        while(pickIdx < pickResult.length && mineralIdx < minerals.length) {
            int pick = pickResult[pickIdx];
            
            int count = 0;
            while (mineralIdx < minerals.length && count < 5) {
                String mineral = minerals[mineralIdx];
                int mineralNumber = 0;
                if (mineral.equals("diamond")) {
                    mineralNumber = 0;
                } else if (mineral.equals("iron")) {
                    mineralNumber = 1;
                } else if (mineral.equals("stone")) {
                    mineralNumber = 2;
                }
                
                totalTired += tired[pick][mineralNumber];
                
                mineralIdx++;
                count++;
            }
            pickIdx++;
        }
        
        answer = Math.min(answer, totalTired);
    }
}