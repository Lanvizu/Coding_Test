import java.util.*;

class Solution {
    public long solution(long k, long d) {
        long answer = 0;
        for(long a=0; a<=d; a+=k){
            double t = Math.pow(d*d - a*a, 0.5);
            answer += (long)t/k + 1;
        }
        return answer;
    }
}

// 거리가 1000000이면 1000 * 1000
// 반지름 d인 원 안에 찍히는 점의 개수
// a(0~d),b 일 경우 -> b는 0부터 루트(d*d - a*a)까지
