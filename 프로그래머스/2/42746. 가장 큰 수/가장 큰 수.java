import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] array = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(array, (o1, o2) -> {
            String fs = o1 + o2;
            String sf = o2 + o1;
            
            return sf.compareTo(fs);
        });
        
        if (array[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String str : array) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}