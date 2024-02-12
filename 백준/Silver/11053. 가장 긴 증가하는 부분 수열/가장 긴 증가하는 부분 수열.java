import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] visited = new int[1001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
            visited[i] = 0;
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (a[i] < a[j]) {
                    if (visited[i] + 1 > visited[j]) {
                        visited[j]++;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(visited[i], max);
        }
        System.out.println(max+1);
    }
}
