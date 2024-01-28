
import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int []arr) {
        
//         StringBuilder builder = new StringBuilder();
//         int x = arr[0];
//         for (int i = 1; i < arr.length; i++) {
//             if (x != arr[i]) {
//                 builder.append(x);
//                 x = arr[i];
//             }
//         }
//         builder.append(arr[arr.length - 1]);

//         String[] split = builder.toString().split("");
//         int[] answer = new int[split.length];
//         for (int i = 0; i < split.length; i++) {
//             answer[i] = Integer.parseInt(split[i]);
//         }
int[] answer = IntStream.range(0, arr.length)
                .filter(i -> i == 0 || arr[i - 1] != arr[i])
                .map(i -> arr[i])
                .toArray();
        return answer;
    }
}