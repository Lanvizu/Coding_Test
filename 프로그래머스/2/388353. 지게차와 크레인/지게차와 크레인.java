import java.util.*;
class Solution {
    int[][] dxy = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int n = storage.length;
        int m = storage[0].length();
        char[][] graph = new char[n][m];
        for(int i=0; i<n; i++){
            char[] cc = storage[i].toCharArray();
            for(int j=0; j<m; j++){
                graph[i][j] = cc[j];
            }
        }
        for(String rq:requests){
            graph = check(n, m, graph, rq);
            graph = bfs(n, m, graph);
        }
        
        answer = n * m - calc(n , m, graph);
        
        return answer;
    }
    
    public char[][] bfs(int n, int m, char[][] graph){
        Queue<int[]> q = new ArrayDeque<>();
        char[][] n_graph = new char[n][];
        for(int i=0; i<n; i++){
            n_graph[i] = graph[i].clone();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char now = graph[i][j];
                if(now != '1') continue;
                for(int k=0; k<4; k++){
                    int nx = i + dxy[k][0];
                    int ny = j + dxy[k][1];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                        q.add(new int[] {i,j});
                        break;
                    }else{
                        if(graph[nx][ny] == '0'){
                            q.add(new int[] {i,j});
                            break;
                        }
                    }
                }
            }
        }
        
        while(!q.isEmpty()){
            int[] nxy = q.poll();
            int x = nxy[0];
            int y = nxy[1];
            n_graph[x][y] = '0';
            for(int i=0; i<4; i++){
                int nx = x + dxy[i][0];
                int ny = y + dxy[i][1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(n_graph[nx][ny] == '1'){
                    q.add(new int[] {nx,ny});
                }
            }
        }
        return n_graph;
    }
    
    
    public char[][] check(int n, int m, char[][] graph, String target){
        // 깊은 복사
        char[][] n_graph = new char[n][];
        for(int i=0; i<n; i++){
            n_graph[i] = graph[i].clone();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char a = graph[i][j];
                if(target.charAt(0) != a) continue;
                if(target.length()>1){
                    n_graph[i][j] = '1';
                    continue;
                }
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    n_graph[i][j] = '0';
                    continue;
                }
                int cnt = 0;
                for(int k=0; k<4; k++){
                    int nx = i + dxy[k][0];
                    int ny = j + dxy[k][1];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    if(graph[nx][ny] == '0') {
                        n_graph[i][j] = '0';
                        break;
                    }
                }
            }
        }
        return n_graph;
    }
    
    public int calc(int n, int m, char[][] graph){
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j] == '1' || graph[i][j] == '0'){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
// 외부에서 접근 가능한 것은 바로 옆에 0 이 있는 경우로 할까?
// 대신 2글자로 뺄 경우에는 내부도 0 으로 처리하면 안된다. 이거 뺄 때 0이랑 접근되어 있으면 0 처리 아니면 1