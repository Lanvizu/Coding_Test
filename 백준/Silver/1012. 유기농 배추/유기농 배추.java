import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int T, M, N, K;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        while (T > 0) {
            count = 0;
            M = scanner.nextInt();
            N = scanner.nextInt();
            K = scanner.nextInt();
            for (int j = 0; j < N; j++) {
                graph.add(new ArrayList<>());
                for (int i = 0; i < M; i++) {
                    graph.get(j).add(0);
                }
            }
            for (int i = 0; i < K; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                graph.get(b).remove(a);
                graph.get(b).add(a, 1);
            }

            for (int j = 0; j < N; j++) {
                for (int i = 0; i < M; i++) {
                    if (graph.get(j).get(i) == 0) continue;
                    dfs(i,j);
                    count++;
                }
            }
            System.out.println(count);
            T--;
        }
    }

    private static void dfs(int a, int b) {
        if (a >= 0 && a < M && b >= 0 && b < N) {
            if (graph.get(b).get(a) == 1) {
                graph.get(b).remove(a);
                graph.get(b).add(a, 0);
                dfs(a + 1, b);
                dfs(a - 1, b);
                dfs(a, b + 1);
                dfs(a, b - 1);
            }
        }
    }
}