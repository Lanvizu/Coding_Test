import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);
        for(int i=1; i<words.length; i++){
            String now = words[i];
            String prev = words[i-1];
            if(hs.contains(now) 
               || prev.charAt(prev.length()-1) != now.charAt(0)){
                return new int[]{(i % n) + 1, (i / n) + 1};
            }
            hs.add(now);
        }
        return new int[]{0, 0};
    }
}