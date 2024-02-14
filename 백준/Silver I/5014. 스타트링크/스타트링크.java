import java.util.Scanner;

public class Main {
    static int F, S, G, U, D;
    static int min = 10000001;
    static int a = 0;
    static int[] visited;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        F = scanner.nextInt();
        S = scanner.nextInt();
        G = scanner.nextInt();
        U = scanner.nextInt();
        D = scanner.nextInt();

        visited = new int[F + 1];
        for (int i = 1; i <= F; i++) {
            visited[i] = 0;
        }

        dfs(S, 0);

        if (S == G) {
            System.out.println(0);
        } else if (a != 1) {
            System.out.println("use the stairs");
        } else
            System.out.println(min);
    }

    private static void dfs(int n, int count) {

        if (n == G) {
            a = 1;
            min = Math.min(count, min);
            return;
        }
        visited[n] = count;
        if (n < G) {
            if (n + U <= F) {
                if (visited[n + U] != 0) return;
                dfs(n + U, count + 1);
            } else if (n - D > 0) {
                if (visited[n - D] != 0) return;
                dfs(n - D, count + 1);
            }
        } else {
            if (n - D > 0) {
                if (visited[n - D] != 0) return;
                dfs(n - D, count + 1);
            } else if (n + U <= F) {
                if (visited[n + U] != 0) return;
                dfs(n + U, count + 1);
            }
        }
    }
}
