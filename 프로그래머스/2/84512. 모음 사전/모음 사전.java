import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 1;
        String targets = "AEIOU";
        int[] next = new int[]{781, 156, 31, 6, 1};
        char[] words = word.toCharArray();
    
        for(int i = 0; i < words.length; i++){
            char now = words[i];
            int n = targets.indexOf(now);
            answer += n * next[i];
        }
        return answer + words.length - 1;
    }
}
// AAE:34(30 +1)
// AE:158(155 +1)
// E:782(156*5 + 1) 781
