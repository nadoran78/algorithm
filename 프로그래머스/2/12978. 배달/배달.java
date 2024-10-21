import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] array = new int[N + 1][N + 1];
        for (int i = 0; i < array.length; i++) {
            Arrays.fill(array[i], Integer.MAX_VALUE);
        }
        
        for (int[] node : road) {
            array[node[0]][node[1]] = Math.min(array[node[0]][node[1]], node[2]);
            array[node[1]][node[0]] = Math.min(array[node[1]][node[0]], node[2]);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.time - y.time);
        pq.add(new Node(1, 0));
        
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        
        Set<Integer> set = new HashSet<>();
        
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            set.add(cur.village);
            
            for (int i = 1; i < array[cur.village].length; i++) {
                
                int time = array[cur.village][i];
                int nextTime = cur.time + time;
                
                if (time != Integer.MAX_VALUE && nextTime < dp[i]) {    
                    dp[i] = nextTime;
                    if (nextTime <= K) {
                        pq.offer(new Node(i, nextTime));
                    }
                }
                
            }
        }

        return set.size();
    }
    
    class Node{
        int village, time;
        public Node(int village, int time) {
            this.village = village;
            this.time = time;
        }
    }
}