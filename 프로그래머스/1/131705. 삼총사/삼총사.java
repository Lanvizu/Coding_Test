class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                int a = number[i] + number[j];

//                answer = (int) Arrays.stream(number, j+1, number.length)
//                        .filter(k -> a + number[k] == 0)
//                        .count();

                for (int k = j + 1; k < number.length; k++) {
                    if (a + number[k] == 0) {
                        answer += 1;
                    }
                }
            }
        }
        return answer;
    }
}