import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, M, d;
    static int[] dir_x = {-1, 0, +1, 0};
    static int[] dir_y = {0, +1, 0, -1};

    static int[][] graph;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        d = scanner.nextInt();

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        bfs(a, b);

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 2) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    private static void bfs(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int now_x = poll[0];
            int now_y = poll[1];
            graph[now_x][now_y] = 2;
            int count = 0;
            for (int i = 1; i <= 4; i++) {
                d = d - 1;
                if (d < 0) {
                    d += 4;
                }
                int next_x = now_x + dir_x[d];
                int next_y = now_y + dir_y[d];

                if (graph[next_x][next_y] == 0) {
                    q.add(new int[]{next_x, next_y});
                    break;
                } else {
                    count++;
                }
            }
            if (count == 4) {
                int next_x = now_x - dir_x[d];
                int next_y = now_y - dir_y[d];
                if (graph[next_x][next_y] == 2) {
                    q.add(new int[]{next_x, next_y});
                } else {
                    return;
                }
            }
        }
    }
}