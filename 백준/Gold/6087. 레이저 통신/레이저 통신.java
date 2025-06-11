//  레이저 통신

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] dxy = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int W = Integer.parseInt(s[0]);
        int H = Integer.parseInt(s[1]);

        char[][] graph = new char[H][W];
        List<int[]> targets = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            graph[i] = sc.nextLine().toCharArray();
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (graph[i][j] == 'C') {
                    targets.add(new int[]{i, j});
                }
            }
        }


        int[][][] visited = bfs(graph, targets.get(0), targets.get(1), H, W);

        int[] end = targets.get(1);
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if(visited[end[0]][end[1]][i] != 0){
                answer = Math.min(answer, visited[end[0]][end[1]][i]);
            }
        }
        System.out.println(answer-1);
    }

    public static int[][][] bfs(char[][] graph, int[] start, int[] end, int H, int W) {
        Queue<int[]> q = new LinkedList<>();
        // 방문 배열에 각 방향에 대한 정보도 같이 저장?
        // 0123 방향에 대한 정보를 저장 -> 이미 같은 방향으로 저장된 경우 스킵
        int[][][] visited = new int[H][W][4];
        // 초기 설정
        for(int i = 0; i < 4; i++) {
            int sx = start[0] + dxy[i][0];
            int sy = start[1] + dxy[i][1];
            if (sx < 0 || sy < 0 || sx >= H || sy >= W || graph[sx][sy] == '*') {
                continue;
            }
            q.add(new int[]{sx, sy, i});
            visited[sx][sy][i] = 1;
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == end[0] && y == end[1]) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dxy[i][0];
                int ny = y + dxy[i][1];
                if (nx < 0 || ny < 0 || nx >= H || ny >= W || graph[nx][ny] == '*') {
                    continue;
                }
                // 이전 방향으로 돌아갈 경우
                if (i == (cur[2] + 2) % 4) {
                    continue;
                }
                if (i == cur[2]) {
                    if (visited[nx][ny][i] == 0 || visited[nx][ny][i] > visited[x][y][i]) {
                        visited[nx][ny][i] = visited[x][y][i];
                        q.offer(new int[]{nx, ny, i});
                    }
                } else {
                    if (visited[nx][ny][i] == 0 || visited[nx][ny][i] > visited[x][y][cur[2]]+1) {
                        visited[nx][ny][i] = visited[x][y][cur[2]] + 1;
                        q.offer(new int[]{nx, ny, i});
                    }
                }
            }
        }
        return visited;
    }
}