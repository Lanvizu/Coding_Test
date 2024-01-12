class Solution {
    public int solution(String name) {
        int answer = 0;
        int maxA = 0;
        int lengthA = 0;
        int endA = 0;
        int length = name.length();
        for (int i = 0; i < length; i++) {
            char charAt = name.charAt(i);
            if (charAt == 'A') {
                lengthA += 1;
                if (maxA < lengthA) {
                    maxA = lengthA;
                    endA = i;
                }
            } else if ((int) charAt < 78) {
                int i1 = (int) charAt - 65;
                answer += i1;
                lengthA = 0;
            } else {
                int i1 = 91 - (int) charAt;
                answer += i1;
                lengthA = 0;
            }
        }
//        1. 순서대로 + A로 끝날때
        int lastA = length - 1;
        int lastACount = 0;
        while (name.charAt(lastA) == 'A') {
            lastA -= 1;
            if (lastA <= 0) {
                break;
            }
            lastACount++;
        }

        int count = length - 1 - lastACount;

//        2. 반대로 측정
        if (length > 1) {
            int firstA = 1;
            while (name.charAt(firstA) == 'A') {
                if (count > length - firstA - 1) {
                    count = length - firstA - 1;
                }
                firstA++;
                if (firstA == length) {
                    break;
                }
            }
        }
//        3. 정방향 + 역방향, start가 제일 긴 0을 포함 X
        if (endA > maxA) {
            int a = endA - maxA;
            int b = 0;
            int c = 0;
            if (length - 1 > endA) {
                b = length - endA - 1;
            }
            if (b < a) {
                c = b * 2 + a;
            } else {
                c = a * 2 + b;
            }
            if (count > c) {
                count = c;
            }
        }
        answer += count;
        return answer;
    }
}