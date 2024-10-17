import java.util.*;

class Solution {
    PriorityQueue<Node> cache;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        cache = new PriorityQueue<>((x, y) -> {
            return x.idx - y.idx;
        });
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase();
            
            if (find(city, i)) {
                answer++;
            } else {
                if (cache.size() == cacheSize) {
                    cache.poll();
                } 
                cache.offer(new Node(i, city));
                answer += 5;
            }
        }
        
        return answer;
    }
    
    private boolean find(String city, int idx) {
        for (Node node : cache) {
            if (node.city.equals(city)) {
                cache.remove(node);
                
                node.idx = idx;
                cache.offer(node);
                return true;
            }
        }
        
        return false;
    }
    
    class Node{
        int idx;
        String city;
        public Node(int idx, String city) {
            this.idx = idx;
            this.city = city;
        }
    }
}