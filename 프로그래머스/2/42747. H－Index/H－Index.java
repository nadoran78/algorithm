import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Integer[] array = new Integer[citations.length];
        
        for (int i = 0; i < citations.length; i++) {
            array[i] = (Integer) citations[i];
        }
        
        Arrays.sort(array, (o1, o2) -> o2 - o1);
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] < i + 1) {
                return i;
            }
        }
        
        return array.length;
    }
}