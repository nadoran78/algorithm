import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i = 0; i < answers.length; i++) {
            int firstIndex = i % first.length;
            int secondIndex = i % second.length;
            int thirdIndex = i % third.length;
            
            int answer = answers[i];
            if (answer == first[firstIndex]) {
                scores[0]++;
            }
            
            if (answer == second[secondIndex]) {
                scores[1]++;
            }
            
            if (answer == third[thirdIndex]) {
                scores[2]++;
            }
        }
        
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                list.add(i + 1);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}