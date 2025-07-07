import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i = 0; i < enemy.length; i++){
            if(n >= enemy[i]){
                n -= enemy[i];
                maxHeap.add(enemy[i]);
            } else {
                if(k > 0){
                    k--;
                    if(!maxHeap.isEmpty() && maxHeap.peek() > enemy[i]){
                        int largest = maxHeap.poll();
                        n += largest - enemy[i];
                        maxHeap.add(enemy[i]);
                    }
                } else {
                    return i;
                }
            }
        }
        return enemy.length;
    }
}