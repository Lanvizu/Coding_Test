
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] triNum = new int[45];
        for (int i = 1; i < 45; i++) {
            triNum[i] = i * (i + 1) / 2;
        }
        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            int eureka = eureka(a, triNum);
            System.out.println(eureka);
        }
    }

    public static int eureka(int a, int[] triNum) {
        for(int j = 1; j < 45; j++) {
            for (int k = 1; k < 45; k++) {
                for (int z = 1; z < 45; z++) {
                    int sum = triNum[j] + triNum[k] + triNum[z];
                    if (sum == a) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
