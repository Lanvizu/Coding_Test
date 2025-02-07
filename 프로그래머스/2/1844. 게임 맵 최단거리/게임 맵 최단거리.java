import java.io.*;
import java.util.*;

class Node {
    private int x;
    private int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
}

class Solution {
    public int n, m;
    public int[] dx = {-1,1,0,0};
    public int[] dy = {0,0,-1,1};
    
    public int bfs(int x, int y, int[][] maps){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        while(!q.isEmpty()){
            Node nd = q.poll();
            x = nd.getX();
            y = nd.getY();
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }
                if(maps[nx][ny] == 0){
                    continue;
                }
                if(maps[nx][ny] == 1){
                    maps[nx][ny] = maps[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return maps[n-1][m-1];
    }
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        int answer = bfs(0,0,maps);
        if(answer == 1){
            answer = -1;
        }
        return answer;
    }
}

// import java.util.LinkedList;
// import java.util.Queue;

// class Node {
//     private int x;
//     private int y;

//     public Node(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }

//     public int getX() {
//         return x;
//     }

//     public int getY() {
//         return y;
//     }
// }

// class Solution {
//     public static int n, m;

//     public static int[] dx = {-1, 1, 0, 0};
//     public static int[] dy = {0, 0, -1, 1};

//     public static int bfs(int x, int y, int[][] maps) {
//         Queue<Node> q = new LinkedList<>();
//         q.offer(new Node(x, y));
//         while (!q.isEmpty()) {
//             Node node = q.poll();
//             x = node.getX();
//             y = node.getY();
//             for (int i = 0; i < 4; i++) {
//                 int nx = x + dx[i];
//                 int ny = y + dy[i];
//                 if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
//                     continue;
//                 }
//                 if (maps[nx][ny] == 0) {
//                     continue;
//                 }
//                 if (maps[nx][ny] == 1) {
//                     maps[nx][ny] = maps[x][y] + 1;
//                     q.offer(new Node(nx, ny));
//                 }

//             }
//         }
//         return maps[n - 1][m - 1];
//     }
    
//     public int solution(int[][] maps) {
//         int answer = 0;
//         n = maps.length;
//         m = maps[0].length;

//         answer = bfs(0, 0, maps);
//         if (answer == 1) {
//             answer = -1;
//         }
//         return answer;
//     }
// }