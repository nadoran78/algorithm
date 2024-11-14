import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        List<long[]> list = new ArrayList<>();
        
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long a= line[i][0];
                long b= line[i][1];
                long e= line[i][2];
                
                long c= line[j][0];
                long d= line[j][1];
                long f= line[j][2];
                
                long adbc= a*d-b*c;
                if(adbc==0) continue; //비교대상 직선과 평행함
                
                long bfed= b*f-e*d;
                if(bfed%adbc!=0) continue; //x가 정수가 아님
                
                long ecaf= e*c-a*f;
                if(ecaf%adbc!=0) continue; //y가 정수가 아님
                
                long x = bfed/adbc;
                long y = ecaf/adbc;
                
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);

                list.add(new long[]{x, y});
            
            }
        }
        
        String[] answer = new String[(int) (maxY - minY + 1)];
        for (int i = 0; i < answer.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (long j = minX; j <= maxX; j++) {
                sb.append('.');
            }
            answer[i] = sb.toString();
        }
        
        for (long[] star : list) {
            long x = star[0] - minX;
            long y = maxY - star[1];
            
            String before = answer[(int) y].substring(0, (int) x);
            String after;
            if (x != answer[(int) y].length() - 1) {
                after = answer[(int) y].substring((int) (x + 1), answer[(int) y].length());
            } else {
                after = "";    
            }
            
            answer[(int) y] = before + "*" + after;
        }
        
        return answer;
    }
}