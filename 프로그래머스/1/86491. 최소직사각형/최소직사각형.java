class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max_a = 0;
        int max_b = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                if (sizes[i][1] > max_a) {
                    max_a = sizes[i][1];
                }
                if (sizes[i][0] > max_b) {
                    max_b = sizes[i][0];
                }
            } else {
                if (sizes[i][1] > max_b) {
                    max_b = sizes[i][1];
                }
                if (sizes[i][0] > max_a) {
                    max_a = sizes[i][0];
                }
            }
        }
        answer = max_a * max_b;
        return answer;

        // return Arrays.stream(sizes).reduce((a, b) -> new int[]{
        //         Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
        // }).map(it -> it[0] * it[1]).get();
    }
}
