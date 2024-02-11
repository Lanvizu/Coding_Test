import java.util.Scanner;

public class Main {
    static int min = 1000000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        c(N, 0);
        System.out.println(min);

    }

    private static void c(int a, int b) {
        if (a == 1) {
            min = Math.min(min, b);
            return;
        }
        if (min < b) return;

        if (a % 3 == 0) {
            int count = b;
            count++;
            c(a / 3, count);
        }
        if (a % 2 == 0) {
            int count = b;
            count++;
            c(a / 2, count);
        }
        c(a - 1, b + 1);
    }
}