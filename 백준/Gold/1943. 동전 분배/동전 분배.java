//  동전 분배

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stage = 3;
        while (stage > 0) {
            int N = Integer.parseInt(br.readLine());
            List<int[]> coins = new ArrayList<>();
            int total = 0;
            for (int i = 0; i < N; i++) {
                String[] s = br.readLine().split(" ");
                int v = Integer.parseInt(s[0]);
                int c = Integer.parseInt(s[1]);
                coins.add(new int[]{v, c});
                total += v * c;
            }
            if (total % 2 != 0) {
                System.out.println(0);
                stage--;
                continue;
            }
            calc(coins, total / 2);
            stage--;
        }
    }

    public static void calc(List<int[]> coins, int target) {
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int[] coin : coins) {
            int v = coin[0];
            int c = coin[1];
            int[] used = new int[target + 1];
            Arrays.fill(used, -1);
            for (int j = 0; j <= target; j++) {
                if (dp[j]) used[j] = 0;
            }
            for (int j = v; j <= target; j++) {
                if (!dp[j] && j >= v && dp[j - v] && used[j - v] < c) {
                    dp[j] = true;
                    used[j] = used[j - v] + 1;
                }
            }
        }
        System.out.println(dp[target] ? 1 : 0);
    }
}