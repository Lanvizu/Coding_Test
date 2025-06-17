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
            calcStartEnd();
            calc('R');
            calc('B');
        }
        System.out.println(answer);
    }

    public static void calc(char target) {
        int result = 0;
        int start = Character.getNumericValue(startAndEnd[0][1]);
        int end = Character.getNumericValue(startAndEnd[1][1]);
        if (startAndEnd[0][0] == target && startAndEnd[1][0] == target) {
            if (start >= end) {
                result = calcArr(target, start, N);
            } else {
                result = calcArr(target, 0, N - end);
            }
        } else if (startAndEnd[0][0] == target) {
            result = calcArr(target, start, N);
        } else if (startAndEnd[1][0] == target) {
            result = calcArr(target, 0, N - end);
        } else {
            result = calcArr(target, 0, N);
        }
        answer = Math.min(result, answer);
    }

    public static int calcArr(char target, int start, int end) {
        int result = 0;
        for (int i = start; i < end; i++) {
            if (arr[i] == target) {
                result++;
            }
        }
        return result;
    }

    public static void calcStartEnd() {
        startAndEnd[0][0] = arr[0];
        startAndEnd[1][0] = arr[N - 1];
        int cnt1 = 1, cnt2 = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[0]) {
                cnt1++;
            } else {
                startAndEnd[0][1] = Integer.toString(cnt1).charAt(0);
                break;
            }
        }
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] == arr[N - 1]) {
                cnt2++;
            } else {
                startAndEnd[1][1] = Integer.toString(cnt2).charAt(0);
                break;
            }
        }
    }
}