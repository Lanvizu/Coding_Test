import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }
        for (int i = 0; i <= N + 1; i++) {
            b.add(0);
        }
        for (int i = 1; i <= N; i++) {
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            a.get(i).add(c);
            a.get(i).add(d);
        }
        for (int i = 1; i <= N; i++) {
            if (i + a.get(i).get(0) <= N + 1) {
                for (int j = i + a.get(i).get(0); j <= N+1; j++) {
                    Integer integer = b.get(j);
                    b.remove(j);
                    b.add(j, Math.max(b.get(i) + a.get(i).get(1), integer));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= N + 1; i++) {
            max = Math.max(b.get(i), max);
        }
        System.out.println(max);
    }
}
