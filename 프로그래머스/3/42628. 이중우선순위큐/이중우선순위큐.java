import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<operations.length; i++) {
            String[] order = operations[i].split(" ");
            if(order[0].equals("I")) {
                minpq.offer(Integer.parseInt(order[1]));
                maxpq.offer(Integer.parseInt(order[1]));
            }

            else if(!maxpq.isEmpty() && order[1].equals("1")) {
                    minpq.remove(maxpq.poll());
                }
            else if(!minpq.isEmpty() && order[1].equals("-1")) {
                    maxpq.remove(minpq.poll());
                }
        }

        if(minpq.isEmpty() && maxpq.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }
        else
            answer[0] = maxpq.peek() != null ? maxpq.peek() : 0;
            answer[1] = minpq.peek() != null ? minpq.peek() : 0;

        return answer;
    }
}