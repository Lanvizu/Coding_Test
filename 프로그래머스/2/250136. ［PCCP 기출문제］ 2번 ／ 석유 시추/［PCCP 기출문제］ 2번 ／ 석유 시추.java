import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        int[][] visited = new int[n][m];
        int[] result = new int[m];
        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (land[i][j] == 1 && visited[i][j] == 0){
                    bfs(land, visited, new int[]{i,j}, result);
                }
            }
        }
        
        answer = Arrays.stream(result).max().getAsInt();
        return answer;
    }
    
    public void bfs(int[][] land, int[][] visited, int[] xy, int[] result){
        int n = land.length;
        int m = land[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dxy = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int[] check = new int[m];
        int sum = 0;
        visited[xy[0]][xy[1]] = 1;
        q.offer(xy);
        while (!q.isEmpty()){
            int[] now = q.poll();
            sum += 1;
            check[now[1]] = 1;
            for (int i=0; i<4; i++){
                int nx = now[0] + dxy[i][0];
                int ny = now[1] + dxy[i][1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }
                if (visited[nx][ny] == 1 || land[nx][ny] == 0){
                    continue;
                }
                
                visited[nx][ny] = 1;
                q.offer(new int[]{nx, ny});
            }
        }
        for(int i=0; i<m; i++){
            if (check[i] == 1){
                result[i] += sum;
            }
        }
    }
}