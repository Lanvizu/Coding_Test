class Solution {
    public int[] solution(int[] answers) {
        
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int countA = 0;
        int countB = 0;
        int countC = 0;

        for (int i = 0; i < answers.length; i++) {
            int A, B, C = 0;

            if (i > 9) {
                C = i % 10;
                B = i % 8;
                A = i % 5;
            } else if (i > 7) {
                C = i;
                B = i % 8;
                A = i % 5;
            } else if (i > 4) {
                C = i;
                B = i;
                A = i % 5;
            } else {
                C = i;
                B = i;
                A = i;
            }
            if (c[C] == answers[i]) {
                countC++;
            }
            if (b[B] == answers[i]) {
                countB++;
            }
            if (a[A] == answers[i]) {
                countA++;
            }
        }

        int max = Math.max(Math.max(countA, countB), countC);
        StringBuilder builder = new StringBuilder();
        if (countA == max) {
            builder.append(1);
        }
        if (countB == max) {
            builder.append(2);
        }
        if (countC == max) {
            builder.append(3);
        }

        String[] split = builder.toString().split("");
        int[] answer = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            answer[i] = Integer.parseInt(split[i]);
        }
        return answer;
    }
}