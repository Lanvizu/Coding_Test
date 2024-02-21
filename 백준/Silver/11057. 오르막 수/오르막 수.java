import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] count = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            count[0][i] = 1;
        }
        for (int i = 1; i <= N; i++) {
            count[i][0] = 1;
            for (int j = 1; j < 10; j++) {
                count[i][j] = (count[i - 1][j] + count[i][j - 1]) % 10007;
            }
        }
        System.out.println(count[N][9]);
    }
}
