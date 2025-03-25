import java.util.*;
import java.io.*;
class Solution {
    
    public int solution(String[] board) {
        int answer = -1;
        int rows = board.length;
        int cols = board[0].length();
        char[][] graph = new char[rows][cols];
        int[][] visited = new int[rows][cols];
        int[] start = new int[3];
        int[] end = new int[2];
        for (int i = 0; i < rows; i++) {
            graph[i] = board[i].toCharArray();
            for (int j = 0; j < cols; j++) {
                if (graph[i][j] == 'R') {
                    start = new int[]{i, j, 0};
                } else if (graph[i][j] == 'G') {
                    end = new int[]{i, j};
                }
            }
        }
        return bfs(graph, visited, start, end);
    }
    
    public int bfs(char[][] graph, int[][] visited, int[] start, int[] end){
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(start);
        visited[start[0]][start[1]] = 1;
        
        while(!q.isEmpty()){
            int[] cur  = q.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                return cur[2];
            }
            
            for (int[] dir : dirs) {
                int nx = cur[0];
                int ny = cur[1];
                
                while (true) {
                    int nextX = nx + dir[0];
                    int nextY = ny + dir[1];
                    if (nextX < 0 || nextX >= graph.length || 
                        nextY < 0 || nextY >= graph[0].length || 
                        graph[nextX][nextY] == 'D') {
                        break;
                    }
                    nx = nextX;
                    ny = nextY;
                }
                if ((nx != cur[0] || ny != cur[1]) && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    q.offer(new int[]{nx, ny, cur[2] + 1});
                }
            }
        }
        return -1;
    }
}