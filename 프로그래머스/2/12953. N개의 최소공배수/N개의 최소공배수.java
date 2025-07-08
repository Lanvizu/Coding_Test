import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        HashMap<Integer, Integer> hs = new HashMap<>();
        for(int a: arr){
            HashMap<Integer, Integer> result = calcNum(a);
            for(int b: result.keySet()){
                if(hs.getOrDefault(b, 0) < result.get(b)){
                    hs.put(b, result.get(b));
                }
            }
        }
        for(int a: hs.keySet()){
            answer *= Math.pow(a, hs.get(a));
        }
        return answer;
    }
    
    public HashMap<Integer,Integer> calcNum(int a){
        HashMap<Integer, Integer> hs = new HashMap<>();
        int target = (int)Math.pow(a, 0.5);
        for(int i=2; i<=target;){
            if(a % i == 0){
                a /= i;
                hs.put(i, hs.getOrDefault(i, 0) + 1);
                continue;
            }
            i++;
        }
        hs.put(a, hs.getOrDefault(a, 0) + 1);
        return hs;
    }
}