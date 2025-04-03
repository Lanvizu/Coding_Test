import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        Queue<int[][]> q = new ArrayDeque<>();
        q.offer(arr);
        while(!q.isEmpty()){
            int[][] now = q.poll();
            if(now.length == 1){
                answer[now[0][0]] +=1;
            }else{
                if(calc(now)){
                    answer[now[0][0]] +=1;
                }else{
                    devide(q,now);
                }
            }
        }
        return answer;
    }
    
    public Boolean calc(int[][] graph){
        int target = graph[0][0];
        int n = graph.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(graph[i][j] != target){
                    return false;
                }
            }
        }
        return true;
    }
    public void devide(Queue<int[][]> q, int[][] graph){
        int n = graph.length;
        
        int ta = 0;
        for(int a=0; a<2; a++){
            int tb = 0;
            for(int b=0; b<2; b++){
                int[][] result = new int[n/2][n/2];
                for(int i=0; i<n/2; i++){
                    for(int j=0; j<n/2; j++){
                        result[i][j] = graph[i+ta][j+tb];
                    }
                }
                q.offer(result);
                tb += n/2;
            }
            ta += n/2;
        }
        
    }
    
}

// 큐 사용해서 진행하는건가?
// 일단 2차원 배열 하나 입력 -> 내부에서 같은 수 처리
// 처리가 안되는 경우 4개로 나눠서 큐에 넣어서 진행?
