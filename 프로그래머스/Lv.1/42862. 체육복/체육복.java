import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int count = 0;
        Arrays.sort(lost);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j : reserve) {
            hashMap.put(j, 0);
        }
        for (int j = 0; j < lost.length; j++) {
            if (hashMap.containsKey(lost[j])) {
                hashMap.remove(lost[j]);
                lost[j] = -1;
                count++;
            }
        }
        for (int j : lost) {
            if (hashMap.containsKey(j - 1)) {
                hashMap.remove(j - 1);
                count++;
            } else if (hashMap.containsKey(j + 1)) {
                hashMap.remove(j + 1);
                count++;
            }
        }
        answer = n - lost.length + count;
        return answer;
    }
}