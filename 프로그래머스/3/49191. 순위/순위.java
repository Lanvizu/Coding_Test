import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n+1][n+1];
        
        for(int[] now: results){
            int win = now[0];
            int lose = now[1];
            graph[win][lose] = true;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){
                    if(graph[j][i] && graph[i][k]){
                        graph[j][k] = true;
                    }
                }  
            }
        }
        
        for(int i=1; i<=n; i++){
            int cnt = 0;
            for(int j=1; j<=n; j++){
                if(graph[i][j] || graph[j][i]){
                    cnt ++;
                }
            }
            if(cnt == n-1){
                answer ++;
            }
        }
        
        return answer;
    }
}