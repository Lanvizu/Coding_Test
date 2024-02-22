import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[][] graph = new int[K+1][N+1];
        for (int i = 0; i <= N; i++) {
            graph[1][i] = 1;
        }
        for (int i = 1; i <= K; i++) {
            graph[i][0] = 1;
        }
        dp(N, K, graph);
        int answer = graph[K][N];
        System.out.println(answer);
    }

    private static void dp(int N, int K, int[][] graph) {
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                graph[i][j] = (graph[i - 1][j] + graph[i][j - 1])%1000000000;
            }
        }
    }
}
