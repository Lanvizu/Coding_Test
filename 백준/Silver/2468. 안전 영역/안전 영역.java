import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int N, count, totalCount;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int max = 0;
        int min = 101;

        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            for (int j = 0; j < N; j++) {
                int i1 = Integer.parseInt(split[j]);
                max = Math.max(max, i1);
                min = Math.min(min, i1);
                graph.get(i).add(i1);
            }
        }
        totalCount = 1;
        for (int i = min; i < max; i++) {
            count = 0;
            ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
            for (int a = 0; a < N; a++) {
                graph2.add(new ArrayList<>());
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    graph2.get(j).add(k, graph.get(j).get(k));
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (graph2.get(j).get(k) > i) {
                        dfs(k, j, i, graph2);
                        count++;
                    }
                }
            }
            totalCount = Math.max(totalCount, count);
        }
        System.out.println(totalCount);
    }

    private static void dfs(int x, int y, int h, ArrayList<ArrayList<Integer>> graph2) {

        if (x >= 0 && x < N && y >= 0 && y < N) {
            if (graph2.get(y).get(x) > h) {
                graph2.get(y).remove(x);
                graph2.get(y).add(x, 0);

                dfs(x + 1, y, h, graph2);
                dfs(x, y + 1, h, graph2);
                dfs(x, y - 1, h, graph2);
                dfs(x - 1, y, h, graph2);
            }
        }
    }

}
