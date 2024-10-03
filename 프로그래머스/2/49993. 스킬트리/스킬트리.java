import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < skill.length(); i++) {
            set.add(skill.charAt(i));
        }
        
        for (String skillTree : skill_trees) {
            StringBuilder sb = new StringBuilder();
            boolean isPass = true;
            for (int i = 0; i < skillTree.length(); i++) {
                if (set.contains(skillTree.charAt(i))) {
                    sb.append(skillTree.charAt(i));
                }
                
                if (!skill.startsWith(sb.toString())) {
                    isPass= false;
                    break;
                }
            }
            
            if (isPass) {
                answer++;
            }
        }
        return answer;
    }
}