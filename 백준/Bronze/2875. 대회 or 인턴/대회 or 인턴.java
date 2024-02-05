import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        for (int i = 0; i < K; i++) {
            if (M * 2 <= N) {
                N--;
            } else if (M * 2 > N) {
                M--;
            }
        }
        int count = N / 2;
        if (N / 2 > M) {
            count = M;
        }
        System.out.println(count);
    }
}
