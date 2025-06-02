import java.util.*;
class Solution {
    class Data {
        int value;
        int index;

        Data (int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        int n = stones.length;
        Deque<Data> dq = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            int s = stones[i];
            
            while(!dq.isEmpty() && i - dq.peekFirst().index >= k){
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && s > dq.peekLast().value){
                dq.pollLast();
            }
            dq.addLast(new Data(s, i));
            
            if(i >= k-1){
                answer = Math.min(answer, dq.peekFirst().value);
            }
        }
        if (answer == Integer.MAX_VALUE) return 0;
        return answer;
    }
}