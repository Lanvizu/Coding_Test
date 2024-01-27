class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x = 0;
        int y = 0;
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            x = i;
            if (yellow % x == 0) {
                y = yellow / x;
                if (x * 2 + y * 2 + 4 == brown) {
                    answer[0] = y+2;
                    answer[1] = x+2;
                }
            }
        }
        return answer;
    }
}