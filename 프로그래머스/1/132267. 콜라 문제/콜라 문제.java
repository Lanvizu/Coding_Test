class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= a) {
            int c = (n / a) * b;
            answer += c;
            n = c + n % a;
        }
        return answer;
    }
}