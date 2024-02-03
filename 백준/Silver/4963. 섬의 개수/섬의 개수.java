import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int w, h, count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        w = scanner.nextInt();
        h = scanner.nextInt();
        while (w > 0 && h > 0) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < h; i++) {
                graph.add(new ArrayList<>());
            }
            scanner.nextLine();
            count = 0;
            for (int i = 0; i < h; i++) {
                String s = scanner.nextLine();
                String[] split = s.split(" ");
                for (int j = 0; j < w; j++) {
                    graph.get(i).add(Integer.parseInt(split[j]));
                }
            }
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (graph.get(j).get(i) == 0) continue;
                    dfs(j, i, graph);
                    count++;
                }
            }
            System.out.println(count);
            w = scanner.nextInt();
            h = scanner.nextInt();
        }

    }

    private static void dfs(int a, int b, ArrayList<ArrayList<Integer>> graph) {
        if (a >= 0 && a < h && b >= 0 && b < w) {
            if (graph.get(a).get(b) != 0) {

                graph.get(a).remove(b);
                graph.get(a).add(b, 0);

                dfs(a + 1, b, graph);
                dfs(a + 1, b + 1, graph);
                dfs(a + 1, b - 1, graph);
                dfs(a, b + 1, graph);
                dfs(a, b - 1, graph);
                dfs(a - 1, b, graph);
                dfs(a - 1, b + 1, graph);
                dfs(a - 1, b - 1, graph);
            }
        }
    }

}