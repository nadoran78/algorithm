import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        String str = s.substring(2, s.length() - 2);
        String[] split1 = str.split("},\\{");
        int[] answer = new int[split1.length];
        
        Arrays.sort(split1, (x, y) -> x.length() - y.length());
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < split1.length; i++) {
            String num = split1[i];
            String[] nums = num.split(",");
            
            for (int j = 0; j < nums.length; j++) {
                int n = Integer.parseInt(nums[j]);
                if (set.contains(n)) {
                    continue;
                }
                
                set.add(n);
                answer[i] = n;
            }
        }
        
        return answer;
    }
}