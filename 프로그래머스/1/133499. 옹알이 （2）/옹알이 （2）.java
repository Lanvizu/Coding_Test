class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] result = {"aya", "ye", "woo", "ma"};
        for (String a : babbling) {
            for (int i = 0; i < result.length; i++) {
                if (a.contains(result[i])) {
                    a = a.replace(result[i], String.valueOf(i));
                }

            }
            System.out.println(a);
            if (a.contains("00")
                    || a.contains("11")
                    || a.contains("22")
                    || a.contains("33")
                    || a.matches(".*[a-z].*")) {
                answer += 0;
            } else {
                answer += 1;
            }
        }
        return answer;
    }
}