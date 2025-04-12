import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);
        char target = words[0].charAt(words[0].length()-1);
        for(int i=1; i<words.length; i++){
            String word = words[i];
            if(target != word.charAt(0) || hs.contains(word)) {
                answer[0] = (i+1) % n;
                if(answer[0] == 0){
                    answer[0] = n;
                }
                answer[1] = (int)(i / n) + 1;
                break;
            }
            target = word.charAt(word.length()-1);
            hs.add(word);
        }
        return answer;
    }
}