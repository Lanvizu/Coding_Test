import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> visited = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            visited.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                graph.get(i).add(scanner.nextInt());
            }
        }
        for (int i = 0; i < 3; i++) {
            visited.get(0).add(graph.get(0).get(i));
        }

        dp(0);
        int min = 1000001;
        for (int i = 0; i < 3; i++) {
            Integer integer = visited.get(N - 1).get(i);
            min = Math.min(integer, min);
        }
        System.out.println(min);
    }

    private static void dp(int depth) {

        if (depth == N - 1) {
            return;
        }

        Integer integer0 = visited.get(depth).get(0);
        Integer integer1 = visited.get(depth).get(1);
        Integer integer2 = visited.get(depth).get(2);

        visited.get(depth + 1).add(graph.get(depth + 1).get(0) + Math.min(integer1, integer2));
        visited.get(depth + 1).add(graph.get(depth + 1).get(1) + Math.min(integer0, integer2));
        visited.get(depth + 1).add(graph.get(depth + 1).get(2) + Math.min(integer1, integer0));

        dp(depth + 1);
    }
}
