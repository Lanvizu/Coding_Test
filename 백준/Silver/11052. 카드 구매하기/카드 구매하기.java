import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] cards = new int[N + 1];
        int[] max = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cards[i] = scanner.nextInt();
        }
        max[1] = cards[1];
        dp(N, cards, max);
        System.out.println(max[N]);

    }

    private static void dp(int N, int[] cards, int[] max) {
        for (int i = 2; i <= N; i++) {
            max[i] = cards[i];
            for (int j = 1; j <= i / 2; j++) {
                max[i] = Math.max(max[i], max[j] + max[i - j]);
            }
            if (i % 2 == 0) {
                max[i] = Math.max(max[i], max[i / 2] * 2);
            }
        }
    }
}