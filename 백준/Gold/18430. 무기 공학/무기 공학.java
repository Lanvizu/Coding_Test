//  무기 공학

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int answer = 0;
    static int N, M;
    static int[][] dxy = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 0);
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int result) {
        if (x == N) {
            answer = Math.max(answer, result);
            return;
        }

        int nextx = (y + 1 == M) ? x + 1 : x;
        int nexty = (y + 1 == M) ? 0 : y + 1;

        for (int i = 0; i < 4; i++) {
            int nx1 = x + dxy[i][0];
            int ny1 = y + dxy[i][1];
            int nx2 = x + dxy[(i + 1) % 4][0];
            int ny2 = y + dxy[(i + 1) % 4][1];
            if (nx1 < 0 || ny1 < 0 || nx2 < 0 || ny2 < 0) continue;
            if (nx1 >= N || ny1 >= M || nx2 >= N || ny2 >= M) continue;
            if (visited[x][y] || visited[nx1][ny1] || visited[nx2][ny2]) continue;
            visited[nx1][ny1] = true;
            visited[nx2][ny2] = true;
            visited[x][y] = true;

            dfs(nextx, nexty, result + graph[nx1][ny1] + graph[nx2][ny2] + graph[x][y] * 2);

            visited[nx1][ny1] = false;
            visited[nx2][ny2] = false;
            visited[x][y] = false;
        }
        dfs(nextx, nexty, result);
    }
}
