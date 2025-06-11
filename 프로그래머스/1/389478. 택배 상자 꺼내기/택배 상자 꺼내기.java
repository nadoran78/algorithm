import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        Stack[] stacks = new Stack[w];
        for (int i = 0; i < w; i++) {
            stacks[i] = new Stack<Integer>();
        }
        
        int floor = (int) Math.ceil((double) n / w);
        for (int i = 0; i < floor; i++) {
            int putStart = i * w + 1;
            int putEnd = putStart + w - 1;
            for (int j = 0; j < w; j++) {
                if (i % 2 == 0) {
                    if (putStart <= n) {
                        stacks[j].push(putStart);
                    }
                    putStart++;
                } else {
                    if (putEnd <= n) {
                        stacks[j].push(putEnd);
                    }
                    putEnd--;
                }
            }
        }
        
        for (int i = 0; i < stacks.length; i++) {
            if (stacks[i].contains(num)) {
                while ((int) stacks[i].peek() != num) {
                    stacks[i].pop();
                    answer++;
                }
            }
        }
        
        return answer + 1;
    }
}