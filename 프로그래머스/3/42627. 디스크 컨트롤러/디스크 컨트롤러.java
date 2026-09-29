import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<Job>((o1, o2) -> {
            int first = Integer.compare(o1.workTime, o2.workTime);
            if (first == 0) {
                int second = Integer.compare(o1.requestTime, o2.requestTime);
                if (second == 0) {
                    return Integer.compare(o1.index, o2.index);
                }
                return second;
            }
            return first;
        });
        PriorityQueue<Job> q = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.requestTime, o2.requestTime);
        });
        
        for (int i = 0; i < jobs.length; i++) {
            int[] job = jobs[i];
            Job newJob = new Job(i, job[0], job[1]);
            
            q.offer(newJob);
        }
        
        int result = 0;
        int currentTime = 0;
        int completedCount = 0;
        while (completedCount < jobs.length) {
            while (!q.isEmpty() && q.peek().requestTime <= currentTime) {
                pq.offer(q.poll());
            }
            
            if (pq.isEmpty()) {
                currentTime = q.peek().requestTime;
                continue;
            }
            
            Job currentJob = pq.poll();
            currentTime += currentJob.workTime;

            result += currentTime - currentJob.requestTime;
            completedCount++;
        }
        
        return result / jobs.length;
    }
    
    private static class Job{
        final int index;
        final int requestTime;
        final int workTime;
        
        Job(int index, int requestTime, int workTime) {
            this.index = index;
            this.requestTime = requestTime;
            this.workTime = workTime;
        }
    }
}