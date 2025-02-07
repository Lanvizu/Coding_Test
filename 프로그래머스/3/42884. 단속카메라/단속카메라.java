import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int n = routes.length;
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1]-o2[1];
        });
        int tar = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int str = routes[i][0];
            int end = routes[i][1];
            if(str > tar){
                answer ++;
                tar = end;
            }
        }
        return answer;
    }
}