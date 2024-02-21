
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static HashSet<Integer> answer = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if (i == j || j == k || i == k) continue;
                    answer.add(i * 100 + j * 10 + k);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            int a = scanner.nextInt();
            int s = scanner.nextInt();
            int b = scanner.nextInt();
            HashSet<Integer> make = make(a, s, b);
            Object[] array = answer.toArray();

            for (int j = 0; j < array.length; j++) {
                int i1 = Integer.parseInt(array[j].toString());
                if (!make.contains(i1)) {
                    answer.remove(i1);
                }
            }
        }
        System.out.println(answer.size());
        
    }

    private static HashSet<Integer> make(int a, int s, int b) {
        int A = a / 100;
        int B = (a / 10) % 10;
        int C = a % 10;
        HashSet<Integer> list = new HashSet<>();
        if (s == 3) {
            list.add(a);
        } else if (s == 2) {
            for (int i = 1; i < 10; i++) {
                if (i == A || i == B || i == C) continue;
                list.add(A * 100 + B * 10 + i);
                list.add(A * 100 + i * 10 + C);
                list.add(i * 100 + B * 10 + C);
            }
        } else if (s == 1) {
            if (b == 2) {
                list.add(A * 100 + C * 10 + B);
                list.add(C * 100 + B * 10 + A);
                list.add(B * 100 + A * 10 + C);
            } else if (b == 1) {
                for (int i = 1; i < 10; i++) {
                    if (i == A || i == B || i == C) continue;
                    list.add(A * 100 + C * 10 + i);
                    list.add(A * 100 + i * 10 + B);
                    list.add(B * 100 + i * 10 + C);
                    list.add(i * 100 + A * 10 + C);
                    list.add(C * 100 + B * 10 + i);
                    list.add(i * 100 + B * 10 + A);
                }
            } else {
                for (int i = 1; i < 10; i++) {
                    for (int j = 1; j < 10; j++) {
                        if (i == A || i == B || i == C || i == j) continue;
                        if (j == A || j == B || j == C) continue;
                        list.add(A * 100 + i * 10 + j);
                        list.add(i * 100 + B * 10 + j);
                        list.add(i * 100 + j * 10 + C);
                    }

                }
            }
        } else if (s == 0) {
            if (b == 3) {
                list.add(B * 100 + C * 10 + A);
                list.add(C * 100 + A * 10 + B);
            } else if (b == 2) {
                for (int i = 1; i < 10; i++) {
                    if (i == A || i == B || i == C) continue;
                    list.add(B * 100 + A * 10 + i);
                    list.add(B * 100 + i * 10 + A);
                    list.add(i * 100 + A * 10 + B);

                    list.add(B * 100 + C * 10 + i);
                    list.add(C * 100 + i * 10 + B);
                    list.add(i * 100 + C * 10 + B);

                    list.add(C * 100 + A * 10 + i);
                    list.add(C * 100 + i * 10 + A);
                    list.add(i * 100 + C * 10 + A);
                }
            } else if (b == 1) {
                for (int i = 1; i < 10; i++) {
                    for (int j = 1; j < 10; j++) {
                        if (i == A || i == B || i == C || i == j) continue;
                        if (j == A || j == B || j == C) continue;
                        list.add(i * 100 + A * 10 + j);
                        list.add(i * 100 + j * 10 + A);
                        list.add(i * 100 + j * 10 + B);
                        list.add(B * 100 + i * 10 + j);
                        list.add(C * 100 + i * 10 + j);
                        list.add(i * 100 + C * 10 + j);
                    }
                }
            } else {
                for (int i = 1; i < 10; i++) {
                    for (int j = 1; j < 10; j++) {
                        for (int k = 1; k < 10; k++) {
                            if (i == A || i == B || i == C || i == j) continue;
                            if (j == A || j == B || j == C || j == k) continue;
                            if (k == A || k == B || k == C || i == k) continue;
                            list.add(i * 100 + j * 10 + k);
                        }
                    }
                }
            }
        }
        return list;
    }
}