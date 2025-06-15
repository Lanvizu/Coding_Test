//  우주 탐사선

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[][] arr;
    static int result = Integer.MAX_VALUE;
    static boolean[] visited;

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
        visited = new boolean[N];
        visited[K] = true;
        dfs(K, 1, 0);
        System.out.println(result);
    }

    public static void dfs(int cur, int cnt, int cost) {
        if (cnt == N) {
            result = Math.min(result, cost);
            return ;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(i, cnt + 1, cost + arr[cur][i]);
            visited[i] = false;
        }
    }
}