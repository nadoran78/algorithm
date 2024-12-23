import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Integer> list = new ArrayList<>();
        
        
        while (k > 1) {
            list.add(k);
            
            if (k % 2 == 0) {
                k = k / 2;
            } else {
                k = k * 3 + 1;
            }
        }
        list.add(k);
        
        int n = list.size() - 1;
        
        double[] areas = new double[201];
        
        for (int i = 1; i < Math.min(areas.length, list.size()); i++) {
            double area = (double) Math.min(list.get(i), list.get(i - 1)) + 
                ((double) Math.abs(list.get(i) - list.get(i - 1)) / 2);
            areas[i] = area;
        }
        
        for (int i = 0; i < ranges.length; i++) {
            int[] range = ranges[i];
            double result = 0.0;
            int end = n + range[1];
            
            if (end < range[0]) {
                result = -1.0;
            } else {
                for (int j = range[0] + 1; j <= end; j++) {
                    result += areas[j];
                }
            }
            
            answer[i] = result;
        }
        
        return answer;
    }
}