import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        String[] total = new String[31];
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            if (!map.containsKey(clothe[1])) {
                map.put(clothe[1], 1);
                total[count] = clothe[1];
                count++;
            } else {
                map.put(clothe[1], map.get(clothe[1]) + 1);
            }
        }
        answer += map.get(total[0]);
        for (int i = 1; i < count; i++) {
            answer = answer * (map.get(total[i]) + 1);
        }
        answer--;
        
        return answer;
    }
}
