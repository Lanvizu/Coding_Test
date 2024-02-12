import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        int[] ints = new int[N];
        ints[0] = 1;
        if (N > 1) {
            ints[1] = 3;
        }
        if (N > 2) {
            for (int i = 2; i < N; i++) {
                ints[i] = (ints[i - 1] + 2 * ints[i - 2]) % 10007;

            }
        }
        System.out.println(ints[N - 1]);

    }
}
