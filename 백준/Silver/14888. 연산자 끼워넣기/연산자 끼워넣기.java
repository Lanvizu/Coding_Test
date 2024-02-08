import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int min = 1000000000;
    static int max = -1000000000;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            a.add(scanner.nextInt());
        }
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            b.add(scanner.nextInt());
        }

        dfs(1, b, a, a.get(0));
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, ArrayList<Integer> b, ArrayList<Integer> a, int sum) {
        if (depth == N) {
            min = Math.min(sum, min);
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            Integer i1 = b.get(i);
            if (i1 == 0) continue;
            int x = x(sum, a.get(depth), i);
            b.remove(i);
            b.add(i, i1 - 1);
            dfs(depth + 1, b, a, x);
            b.remove(i);
            b.add(i, i1);
        }
    }

    static int x(int a, int b, int x) {
        if (x == 0) {
            return a + b;
        } else if (x == 1) {
            return a - b;
        } else if (x == 2) {
            return a * b;
        } else {
            return a / b;
        }
    }
}