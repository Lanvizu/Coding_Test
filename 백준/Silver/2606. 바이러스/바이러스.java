import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int a, b;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();

        for (int i = 0; i <= a; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < b; i++) {
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            graph.get(c).add(d);
            graph.get(d).add(c);
        }
        for (int i = 1; i <= a; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[a + 1];

        dfs(1);
        int count = 0;
        for (int i = 1; i <= a; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count - 1);

    }

    static void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i < graph.get(x).size(); i++) {
            Integer y = graph.get(x).get(i);
            if(visited[y]) continue;
            dfs(y);
        }
    }
}