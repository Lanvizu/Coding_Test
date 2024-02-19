import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[][] a = new int[N + 1][3];

        for (int i = 0; i < N; i++) {
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int e = scanner.nextInt();
            a[b][0] = c;
            a[b][1] = d;
            a[b][2] = e;
        }
        int count = getCount(a, K, N);
        System.out.println(count);
    }

    private static int getCount(int[][] a, int K, int N) {
        int b = a[K][0];
        int c = a[K][1];
        int d = a[K][2];
        int count = 1;
        for (int i = 1; i <= N; i++) {
            if (i != K) {
                if (a[i][0] > b) {
                    count++;
                } else if (a[i][0] == b) {
                    if (a[i][1] > c) {
                        count++;
                    } else if (a[i][1] == c) {
                        if (a[i][2] > d) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
