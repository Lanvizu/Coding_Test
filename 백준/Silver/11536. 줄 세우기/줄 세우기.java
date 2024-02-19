
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        String[] a = new String[N];
        String[] b = new String[N];
        String[] c = new String[N];
        scanner.nextLine();
        for (int i = 0; i < N; i++) {
            String s = scanner.nextLine();
            a[i] = s;
            b[i] = s;
            c[i] = s;
        }
        Arrays.sort(b);
        Arrays.sort(c, Comparator.reverseOrder());

        String answer = "";
        for (int i = 0; i < N; i++) {
            if (a[i].equals(b[i])) {
                answer = "INCREASING";
            } else if (a[i].equals(c[i])) {
                answer = "DECREASING";
            } else {
                answer = "NEITHER";
                break;
            }
        }
        System.out.println(answer);
    }
}
