import java.util.Scanner;

public class Main {
    static String[][] strings;
    static int min = 64;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        strings = new String[N][M];

        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            String[] split = s.split("");
            for (int j = 0; j < M; j++) {
                strings[i][j] = split[j];
            }
        }
        for (int i = 7; i < N; i++) {
            for (int j = 7; j < M; j++) {
                int a = W_count(i, j);
                int b = B_count(i, j);
                int c = Math.min(a, b);
                min = Math.min(c, min);
            }
        }
        System.out.println(min);
    }

    private static int W_count(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (strings[x - (i * 2)][y - (2 * j)].equals("W")) continue;
                count++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (strings[x - (i * 2) - 1][y - (2 * j) - 1].equals("W")) continue;
                count++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (strings[x - (i * 2) - 1][y - (2 * j)].equals("B")) continue;
                count++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (strings[x - (i * 2)][y - (2 * j) - 1].equals("B")) continue;
                count++;
            }
        }
        return count;
    }

    private static int B_count(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (strings[x - (i * 2)][y - (2 * j)].equals("B")) continue;
                count++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (strings[x - (i * 2) - 1][y - (2 * j) - 1].equals("B")) continue;
                count++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (strings[x - (i * 2) - 1][y - (2 * j)].equals("W")) continue;
                count++;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (strings[x - (i * 2)][y - (2 * j) - 1].equals("W")) continue;
                count++;
            }
        }
        return count;
    }
}
