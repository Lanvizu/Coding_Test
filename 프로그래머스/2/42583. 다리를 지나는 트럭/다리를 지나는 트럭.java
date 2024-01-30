import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitQ = new LinkedList<>();
        Queue<Integer> progressQ = new LinkedList<>();
        Queue<Integer> timeQ = new LinkedList<>();
        int count = 0;
        int truckCount = 0;
        int w = 0;
        int totalCount = 0;

        for (int i = 0; i < truck_weights.length; i++) {
                waitQ.offer(truck_weights[i]);
        }

        while (totalCount != truck_weights.length) {
            count++;
            if (timeQ.peek() != null && timeQ.peek() == bridge_length) {
                timeQ.poll();
                w -= progressQ.poll();
                truckCount -= 1;
                totalCount++;
            }

            if (waitQ.peek() != null) {
                int truck = waitQ.peek();
                if (truck + w <= weight && truckCount <= bridge_length) {
                    w += truck;
                    truckCount++;
                    progressQ.add(waitQ.poll());
                    timeQ.add(0);
                }
            }
            for (int i = 0; i < timeQ.size(); i++) {
                timeQ.add(timeQ.poll() + 1);
            }
        }

        return count;
    }
}