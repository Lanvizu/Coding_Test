import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int low = 1;
        int high = 1000000;
        while (low < high){
            int now = (low + high) / 2;
            long now_t = clac(now, diffs, times);
            if(now_t <= limit){
                high = now;
            }else if(now_t > limit){
                low = now+1;
            }
        }
        answer = high;
        return answer;
    }
    public long clac(int result, int[] diffs, int[] times){
        long tt = times[0];
        for(int i=1; i<diffs.length; i++){
            if(result >= diffs[i]){
                tt += times[i];
            }else{
                tt += (diffs[i] - result)*(times[i-1]+times[i]) + times[i];
            }
        }
        return tt;
    }
}
