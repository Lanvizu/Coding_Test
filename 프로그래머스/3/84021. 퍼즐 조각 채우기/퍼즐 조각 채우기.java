import java.util.*;

class Solution {
    boolean[][] visited;
    boolean[][] g_visited;
    int[][] gb;
    int n;
    int m;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    int answer;
    public int solution(int[][] game_board, int[][] table) {
        answer = 0;
        n = table.length;
        m = table[0].length;
        visited = new boolean[n][m];
        g_visited = new boolean[n][m];
        gb = game_board;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] || table[i][j] == 0){
                    continue;
                }
                List<int[]> result = new ArrayList<>();
                result.add(new int[]{i,j});
                visited[i][j] = true;
                dfs(table, i, j, result);
                result.remove(0);
                List<List<int[]>> new_rr = rotate(result);
                calc(new_rr);
            }
        }
        return answer;
    }
    
    public void calc(List<List<int[]>> rr){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(gb[i][j] == 1 || g_visited[i][j]){
                    continue;
                }
                if(check(rr, i, j)){
                    return;
                };
            }
        }
    }
    
    public boolean check(List<List<int[]>> rr, int i, int j){
        for(List<int[]> r: rr){
            boolean flag = true;
            int cnt = 1;
            boolean[][] v1 = new boolean[n][m];
            for(int[] now: r){ 
                int nx = i + now[0];
                int ny = j + now[1];
                if(nx<0 || nx>=n || ny<0 || ny>=m || gb[nx][ny] == 1){
                    flag = false;
                    break;
                }
                v1[nx][ny] = true;
                cnt++;
            }
            if(flag){
                if(bfs(i,j,v1)){
                    answer += cnt;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean bfs(int a, int b, boolean[][] v1){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v2 = new boolean[n][m];
        q.add(new int[]{a,b});
        v2[a][b] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx<0 || nx>=n || ny<0 || ny>=m){
                    continue;
                }
                if(gb[nx][ny] == 1 || v2[nx][ny]){
                    continue;
                }
                v2[nx][ny] = true;
                q.add(new int[]{nx, ny});
                if(!v1[nx][ny]){
                    return false;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(v2[i][j]){
                    g_visited[i][j] = true;
                }
            }
        }
        return true;
    }
    
    public void dfs(int[][] table, int a, int b, List<int[]> result){
        for(int i=0; i<4; i++){
            int nx = a+dx[i];
            int ny = b+dy[i];
            if(nx<0 || nx>=n || ny<0 || ny>=m){
                continue;
            }
            if(table[nx][ny] == 0 || visited[nx][ny]){
                continue;
            }
            
            result.add(new int[] {nx- result.get(0)[0],ny - result.get(0)[1]});
            visited[nx][ny] = true;
            dfs(table, nx ,ny, result);
        }
    }
    
    public List<List<int[]>> rotate(List<int[]> result){
        List<List<int[]>> new_r = new ArrayList<>();
        new_r.add(result);
        for(int i=0; i<3; i++){
            List<int[]> new_rr = new ArrayList<>();
            for(int[] rr:new_r.get(i)){
                new_rr.add(new int[]{rr[1], -rr[0]});
            }
            new_r.add(new_rr);
        }
        return new_r;
    }
}
