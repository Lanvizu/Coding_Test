import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
         StringBuilder result = new StringBuilder();

        for (int a : ingredient) {
            result.append(a);
            if (result.length() > 3 
                && result.subSequence(result.length() - 4, result.length()).equals("1231")) {
                answer++;
                result.delete(result.length() - 4, result.length());
            }
        }
        return answer;
    }
}