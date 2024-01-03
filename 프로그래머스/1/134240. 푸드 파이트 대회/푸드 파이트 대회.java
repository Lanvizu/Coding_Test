class Solution {
    public String solution(int[] food) {
        StringBuilder result = new StringBuilder();
        int length = food.length;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                result.append(i);
            }
        }
        result.append(0);
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < food[i] / 2; j++) {
                result.append(i);
            }
        }
        String answer = result.toString();
        return answer;
    }
}