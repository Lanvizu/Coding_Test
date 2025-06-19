//  성냥개비

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static String[] dp = new String[101];
    static String MAX_STR = "1".repeat(51);
    static int[] arr = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    static String compareString(String a, String b) {
        if (a.length() == b.length()) {
            if (a.compareTo(b) < 0) return a;
            else return b;
        }
        if (a.length() < b.length()) return a;
        else return b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < 101; i++) dp[i] = MAX_STR;
        dp[0] = "";
        for (int i = 2; i < 101; i++) {
            for (int j = 0; j < 10; j++) {
                if (i < arr[j]) continue;
                if (j == 0 && dp[i - arr[j]].equals("")) continue;
                dp[i] = compareString(dp[i], dp[i - arr[j]] + j);
            }
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String maxResult = calcMax(n);
            System.out.println(dp[n] + " " + maxResult);
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