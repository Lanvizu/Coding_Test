import java.util.Scanner;

public class Main {
    static int[][] map;
    static int a, b, c, d;
    static int min = 101;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();

        Boolean[] visited = new Boolean[a + 1];
        map = new int[a + 1][a + 1];
        for (int i = 1; i <= a; i++) {
            visited[i] = false;
            for (int j = 1; j <= a; j++) {
                map[i][j] = 0;
            }
        }
        for (int i = 0; i < d; i++) {
            int e = scanner.nextInt();
            int f = scanner.nextInt();
            map[e][f] = 1;
            map[f][e] = 1;
        }

        if (b < c) {
            visited[b] = true;
            dfs_A(b, c, 0, visited);
        } else {
            visited[c] = true;
            dfs_A(c, b, 0, visited);
        }

        if (min == 101) {
            System.out.println(-1);
        } else System.out.println(min);
    }

    private static void dfs_A(int x, int y, int count, Boolean[] visited) {
        if (x == y) {
            min = Math.min(min, count);
            return;
        }
        for (int i = 1; i <= a; i++) {
            if (map[x][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs_A(i, y, count+1, visited);
                visited[i] = false;
            }
        }
    }
}
