import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int min = 100;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        boolean[] visited = new boolean[N];
        visited[0] = true;

        for (int i = 0; i < N; i++) {
            a.add(new ArrayList<>());
        }
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            for (int j = 0; j < N; j++) {
                a.get(i).add(Integer.parseInt(s1[j]));
            }
        }

        comb(a, visited, 1, N, N / 2 - 1);

        System.out.println(min);

    }

    static void comb(ArrayList<ArrayList<Integer>> a, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            int sumTotal = sum_total(a, visited);
            min = Math.min(min, sumTotal);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(a, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static int sum_total(ArrayList<ArrayList<Integer>> a, boolean[] visited) {
        int count_a = 0;
        int count_b = 0;
        for (int i = 0; i < visited.length - 1; i++) {
            if (visited[i]) {
                for (int j = i + 1; j < visited.length; j++) {
                    if (visited[j]) {
                        count_a += a.get(i).get(j);
                        count_a += a.get(j).get(i);
                    }
                }
            } else {
                for (int j = i + 1; j < visited.length; j++) {
                    if (!visited[j]) {
                        count_b += a.get(i).get(j);
                        count_b += a.get(j).get(i);
                    }
                }
            }
        }
        if (count_a > count_b) {
            return count_a - count_b;
        }
        return count_b - count_a;
    }
}