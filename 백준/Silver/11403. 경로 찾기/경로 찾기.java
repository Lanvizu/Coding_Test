
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> visited = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            visited.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph.get(i).add(scanner.nextInt());
                visited.get(i).add(0);
            }
        }
        for (int i = 0; i < N; i++) {
            dfs(i, i);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == N - 1) {
                    System.out.println(visited.get(i).get(j));
                } else {
                    System.out.print(visited.get(i).get(j) + " ");
                }
            }
        }
    }

    private static void dfs(int a, int b) {

        for (int i = 0; i < N; i++) {
            if (graph.get(a).get(i) == 1) {
                if (visited.get(b).get(i) == 0) {
                    visited.get(b).remove(i);
                    visited.get(b).add(i, 1);
                    dfs(i, b);
                }
            }
        }
    }
}
