class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        StringBuilder result_a = new StringBuilder();
        result_a.append(a);
        result_a.append(b);

        int c = Integer.parseInt(String.valueOf(result_a));

        int d = 2 * a * b;
        if (c >= d) {
            answer = c;
        } else {
            answer= d;
        } 
        return answer;
    }
}