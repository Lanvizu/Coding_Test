import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int[] time = new int[101];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            max = Math.max(b, max);
            for (int j = a; j < b; j++) {
                time[j] += 1;
            }
        }
        int count = 0;
        for (int i = 1; i < max; i++) {
            if (time[i] == 3) {
                count += (C * 3);
            } else if (time[i] == 2) {
                count += (B * 2);
            } else if (time[i] == 1) {
                count += A;
            }
        }
        System.out.println(count);
    }
}
