import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N, count, totalCount;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<Integer> countList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String[] split = line.split("");

            for (String a : split) {
                int i1 = Integer.parseInt(a);
                graph.get(i).add(i1);
            }
        }

        countList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(graph.get(i).get(j)==0) continue;
                dfs(i, j);
                countList.add(count);
                count = 0;
                totalCount++;
            }
        }
        System.out.println(totalCount);
        Collections.sort(countList);

        for (Integer integer : countList) {
            System.out.println(integer);
        }
    }

    static void dfs(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N) {
            if (graph.get(x).get(y) == 1) {
                count++;
                graph.get(x).remove(y);
                graph.get(x).add(y, 0);
                dfs(x + 1, y);
                dfs(x, y + 1);
                dfs(x - 1, y);
                dfs(x, y - 1);
            }
        }
    }

}