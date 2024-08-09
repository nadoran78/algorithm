class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] left = new int[]{3, 0};
        int[] right = new int[]{3, 2};
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                left[0] = num / 3;
                left[1] = 0;
                sb.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                right[0] = num / 3 - 1;
                right[1] = 2;
                sb.append("R");
            } else {
                int[] numLocation = new int[2];
                numLocation[1] = 1;
                if (num == 0) {
                    numLocation[0] = 3;
                } else {
                    numLocation[0] = num / 3;
                }
                
                int leftGap = 
                    Math.abs(numLocation[1] - left[1]) + Math.abs(numLocation[0] - left[0]);
                int rightGap = 
                    Math.abs(numLocation[1] - right[1]) + Math.abs(numLocation[0] - right[0]);
                
                if (leftGap > rightGap) {
                    sb.append("R");
                    right[0] = numLocation[0];
                    right[1] = numLocation[1];
                } else if (rightGap > leftGap) {
                    sb.append("L");
                    left[0] = numLocation[0];
                    left[1] = numLocation[1];
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        right[0] = numLocation[0];
                        right[1] = numLocation[1];
                    } else {
                        sb.append("L");
                        left[0] = numLocation[0];
                        left[1] = numLocation[1];
                    }
                }
            }
        }
        
        return sb.toString();
    }
}