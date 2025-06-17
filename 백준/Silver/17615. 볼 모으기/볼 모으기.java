//  볼 모으기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static char[] arr;
    static char[][] startAndEnd = new char[2][2];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();

        if (input.length() < 3 || input.indexOf('R') == -1 || input.indexOf('B') == -1) {
            answer = 0;
        } else {
            arr = input.toCharArray();
            answer = Math.min(answer, countMoves('R', true));
            answer = Math.min(answer, countMoves('R', false));
            answer = Math.min(answer, countMoves('B', true));
            answer = Math.min(answer, countMoves('B', false));
        }
//            System.out.println(Arrays.toString(arr));
//            System.out.println(Arrays.deepToString(startAndEnd));
        System.out.println(answer);
    }

    public static int countMoves(char color, boolean toLeft) {
        int count = 0;

        if (toLeft) {
            // 왼쪽 연속된 동일색 제외
            int i = 0;
            while (i < N && arr[i] == color) i++;
            for (; i < N; i++) {
                if (arr[i] == color) count++;
            }
        } else {
            // 오른쪽 연속된 동일색 제외
            int i = N - 1;
            while (i >= 0 && arr[i] == color) i--;
            for (; i >= 0; i--) {
                if (arr[i] == color) count++;
            }
        }

        return count;
    }
}