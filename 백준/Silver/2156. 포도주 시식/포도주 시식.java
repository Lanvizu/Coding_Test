import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] graph = new int[N+1];
        int[] visited = new int[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = scanner.nextInt();
            visited[i] = 0;
        }
        visited[0] = 0;
        visited[1] = graph[1];
        if (N > 1) {
            visited[2] = graph[1] + graph[2];
        }
        if (N > 2) {
            visited[3] = graph[3] + Math.max(graph[2] + visited[0], visited[1]);
        }
        for (int i = 4; i <= N; i++) {
            int a = Math.max(graph[i - 1] + visited[i - 4], graph[i - 1] + visited[i - 3]);
            visited[i] = graph[i] + Math.max(a, visited[i - 2]);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, visited[i]);
        }

        System.out.println(max);
    }
}
