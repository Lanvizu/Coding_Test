import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < timelogs.length; i++){
            int cnt = 0;
            int st = startday;
            for (int time:timelogs[i]){
                if (st != 6 && st != 7){
                    int sc = (schedules[i] / 100)*60 + (schedules[i]%100);
                    int tm = (time/100)*60 + (time%100);
                    if (sc + 10 < tm){
                        break;
                    }else{
                        cnt += 1;
                    }
                }
                st += 1;
                if (st > 7){
                    st = 1;
                }
            }
            if (cnt == 5){
                answer += 1;
            }
        }
        return answer;
    }
}