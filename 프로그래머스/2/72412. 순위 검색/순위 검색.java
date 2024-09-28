import java.util.*;

class Solution {
    
    Map<String, List<Integer>> map;
    List<Integer> score = new ArrayList<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        map = new HashMap<>();
        
        for (String str : info) {
            
            dfs(str.split(" "), 0, "");
        }
        
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        for (int i = 0; i < query.length; i++) {
            String q = query[i];
            
            String[] split = q.split(" and ");
            
            String[] temp = split[3].split(" ");                                 
            split[3] = temp[0];
                                     
            String key = String.join("", split);
            int score = Integer.parseInt(temp[1]);
            
            if (map.containsKey(key)) {
                List<Integer> list = map.get(key);
            
                int left = 0;
                int right = list.size() - 1;

                while (left <= right) {
                    int mid = (right - left) / 2 + left;

                    if (list.get(mid) >= score) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                answer[i] = list.size() - left;
            }
            
            
        }
        
        return answer;
    }
    
    private void dfs(String[] info, int depth, String key) {
        if (depth == 4) {
            if (!map.containsKey(key)) {
                    score = new ArrayList<>();
                    score.add(Integer.parseInt(info[4]));
                    map.put(key, score);
            } else {
                map.get(key).add(Integer.parseInt(info[4]));
            }
            return;
        }
        
        
        dfs(info, depth + 1, key + "-");
        dfs(info, depth + 1, key + info[depth]);
        
    }
}