import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int deliverySum = Arrays.stream(deliveries).sum();
        int pickupSum = Arrays.stream(pickups).sum();
        
        int lastIdx = n - 1;

        while (deliverySum != 0 || pickupSum != 0) {
            boolean isMostLong = true;

            int delivery = Math.min(cap, deliverySum);
            int pickup = Math.min(cap, pickupSum);

            deliverySum -= delivery;
            pickupSum -= pickup;

            for (int i = lastIdx; i >= 0; i--) {
                if (deliveries[i] == 0 && pickups[i] == 0) {
                    continue;
                }

                if (isMostLong) {
                    answer += (i + 1) * 2L;
                    isMostLong = false;
                    lastIdx = i;
                }

                if (deliveries[i] >= delivery) {
                    deliveries[i] = deliveries[i] - delivery;
                    delivery = 0;
                } else {
                    delivery -= deliveries[i];
                    deliveries[i] = 0;
                }

                if (pickups[i] >= pickup) {
                    pickups[i] = pickups[i] - pickup;
                    pickup = 0;
                } else {
                    pickup -= pickups[i];
                    pickups[i] = 0;
                }

                if (pickup == 0 && delivery == 0) {
                    break;
                }
            }
        }
        return answer;
    }
}