import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = N; j > N - i - 1; j--) {
                graph[i][N - j] = scanner.nextInt();
            }
        }
        int answer = graph[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == 0) {
                    graph[i][j] = graph[i][j] + graph[i - 1][j];
                } else {
                    graph[i][j] = graph[i][j] + Math.max(graph[i - 1][j - 1], graph[i - 1][j]);
                }

                if (i == N - 1) {
                    answer = Math.max(answer, graph[i][j]);
                }
            }
        }

        System.out.println(answer);

    }
}
