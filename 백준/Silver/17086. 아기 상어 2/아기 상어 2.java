//  아기 상어 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int result = 0;
    static int[][] dxy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph[i] = inputs;
        }
        bfs(n, m, graph);
        System.out.println(result);

    }

    public static void bfs(int n, int m, int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int i = 0; i < 8; i++) {
                int nx = cur[0] + dxy[i][0];
                int ny = cur[1] + dxy[i][1];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(graph[nx][ny] != 0 && graph[nx][ny] <= cur[2] + 1) continue;
                graph[nx][ny] = cur[2] + 1;
                result = Math.max(result, graph[nx][ny]);
                q.add(new int[] {nx, ny, cur[2] + 1});
            }
        }
    }
}