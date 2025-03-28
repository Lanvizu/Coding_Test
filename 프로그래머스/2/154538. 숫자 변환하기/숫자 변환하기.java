import java.util.*;
import java.io.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = -1;
        int[] result = new int[1000001];
        Queue <int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, 0});
        result[x] = 0;
        while (!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] >= y){
                continue;
            }
            if(now[0]+n < 1000001 && result[now[0]+n] == 0){
                q.offer(new int[] {now[0]+n, now[1]+1});
                result[now[0]+n] = now[1]+1;
            }
            if(now[0]*2 < 1000001 && result[now[0]*2] == 0){
                q.offer(new int[] {now[0]*2, now[1]+1});
                result[now[0]*2] = now[1]+1;
            }
            if(now[0]*3 < 1000001 && result[now[0]*3] == 0){
                q.offer(new int[] {now[0]*3, now[1]+1});
                result[now[0]*3] = now[1]+1;
            }
        }
        if(result[y] != 0){
            answer = result[y];
        }else if(x == y){
            answer = 0;
        }
        return answer;
    }
}