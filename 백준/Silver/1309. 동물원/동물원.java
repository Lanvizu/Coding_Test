import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] graph = new int[N + 1][3];
        graph[1][0] = 1;
        graph[1][1] = 1;
        graph[1][2] = 1;
        for (int i = 2; i <= N; i++) {
            graph[i][0] = (graph[i - 1][0] + graph[i - 1][1] + graph[i - 1][2]) % 9901;
            graph[i][1] = (graph[i - 1][0] + graph[i - 1][2]) % 9901;
            graph[i][2] = (graph[i - 1][0] + graph[i - 1][1]) % 9901;
        }
        int answer = (graph[N][0] + graph[N][1] + graph[N][2]) % 9901;
        System.out.println(answer);
    }
}
