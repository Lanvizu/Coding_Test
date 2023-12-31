class Solution {
    public String solution(String my_string, int k) {
        StringBuilder result = new StringBuilder(); 
        for (int i = 0; i < k; i++) {
            result.append(my_string);
        }
        String answer = result.toString();
        return answer;
    }
}