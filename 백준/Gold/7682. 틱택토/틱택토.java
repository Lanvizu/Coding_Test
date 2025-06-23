//  틱택토

import java.util.*;
import java.lang.*;
import java.io.*;

//        - X 개수 == O 개수 or X 개수 == O 개수 + 1 이어야 함
//        - X가 이긴 경우 → X 개수 == O 개수 + 1
//        - O가 이긴 경우 → X 개수 == O 개수
//        - 둘 다 동시에 이길 수 없음
//        - 아무도 안 이기고, 칸이 다 찼다면 valid

class Main {
    static int[][] winCases = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // 가로
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // 세로
            {0, 4, 8}, {2, 4, 6}           // 대각선
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine()).equals("end")) {
            char[] board = input.toCharArray();
            int xCount = 0, oCount = 0;
            for (char c : board) {
                if (c == 'X') xCount++;
                if (c == 'O') oCount++;
            }

            boolean xWin = isWin(board, 'X');
            boolean oWin = isWin(board, 'O');

            boolean valid = false;
            if (xCount == oCount + 1 && xWin && !oWin) valid = true;
            else if (xCount == oCount && oWin && !xWin) valid = true;
            else if (!xWin && !oWin && xCount + oCount == 9 && xCount > oCount) valid = true;

            System.out.println(valid ? "valid" : "invalid");
        }
    }

    public static boolean isWin(char[] board, char c) {
        for (int[] line : winCases) {
            if (board[line[0]] == c && board[line[1]] == c && board[line[2]] == c) {
                return true;
            }
        }
        return false;
    }
}