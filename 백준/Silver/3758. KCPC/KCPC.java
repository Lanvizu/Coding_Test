//  KCPC

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int time = 0; time < T; time++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n + 1][k + 3];
            // k+1: 제출 횟수, k+2: 제출 시간

            for (int a = 0; a < m; a++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                // 문제 풀이 수
                arr[i][k + 1]++;
                arr[i][k + 2] = a;
                if (arr[i][j] < s) {
                    arr[i][0] -= arr[i][j];
                    arr[i][j] = s;
                    arr[i][0] += s;
                }
            }
            calcArr(arr, n, k, t);
        }
    }

    public static void calcArr(int[][] arr, int n, int k, int t) {
        int target = arr[t][0];
        int result = 1;
        for (int i = 1; i <= n; i++) {
            if (i == t) continue;
            if (arr[i][0] > target) {
                result++;
            } else if (arr[i][0] == target) {
                // 적게 낸 경우
                if (arr[i][k + 1] < arr[t][k + 1]) {
                    result++;
                } else if (arr[i][k + 1] == arr[t][k + 1]) {
                    // 더 빨리 낸 경우
                    if (arr[i][k + 2] < arr[t][k + 2]) {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}