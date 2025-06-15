//  치즈

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dxy = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }
        while (check()) {
            answer++;
        }
        System.out.println(answer);
    }

    public static boolean check() {
        Queue<int[]> q = new LinkedList<>();
        int[][] result = new int[N][M];
        boolean returnCheck = false;
        boolean checkNM = true;
        // 테두리 체크 + 시작점
        for (int i = 0; i < N; i++) {
            if (i == 0 || i == N - 1) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 0) {
                        checkNM = false;
                        q.add(new int[]{i, j});
                        result[i][j] = -1;
                    }
                }
            } else {
                if (arr[i][0] == 0) {
                    checkNM = false;
                    q.add(new int[]{i, 0});
                    result[i][0] = -1;
                }
                if (arr[i][M - 1] == 0) {
                    checkNM = false;
                    q.add(new int[]{i, M - 1});
                    result[i][M - 1] = -1;
                }
            }
        }
        // 모든 테두리가 1인경우
        if (checkNM) {
            calcNM();
            return true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dxy[i][0];
                int ny = cur[1] + dxy[i][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (arr[nx][ny] == 0 && result[nx][ny] != -1) {
                    result[nx][ny] = -1;
                    q.add(new int[]{nx, ny});
                } else if (arr[nx][ny] == 1) {
                    result[nx][ny]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (result[i][j] < 2) continue;
                arr[i][j] = 0;
                returnCheck = true;
            }
        }
        return returnCheck;
    }

    public static void calcNM() {
        for (int i = 0; i < N; i++) {
            if (i == 0 || i == N - 1) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = 0;
                }
            } else {
                arr[i][0] = 0;
                arr[i][M - 1] = 0;
            }
        }
    }
}