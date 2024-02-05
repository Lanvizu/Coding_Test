import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(scanner.nextInt());
        }

        int size = list.size();
        for (int i = size - 1; i >= 0; i--) {
            if (K / list.get(i) != 0) {
                count += K / list.get(i);
                K = K % list.get(i);
            }
        }
        if (K != 0) {
            count++;
        }
        System.out.println(count);
    }
}