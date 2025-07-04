//  마법사 상어와 토네이도

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int N;
    static int total = 0;
    static int[][] arr;
    static int[][][] sandPattern = new int[4][9][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        initSandPattern();
        move();
    }

    public static void move() {
        int x = N / 2;
        int y = N / 2;
        int length = 1;
        int cnt = 0;
        int dir = 3;
        while (true) {
            // 좌회전
            dir = (dir + 1) % 4;
            if (cnt == 2) {
                cnt = 0;
                length++;
            }
            for (int i = 0; i < length; i++) {
                x += dx[dir];
                y += dy[dir];
                calcSandStorm(x, y, dir);
                if (x == 0 && y == 0) {
                    System.out.println(total);
                    return;
                }
            }
            cnt++;
        }
    }

    public static void calcSandStorm(int x, int y, int dir) {
        int now = arr[x][y];
        arr[x][y] = 0;
        int remaining = now;
        int[][] pattern = sandPattern[dir];

        for (int i = 0; i < 9; i++) {
            int nx = x + pattern[i][0];
            int ny = y + pattern[i][1];
            int amount = now * pattern[i][2] / 100;

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                total += amount;
            } else {
                arr[nx][ny] += amount;
            }
            remaining -= amount;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
            total += remaining;
        } else {
            arr[nx][ny] += remaining;
        }
    }

    public static void initSandPattern() {
        // 전체 회전
        for (int i = 0; i < 4; i++) {
            // 7%
            sandPattern[i][0] = new int[]{dx[(3 + i) % 4], dy[(3 + i) % 4], 7};
            sandPattern[i][1] = new int[]{dx[(1 + i) % 4], dy[(1 + i) % 4], 7};
            // 2%
            sandPattern[i][2] = new int[]{2 * dx[(3 + i) % 4], 2 * dy[(3 + i) % 4], 2};
            sandPattern[i][3] = new int[]{2 * dx[(1 + i) % 4], 2 * dy[(1 + i) % 4], 2};
            // 1%
            sandPattern[i][4] = new int[]{dx[(3 + i) % 4] + dx[(2 + i) % 4],
                    dy[(3 + i) % 4] + dy[(2 + i) % 4], 1};
            sandPattern[i][5] = new int[]{dx[(1 + i) % 4] + dx[(2 + i) % 4],
                    dy[(1 + i) % 4] + dy[(2 + i) % 4], 1};
            // 10%
            sandPattern[i][6] = new int[]{dx[(3 + i) % 4] + dx[i], dy[(3 + i) % 4] + dy[i], 10};
            sandPattern[i][7] = new int[]{dx[(1 + i) % 4] + dx[i], dy[(1 + i) % 4] + dy[i], 10};
            // 5%
            sandPattern[i][8] = new int[]{2 * dx[i], 2 * dy[i], 5};
        }
    }
}