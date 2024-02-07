import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int money = s.nextInt();
        int[] days = new int[14];
        int a_money = money;
        int b_money = money;
        int a = 0;
        int b = 0;
        for (int i = 0; i < 14; i++) {
            days[i] = s.nextInt();
        }
        for (int i = 0; i < 14; i++) {
            if (a_money >= days[i]) {
                a += a_money / days[i];
                a_money = a_money % days[i];
            }
        }

        int count = 0;
        int before_day = days[0];
        for (int i = 1; i < 14; i++) {
            if (before_day < days[i]) {
                if (count >= 0) {
                    count++;
                } else {
                    count = 1;
                }
            } else if (before_day > days[i]) {
                if (count <= 0) {
                    count--;
                } else {
                    count = -1;
                }
            } else {
                count = 0;
            }
            before_day = days[i];

            if (count <= -3) {
                b += b_money / days[i];
                b_money = b_money % days[i];
            } else if (count >= 3) {
                b_money += days[i] * b;
                b = 0;
            }
        }
        a_money += a * days[13];
        b_money += b * days[13];

        if (a_money > b_money) {
            System.out.println("BNP");
        } else if (b_money > a_money) {
            System.out.println("TIMING");
        } else System.out.println("SAMESAME");
    }
}