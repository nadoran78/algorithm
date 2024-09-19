import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        Map<String, List<Long>> in = new TreeMap<>();
        Map<String, List<Long>> out = new TreeMap<>();
        
        for (String record : records) {
            String[] split = record.split(" ");
            
            long time = 0;
            String[] timeSplit = split[0].split(":");
            time += Integer.parseInt(timeSplit[0]) * 60 + Integer.parseInt(timeSplit[1]);
            
            if (split[2].equals("IN")) {
                List<Long> list = in.getOrDefault(split[1], new ArrayList<>());
                list.add(time);
                in.put(split[1], list);
            } else {
                List<Long> list = out.getOrDefault(split[1], new ArrayList<>());
                list.add(time);
                out.put(split[1], list);
            }
        }
        
        int[] answer = new int[in.size()];
        
        int index = 0;
        for (String key : in.keySet()) {
            List<Long> inTimeList = in.get(key);
            List<Long> outTimeList = out.getOrDefault(key, new ArrayList<>());
            
            if (inTimeList.size() != outTimeList.size()) {
                outTimeList.add((long) 23 * 60 + 59);
            }
            
            long totalTime = 0;
            for (int i = 0; i < inTimeList.size(); i++) {
                totalTime += outTimeList.get(i) - inTimeList.get(i);
            }
            
            answer[index] = calculateFee(totalTime, fees);
            index++;
        }
        
        return answer;
    }
    
    private int calculateFee(long totalTime, int[] fees) {
        int finalFee = 0;
        if (totalTime > fees[0]) {
            totalTime -= fees[0];
            finalFee += fees[1];
            
            int applyTime = (int) Math.ceil((double) totalTime / (double) fees[2]);
            finalFee += fees[3] * applyTime;
        } else {
            return fees[1];
        }
        
        return finalFee;
    }
}