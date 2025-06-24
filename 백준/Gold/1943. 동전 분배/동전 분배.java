//  동전 분배

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());
            int total = 0;
            List<int[]> coins = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String[] s = br.readLine().split(" ");
                int v = Integer.parseInt(s[0]);
                int c = Integer.parseInt(s[1]);
                coins.add(new int[]{v, c});
                total += v * c;
            }
            if (total % 2 != 0) {
                System.out.println(0);
                continue;
            }
            calc(coins, total / 2);
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

            for (int i = 0; i <= target; i++) {
                if (dp[i]) used[i] = 0;
            }

            for (int i = v; i <= target; i++) {
                if (!dp[i] && dp[i - v] && used[i - v] < c) {
                    dp[i] = true;
                    used[i] = used[i - v] + 1;
                }
            }
        }
        System.out.println(dp[target] ? 1 : 0);
    }
}