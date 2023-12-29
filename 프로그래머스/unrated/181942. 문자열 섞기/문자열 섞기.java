class Solution {
    public String solution(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int count = str1.length();
        for (int i = 0; i < count; i++) {
            result.append(str1.charAt(i));
            result.append(str2.charAt(i));
        }
        
        String answer = result.toString();
        return answer;
    }
}