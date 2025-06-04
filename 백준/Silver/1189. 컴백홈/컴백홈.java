//  컴백홈

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] dxy = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int R, C, K;
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(" ");
        R = Integer.parseInt(a[0]);
        C = Integer.parseInt(a[1]);
        K = Integer.parseInt(a[2]);

        char[][] graph = new char[R][C];
        for(int i=0; i<R; i++){
            graph[i] = sc.nextLine().toCharArray();
        }
        boolean[][] visited = new boolean[R][C];
        visited[R - 1][0] = true;
        dfs(graph, R - 1, 0, 1, visited);
        System.out.println(result);
//        R-1,0 -> 0,C-1
    }
    public static void dfs(char[][] graph, int x, int y, int cnt, boolean[][] visited){
        if(cnt > K) return;
        if (x == 0 && y == C - 1) {
            if(cnt == K){
                result++;
            }
            return;
        }

        for(int[] d : dxy){
            int nx = x + d[0];
            int ny = y + d[1];
            if(nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny]) continue;
            if(graph[nx][ny] == 'T') continue;

            visited[nx][ny] = true;
            dfs(graph, nx, ny, cnt + 1, visited);
            visited[nx][ny] = false;
        }
    }
}