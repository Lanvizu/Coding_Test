import java.util.*;
class Solution {
    int[][] dxy = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        // for(int[] t:picture){
        //     System.out.println(Arrays.toString(t));
        // }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    numberOfArea++;
                    int cnt = bfs(picture, visited, i, j);
                    // System.out.println(cnt);
                    maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }
    // dfs로 진행 시 마지막 cnt 값을 계산하기 어려운 상태.
    // bfs로 다시 진행
    public int bfs(int[][] picture, boolean[][] visited, int x, int y){
        int target = picture[x][y];
        int m = picture.length;
        int n = picture[0].length;
        int cnt = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x,y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            // for(int[] t:q){
            //     System.out.println(Arrays.toString(t));
            // }
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + dxy[i][0];
                int ny = now[1] + dxy[i][1];
                if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
                if(visited[nx][ny] || picture[nx][ny] != target) continue;
                visited[nx][ny] = true;
                cnt++;
                q.add(new int[] {nx,ny});
            }
        }
        return cnt;
    }
}