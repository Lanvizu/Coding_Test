import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Queue<Integer> q = new LinkedList<>();

        for (int i : prices) {
            q.add(i);
        }

        int count = 0;
        while (q.peek() != null) {
            int poll = q.poll();
            answer[count] = 0;

            for (Integer i : q) {
                answer[count]++;
                if (i < poll) {
                    break;
                }
            }
            count++;
        }
        return answer;
    }
}