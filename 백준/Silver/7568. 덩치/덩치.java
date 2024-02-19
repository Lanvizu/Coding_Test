import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] a = new int[N][2];
        int[] count = new int[N];

        for (int i = 0; i < N; i++) {
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            a[i][0] = b;
            a[i][1] = c;
            count[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (a[i][0] < a[j][0] && a[i][1] < a[j][1]) {
                    count[i]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(count[i] + " ");
        }
    }
}