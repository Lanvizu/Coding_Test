import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] stair = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            stair[i] = scanner.nextInt();
        }
        int[] sum = new int[N + 1];
        sum[0] = 0;
        sum[1] = stair[1];
        if (N > 1) {
            sum[2] = stair[1] + stair[2];
        }
        if (N >= 3) {
            for (int i = 3; i <= N; i++) {
                sum[i] = stair[i] + Math.max(stair[i - 1] + sum[i - 3], sum[i - 2]);
            }
        }
        System.out.println(sum[N]);
    }
}
