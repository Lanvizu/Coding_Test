//  우주 탐사선

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                }
            }
        }
        boolean[] visited = new boolean[N];
        visited[K] = true;
        dp(visited, K, 0);
        System.out.println(result);
    }

    public static void dp(boolean[] visited, int now, int cnt) {
        if (cnt > result) {
            return;
        }

        // 모든 visited가 처리된 경우에는 return
        int visited_cnt = 0;
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                visited_cnt++;
                continue;
            }
            boolean checkI = false;
            visited[i] = true;
            dp(visited, i, cnt + arr[now][i]);
            visited[i] = false;
        }
        if(visited_cnt == N) {
            result = Math.min(result, cnt);
            return;
        }
    }
}