import java.util.*;
class Solution {
    int[][] graph;
    int[][] dxy = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        graph = new int[102][102];
        int[] now = new int[] {characterX*2, characterY*2};
        int[] end = new int[] {itemX*2, itemY*2};
        for(int[] rt: rectangle){
            check(rt);
        }
        
        return bfs(now,end) / 2;
    }
    
    public void check(int[] rt) {
        int x1 = rt[0]*2, y1 = rt[1]*2;
        int x2 = rt[2]*2, y2 = rt[3]*2;
        
        for(int x=x1; x<=x2; x++) {
            setBorder(x, y1);
            setBorder(x, y2);
        }
        for(int y=y1; y<=y2; y++) {
            setBorder(x1, y);
            setBorder(x2, y);
        }
        
        for(int x=x1+1; x<x2; x++) {
            for(int y=y1+1; y<y2; y++) {
                graph[x][y] = 2;
            }
        }
    }
    
    private void setBorder(int x, int y) {
        if(graph[x][y] == 0) graph[x][y] = 1; 
    }
    
    public int bfs(int[] n, int[] e){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        q.add(new int[]{n[0],n[1],0});
        visited[n[0]][n[1]] = true;
        int cnt = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[0] == e[0] && now[1] == e[1]){
                cnt = Math.min(cnt, now[2]);
                continue;
            }
            for(int i=0; i<4; i++){
                int nx = now[0] + dxy[i][0];
                int ny = now[1] + dxy[i][1];
                if(nx >= 0 && nx < 102 
                   && ny >=0 && ny < 102
                   && graph[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx,ny,now[2]+1});
                }
            }
        }
        return cnt;
        
    }
}
// 2배씩 키워서 적용.
// 좌우 방향으로 돌면서 최외각 돌면서 계산 진행하면 될듯? 마지막엔 나누기2
