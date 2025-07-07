class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            long num = numbers[i];
            answer[i] = calc(num);
        }
        return answer;
    }
    
    public static long numberOfTrailingOnes(long n) {
        return Long.numberOfTrailingZeros(~n);
    }
    
    public long calc(long num){
        // 0이 우측부터 연속으로 몇 개
        long t = numberOfTrailingOnes(num);
        if(t == 0) {
            return num+1;
        } else {
            return (num + (1L << t-1L));
            // 10011111 -> 5
            // 10101111 -> 4개 될때 까지 즉 1 3개 +1
        }
    }
}