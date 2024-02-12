import java.util.Scanner;


public class Main {
    static int[] d = new int[10000];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(dp(N));
    }

    private static int dp(int a) {
        if (a <= 2) {
            return a;
        } else {
            if (d[a] > 0)
                return d[a];
            d[a] = (dp(a - 1) + dp(a - 2)) % 10007;
        }
        return d[a];
    }
}