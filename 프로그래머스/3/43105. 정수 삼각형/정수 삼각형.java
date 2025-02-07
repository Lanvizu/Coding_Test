import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i+1; j++){
                if(j == 0){
                    triangle[i][j] += triangle[i-1][j];
                }else if(j == i){
                    triangle[i][j] += triangle[i-1][j-1];
                }else{
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }
        Arrays.sort(triangle[n-1]);
        answer = triangle[n-1][n-1];
        return answer;
    }
}