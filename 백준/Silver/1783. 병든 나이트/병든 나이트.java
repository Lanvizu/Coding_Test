import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int count = 1;
        if (N == 1) {
            System.out.println(count);
        } else if (N == 2) {
            if (M < 3) {
                System.out.println(1);
            } else if (M < 5) {
                System.out.println(2);
            } else if (M < 7) {
                System.out.println(3);
            } else {
                System.out.println(4);
            }
        } else {
            if (M == 1) {
                System.out.println(count);
            } else if (M == 2) {
                count++;
                System.out.println(count);
            } else if (M == 3) {
                System.out.println(3);
            } else if (M==4||M == 5 || M ==6 ) {
                System.out.println(4);
            } else {
                count = 5;
                M -= 7;
                count += M;
                System.out.println(count);
            }
        }

    }
}