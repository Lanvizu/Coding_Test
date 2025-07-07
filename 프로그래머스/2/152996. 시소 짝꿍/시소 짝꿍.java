import java.util.*;

class Solution {
    static long answer = 0L;
    public long solution(int[] weights) {
        long[] visited = new long[1001];
        for(int w: weights){
            calc(w, visited);
            // 원본 증가
            visited[w]++;
        }
        return answer;
    }
    
    public void calc(int w, long[] visited){
        long result = 0L;
        
        // 1:1 비율
        result += visited[w];
        
        // 1:2, 2:1
        if(w * 2 <= 1000) result += visited[w * 2];
        if(w % 2 == 0) result += visited[w / 2];
        
        // 2:3, 3:2
        if(w * 3 % 2 == 0 && w * 3 / 2 <= 1000) {
            result += visited[w * 3 / 2];
        }
        if(w * 2 % 3 == 0 && w * 2 / 3 >= 100) {
            result += visited[w * 2 / 3];
        }
        
        // 3:4, 4:3
        if(w * 3 % 4 == 0 && w * 3 / 4 >= 100) {
            result += visited[w * 3 / 4];
        }
        if(w * 4 % 3 == 0 && w * 4 / 3 <= 1000) {
            result += visited[w * 4 / 3];
        }
        
        answer += result;
    }
}
// 10만이므로 for문 한 번으로 처리
// 100, 200, 300, 400 (원본,2,3,4) -> 이걸 100~최대 4000 개수 체크?
// 180, 360, 540, 720
// 100 -> 하나 추가
// 쌍을 어떻게 구하지
// 1:1, 1:2, 1:3, 1:4 / 2:1, 2:3 / 3:1, 3:2, 3:4/ 4:1, 4:3
// 100 인 경우
// 100 200 300 400 50 150/33.3333,66.666,99.9999 / 25,75
// 정수인 경우만 체크?
// 102 -> 204 68