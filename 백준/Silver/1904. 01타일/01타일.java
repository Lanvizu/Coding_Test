import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int dp = dp(N);
        System.out.println(dp);
    }

    private static int dp(int a) {
        int[] answer = new int[a + 1];
        answer[1] = 1;
        if (a >= 2) {
            answer[2] = 2;
        }
        if (a >= 3) {
            for (int i = 3; i <= a; i++) {
                answer[i] = (answer[i - 1] + answer[i - 2]) % 15746;
            }
        }
        return answer[a];
    }
}
