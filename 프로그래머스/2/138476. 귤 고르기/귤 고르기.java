import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<tangerine.length; i++){
            int now = tangerine[i];
            if(hm.containsKey(now)){
                int v = hm.get(now);
                hm.put(now,v+1);
            }else{
                hm.put(now,1);
            }
        }
        List<Integer> list_key = new ArrayList<>(hm.keySet());
        // list_key.sort((o1,o2) -> hm.get(o2).compareTo(hm.get(o1)));
        list_key.sort((o1,o2) -> hm.get(o2)-hm.get(o1));
        int result = k;
        for (int i=0; i<list_key.size(); i++){
            answer += 1;
            result -= hm.get(list_key.get(i));
            if (result <= 0){
                break;
            }
        }
        
        return answer;
    }
}