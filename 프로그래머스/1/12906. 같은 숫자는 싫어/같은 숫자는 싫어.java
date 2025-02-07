import java.util.*;
import java.io.*;
public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answerList = new ArrayList<>();
        int len = arr.length;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < len; i++){
            int now = arr[i];
            if(!hs.contains(now)){
                hs.clear();
                hs.add(now);
                answerList.add(now);
            }
        }
        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}