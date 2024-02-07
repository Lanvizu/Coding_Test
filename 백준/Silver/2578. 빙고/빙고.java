
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 빙고판 입력 받기
        int[][] bingoBoard = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bingoBoard[i][j] = scanner.nextInt();
            }
        }

        // 빙고 여부를 체크할 배열
        boolean[][] checked = new boolean[5][5];

        // 사회자가 부르는 수 입력 받기
        int[] calledNumbers = new int[25];
        for (int i = 0; i < 25; i++) {
            calledNumbers[i] = scanner.nextInt();
        }

        // 사회자가 숫자를 부를 때마다 빙고 여부 확인
        for (int i = 0; i < 25; i++) {
            int number = calledNumbers[i];
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    if (bingoBoard[row][col] == number) {
                        checked[row][col] = true;
                        if (checkBingo(checked) >= 3) {
                            System.out.println(i + 1);
                            return;
                        }
                    }
                }
            }
        }

        scanner.close();
    }

    static int checkBingo(boolean[][] checked) {
        int count = 0;
        // 가로, 세로 확인
        for (int i = 0; i < 5; i++) {
            if (checked[i][0] && checked[i][1] && checked[i][2] && checked[i][3] && checked[i][4]) {
                count++;
            }
            if (checked[0][i] && checked[1][i] && checked[2][i] && checked[3][i] && checked[4][i]) {
                count++;
            }
        }
        // 대각선 확인
        if (checked[0][0] && checked[1][1] && checked[2][2] && checked[3][3] && checked[4][4]) {
            count++;
        }
        if (checked[0][4] && checked[1][3] && checked[2][2] && checked[3][1] && checked[4][0]) {
            count++;
        }
        return count;
    }
}
