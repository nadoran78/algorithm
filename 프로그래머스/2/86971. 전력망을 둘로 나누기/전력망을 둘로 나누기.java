class Solution {
    boolean[][] array;
    boolean[] visited;
    int nodeCount = 0;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        array = new boolean[n + 1][n + 1];
        
        for (int[] wire : wires) {
            array[wire[0]][wire[1]] = true;
            array[wire[1]][wire[0]] = true;
        }
        
        for (int[] wire : wires) {
            array[wire[0]][wire[1]] = false;
            array[wire[1]][wire[0]] = false;
            
            visited = new boolean[n + 1];
            nodeCount = 0;
            nodeCounter(wire[0]);
            int leftNode = nodeCount;
            nodeCount = 0;
            nodeCounter(wire[1]);
            int rightNode = nodeCount;
            
            int gap = Math.abs(leftNode - rightNode);
            answer = Math.min(answer, gap);
            
            array[wire[0]][wire[1]] = true;
            array[wire[1]][wire[0]] = true;
        }
        
        return answer;
    }
    
    private void nodeCounter(int start) {
        visited[start] = true;
        nodeCount++;
        boolean[] cur = array[start];
        
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] && !visited[i]) {
                nodeCounter(i);
            }
        }
    }
}