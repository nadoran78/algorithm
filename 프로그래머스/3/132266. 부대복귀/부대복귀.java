import java.util.*;

class Solution {
    List<List<Integer>> graph = new ArrayList<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[destination] = 0;
    
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
            
        pq.offer(new Node(destination, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int next : graph.get(cur.value)) {
                if (dp[next] > cur.distance + 1) {
                    dp[next] = cur.distance + 1;
                    pq.offer(new Node(next, dp[next]));
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            int source = sources[i];
            answer[i] = dp[source] == Integer.MAX_VALUE ? -1 : dp[source];
        }
        
        return answer;
    }
    
    class Node {
        int value, distance;
        public Node(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }
    }
}