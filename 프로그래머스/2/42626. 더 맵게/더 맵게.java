import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> hq = new PriorityQueue<>();
        for(int i : scoville){
            hq.add(i);
        }
        while(hq.peek() != null){
            if(hq.peek() >= K){
                break;
            }
            int first = hq.poll();
            if(hq.peek() == null){
                answer = -1;
                break;
            }
            int second = hq.poll();
            hq.add(first+second*2);
            answer ++;
        }
        
        return answer;
    }
}