import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            for (int j = 0; j <= N; j++) {
                graph.get(i).add(0);
            }
        }
        visited = new boolean[N + 1];
        count = 0;

        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).remove(b);
            graph.get(a).add(b, 1);
            graph.get(b).remove(a);
            graph.get(b).add(a, 1);
        }

        for (int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            dfs(i,N);
            count++;
        }
        System.out.println(count);
    }
    private static void dfs(int x, int N) {
        visited[x] = true;
        for (int i = 1; i <= N; i++) {
            if(visited[i]) continue;
            Integer i1 = graph.get(x).get(i);
            if (i1 == 1) {
                dfs(i, N);
            }
        }
    }
}