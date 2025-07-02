//  아기 상어

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, total;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        Baby baby = new Baby();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 9) {
                    baby.setXY(i, j);
                } else if (a != 0) {
                    graph[i][j] = a;
                }
            }
        }
        while (true) {
            if (!calc(baby)) {
                System.out.println(total);
                break;
            }
        }
    }

    public static boolean calc(Baby baby) {
        int[][] visited = bfs(baby);
        int[] next = new int[]{-1, -1, Integer.MAX_VALUE};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 갈 수 없는 경우 || 최소 거리보다 큰 경우
                if (visited[i][j] == 0 || visited[i][j] >= next[2]) continue;
                // 아기와 같거나 큰 경우 || 아무것도 없는 경우
                if (graph[i][j] >= baby.size || graph[i][j] == 0) continue;
                next = new int[]{i, j, visited[i][j]};
            }
        }
        // 먹을 물고기 없는 경우
        if (next[0] == -1) {
            return false;
        } else {
            baby.eat(next[0], next[1]);
            graph[next[0]][next[1]] = 0;
            total += next[2];
            return true;
        }
    }

    // 거리 계산
    public static int[][] bfs(Baby baby) {
        Queue<int[]> q = new LinkedList<>();
        int[][] visited = new int[N][N];
        q.add(new int[]{baby.x, baby.y, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                // 범위 벗어난 경우
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                // 아기보다 큰 경우 이동 불가
                if (graph[nx][ny] > baby.size) continue;
                // 이미 지난 경우
                if (visited[nx][ny] != 0) continue;
                visited[nx][ny] = cur[2] + 1;
                q.add(new int[]{nx, ny, cur[2] + 1});
            }
        }
        return visited;
    }

    static class Baby {
        int x, y, size, yum;

        public Baby() {
            this.size = 2;
            this.yum = 0;
        }

        public void setXY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void eat(int x, int y) {
            setXY(x, y);
            this.yum++;
            if (this.yum == this.size) {
                this.yum = 0;
                this.size++;
            }
        }
    }
}