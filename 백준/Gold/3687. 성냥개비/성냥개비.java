//  성냥개비

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static long[] arr = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initArr();
        for (int i = 8; i <= 100; i++) {
            dp(i);
        }
        arr[6] = 6;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String maxResult = calcMax(n);
            System.out.println(arr[n] + " " + maxResult);
        }
//        for (int i = 2; i < 101; i++) {
//            System.out.println(i + " " + arr[i]);
//        }
    }

    public static void initArr() {
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 7;
        arr[4] = 4;
        arr[5] = 2;
        arr[6] = 0;
        arr[7] = 8;
    }

    public static void dp(int n) {
        int t = 0;
        for (int i = 2; i <= n/2; i++) {
            int j = n - i;
            // 각 수의 첫자리를 비교, 0인 경우는 6개 밖에 없음
            int a = Integer.parseInt(("" + arr[i]).substring(0, 1));
            int b = Integer.parseInt((arr[j] + "").substring(0, 1));
            // 둘 다 0이 아닌 경우
            if (a != 0 && b != 0) {
                if (a <= b) {
                    calc(n, arr[i], arr[j]);
                } else {
                    calc(n, arr[j], arr[i]);
                }
            } else if (a == 0) {
                if (6 < b) {
                    calc(n, 6, arr[j]);
                } else if (b > 0) {
                    calc(n, arr[j], 0);
                }
            } else if (b == 0) {
                if (6 < a) {
                    calc(n, 6, arr[i]);
                } else if (a > 0) {
                    calc(n, arr[i], 0);
                }
            }
        }
    }

    public static void calc(int n, long a, long b) {
        long result = Long.parseLong(a + "" + b);
        if (arr[n] == 0) {
            arr[n] = result;
        } else {
            arr[n] = Math.min(arr[n], result);
        }
    }

    public static String calcMax(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                sb.append(1);
            }
        } else {
            sb.append(7);
            for (int i = 0; i < (n - 3) / 2; i++) {
                sb.append(1);
            }
        }
        return sb.toString();
    }
}