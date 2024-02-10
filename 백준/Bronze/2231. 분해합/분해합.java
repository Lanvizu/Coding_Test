import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 1; i <= N; i++) {
            String s = Integer.toString(i);
            String[] split1 = s.split("");
            int sum = 0;
            for (int j = 0; j < split1.length; j++) {
                sum += Integer.parseInt(split1[j]);
            }
            if (i + sum == N) {
                System.out.println(i);
                break;
            }
            if (i == N) {
                System.out.println(0);
            }
        }
        
    }
}