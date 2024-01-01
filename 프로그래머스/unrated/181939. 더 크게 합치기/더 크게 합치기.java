class Solution {
    public int solution(int a, int b) {
        StringBuilder result1 = new StringBuilder();
        result1.append(a);
        result1.append(b);

        int value1 = Integer.parseInt(String.valueOf(result1));

        StringBuilder result2 = new StringBuilder();
        result2.append(b);
        result2.append(a);

        int value2 = Integer.parseInt(String.valueOf(result2));

        int answer = 0;
        if (value1 > value2) {
            answer = value1;
        } else {
            answer = value2;
        }
        return answer;
    }
}