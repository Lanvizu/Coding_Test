import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            hashMap.merge(participant[i], 1, Integer::sum);
            hashMap.merge(completion[i], -1, Integer::sum);
        }
        hashMap.merge(participant[participant.length - 1], 1, Integer::sum);

        for (String s : participant) {
            if (hashMap.get(s) == 1) {
                answer = s;
                break;
            }
        }
        return answer;
    }
}