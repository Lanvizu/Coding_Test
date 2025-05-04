import java.util.*;
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        long W = w;
        long H = h;
        long c = calc(W, H);
        answer = W*H - (W+H - c);
        
        return answer;
    }
    
    public long calc(long a, long b){
        if(a%b == 0){
            return b; 
        }else{
            return calc(b, a%b);
        }
    }
}
// 기울기를 구하고, 0 부터 시작해서 1인 경우에는 ex) 1.5 , 2 -> 3, 
// 3 5 -> 1.6666  1-> 1.666 -> 2 3.33333 -> 3 ->5
// 0부터 1은 2 -> 1~2 -> 3  2~3 