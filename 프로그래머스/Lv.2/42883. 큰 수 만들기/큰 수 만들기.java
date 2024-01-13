class Solution {
    public String solution(String number, int k) {
        String answer = "";
        char[] chars = number.toCharArray();
        int length = number.length();
        int count = 0;

//        i번째 수와 i+1 번째 수를 비교 i번째가 작을 경우 A 로 변환
        for (int i = 0; i < length; i++) {
            int a = chars[i];
            int next = 1;
            while (i + next < length
                    && next <= k - count
                    && count <= k) {

                if (a < chars[i + next]) {
                    count++;
                    chars[i] = 'A';
                    break;
                }
                next++;
            }
        }

//        정해진 k를 못채운 경우 뒤에서부터 A 로 변환
        for (int i = length - 1; i > length - 1 - k; i--) {
            if (count < k && chars[i] != 'A') {
                chars[i] = 'A';
                count++;
            }
        }

//        A를 제외한 수 append
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (chars[i] != 'A') {
                builder.append(chars[i]);
            }
        }
        answer = builder.toString();
        return answer;

        // StringBuilder builder = new StringBuilder(number);
        // int length = builder.length() - k;

        // for (int i = 1; i < builder.length() && builder.length() > length; i++) {
        //     if (builder.charAt(i) > builder.charAt(i - 1)) {
        //         builder.deleteCharAt(i - 1);
        //         i = Math.max(0, i - 2);
        //     }
        // }

        // return builder.substring(0, length);
        
    }
}
