//  마법사 상어와 비바라기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] arr;
    // 8가지 방향
    static int[][] move = new int[][]{{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    // 대각선 방향
    static int[][] CL = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][N];
        boolean[][] cloud = new boolean[N][N];
        // (N,1), (N,2), (N-1,1), (N-1,2)
        for (int i = N - 2; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                cloud[i][j] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            int d = Integer.parseInt(s1[0]);
            int s = Integer.parseInt(s1[1]);
            Queue<int[]> queue = step123(d, s, cloud);
            cloud = step45(queue);
        }
        calc();
    }

    // 1. d방향 s이동 2. 해당 칸 1증가 3. 모든 구름 제거(체크)
    public static Queue<int[]> step123(int d, int s, boolean[][] cloud) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j]) {
                    int nx = (i + move[d][0] * s) % N;
                    int ny = (j + move[d][1] * s) % N;
                    nx = nx < 0 ? nx + N : nx;
                    ny = ny < 0 ? ny + N : ny;
                    q.add(new int[]{nx, ny});
                    arr[nx][ny]++;
                }
            }
        }
        return q;
    }

    public static boolean[][] step45(Queue<int[]> q) {
        boolean[][] visited = new boolean[N][N];
        boolean[][] newCloud = new boolean[N][N];
        while (!q.isEmpty()) {
            int[] nxy = q.poll();
            int nx = nxy[0];
            int ny = nxy[1];
            arr[nx][ny] += checkCL(nx, ny);
            visited[nx][ny] = true;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                if (arr[i][j] < 2) continue;
                newCloud[i][j] = true;
                arr[i][j] -= 2;
            }
        }
        return newCloud;
    }

    public static int checkCL(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + CL[i][0];
            int ny = y + CL[i][1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (arr[nx][ny] == 0) continue;
            cnt++;
        }
        return cnt;
    }

    public static void calc() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += arr[i][j];
            }
        }
        System.out.println(answer);
    }
}