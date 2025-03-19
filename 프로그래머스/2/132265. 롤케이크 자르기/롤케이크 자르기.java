import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> cake1 = new HashMap<>();
        Map<Integer,Integer> cake2 = new HashMap<>();
        
        int cnt = 0;
        for(int i=0; i<topping.length; i++){
            int t = topping[i];
            cake2.put(t, cake2.getOrDefault(t, 0)+1);
        }
        
        for(int i=0; i<topping.length; i++){
            int t = topping[i];
            cake1.put(t, cake1.getOrDefault(t, 0)+1);
            
            if(cake2.containsKey(t)){
                if(cake2.get(t) == 1){
                    cake2.remove(t);
                }else{
                    cake2.put(t, cake2.getOrDefault(t, 0)-1);
                }
            }
            if(cake1.keySet().size()==cake2.keySet().size()){
                answer += 1;
            }
        }
        return answer;
    }
}