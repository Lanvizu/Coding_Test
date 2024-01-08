import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("R", 0);
        hashMap.put("T", 0);
        hashMap.put("C", 0);
        hashMap.put("F", 0);
        hashMap.put("J", 0);
        hashMap.put("M", 0);
        hashMap.put("A", 0);
        hashMap.put("N", 0);

        for (int i = 0; i < choices.length; i++) {
            if (choices[i] > 4) {
                hashMap.merge(survey[i].split("")[1], choices[i] - 4, Integer::sum);
            } else if (choices[i] < 4) {
                hashMap.merge(survey[i].split("")[0], 4 - choices[i], Integer::sum);
            }
        }
        StringBuilder result = new StringBuilder();

        if (hashMap.get("R") >= hashMap.get("T")) {
            result.append("R");
        } else if (hashMap.get("R") < hashMap.get("T")) {
            result.append("T");
        }
        if (hashMap.get("C") >= hashMap.get("F")) {
            result.append("C");
        } else if (hashMap.get("C") < hashMap.get("F")) {
            result.append("F");
        }
        if (hashMap.get("J") >= hashMap.get("M")) {
            result.append("J");
        } else if (hashMap.get("J") < hashMap.get("M")) {
            result.append("M");
        }
        if (hashMap.get("A") >= hashMap.get("N")) {
            result.append("A");
        } else if (hashMap.get("A") < hashMap.get("N")) {
            result.append("N");
        }
        answer = result.toString();
        return answer;
    }
}