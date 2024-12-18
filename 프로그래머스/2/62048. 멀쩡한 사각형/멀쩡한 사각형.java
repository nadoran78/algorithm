class Solution {
    public long solution(int w, int h) {
        long answer = (long) w * h;
        long minus = 0;
        
        if (w == h) {
            return answer - (long) w;
        }
        
        double preY = 0.0;
        for (int i = 1; i <= w; i++) {
            double curY = ((double)h * (double) i / (double)w);
            
            minus += (long) Math.ceil(curY) - Math.floor(preY);
            preY = curY;
        }
        
        return answer - minus;
    }
}