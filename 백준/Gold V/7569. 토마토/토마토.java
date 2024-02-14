import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {+1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, +1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, +1, -1};
    static int M, N, H;
    static int max = 0;

    static int[][][] boxes;
    static Boolean[][][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        H = scanner.nextInt();

        boxes = new int[H][M][N];
        visited = new Boolean[H][M][N];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    boxes[i][j][k] = scanner.nextInt();
                    visited[i][j][k] = false;
                }
            }
        }

        bfs();

        a:
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (boxes[i][j][k] == 0) {
                        max = 0;
                        break a;
                    } else {
                        max = Math.max(boxes[i][j][k], max);
                    }
                }
            }
        }
        System.out.println(max-1);


    }

    private static void bfs() {

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (boxes[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int nowZ = poll[0];
            int nowX = poll[1];
            int nowY = poll[2];
            for (int i = 0; i < 6; i++) {
                int nextZ = nowZ + dz[i];
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (nextX < 0 || nextY < 0 || nextZ < 0
                        || nextX >= M || nextY >= N || nextZ >= H) {
                    continue;
                }
                if (boxes[nextZ][nextX][nextY] == 0) {
                    q.add(new int[]{nextZ, nextX, nextY});
                    boxes[nextZ][nextX][nextY] = boxes[nowZ][nowX][nowY] + 1;
                    visited[nextZ][nextX][nextY] = true;
                }
            }
        }
    }
}
