import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int m, int n, String[] board) {
        List<List> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=m-1; i>-1; i--){
            for(int j=0; j<n; j++){
                graph.get(j).add(board[i].charAt(j));
            }
        }
        while(bfs(graph, n, m)){};
        return answer;
    }
    
    public boolean bfs(List<List> graph, int n, int m){
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n-1; i++){
            for(int j=0; j<m-1; j++){
                if((char)graph.get(i).get(j) == '*'){
                    continue;
                }
                if(!calc(graph, i, j)){
                    continue;
                }
                for(int a=i; a<i+2; a++){
                    for(int b=j; b<j+2; b++){
                        visited[a][b] = true;
                    }
                }
            }
        }
        boolean flag = false;
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(visited[i][j]){
                    graph.get(i).remove(j);
                    graph.get(i).add('*');
                    flag = true;
                    answer ++;
                }
            }
        }
        return flag;
    }
    
    
    public boolean calc(List<List> graph, int x, int y){
        char now = (char)graph.get(x).get(y);
        if(x >= graph.size()-1 || y >= graph.get(0).size()-1){
            return false;
        }
        if((char)graph.get(x+1).get(y) != now || (char)graph.get(x).get(y+1) != now
          || (char)graph.get(x+1).get(y+1) != now){
            return false;
        }
        return true;
    }
}
//[C, A, A, C]
//[C, A, A, C]
//[B, A, A, B]
//[B, B, D, D]
//[F, F, E, E]