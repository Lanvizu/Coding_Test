import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int d = scanner.nextInt();
        int mm = (m - 1) * 31 + d;
        if (m > 11) {
            mm -= 7;
        } else if (m >= 10) {
            mm -= 6;
        } else if (m >= 7) {
            mm -= 5;
        } else if (m >= 5) {
            mm -= 4;
        } else if (m >= 3) {
            mm -= 3;
        }
        String[] week = new String[7];
        week[0] = "SUN";
        week[1] = "MON";
        week[2] = "TUE";
        week[3] = "WED";
        week[4] = "THU";
        week[5] = "FRI";
        week[6] = "SAT";
        int a = mm % 7;
        System.out.println(week[a]);
    }
}
