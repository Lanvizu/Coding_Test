//  미세먼지 안녕!

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int R, C, T;
    static int[][] dust;
    static int ac, total;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        dust = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a != 0) {
                    dust[i][j] = a;
                    if (a == -1) {
                        ac = i;
                    }
                }
            }
        }
        int cnt = 0;
        while (cnt < T) {
            total = 0;
            diff();
            operateAC();
            cnt++;
        }
        System.out.println(total);
    }

    public static void diff() {
        int[][] newDust = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int nd = dust[i][j];
                if (nd == 0) continue;
                if (nd == -1) {
                    newDust[i][j] = -1;
                    continue;
                }
                int newND = nd / 5;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dir[k][0];
                    int ny = j + dir[k][1];
                    // 벽 밖
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    // 공청기
                    if (ny == 0 && (nx == ac || nx == ac - 1)) continue;
                    newDust[nx][ny] += newND;
                    total += newND;
                    nd -= newND;
                }
                newDust[i][j] += nd;
                total += nd;
            }
        }
        dust = newDust;
    }

    public static void operateAC() {
        int ac1 = ac - 1;
        // 사라지는 미세먼지
        total -= dust[ac1 - 1][0] + dust[ac + 1][0];
        // 반시계
        for (int i = ac1 - 1; i > 0; i--) dust[i][0] = dust[i - 1][0];

        for (int j = 0; j < C - 1; j++) dust[0][j] = dust[0][j + 1];

        for (int i = 0; i < ac1; i++) dust[i][C - 1] = dust[i + 1][C - 1];

        for (int j = C - 1; j > 1; j--) dust[ac1][j] = dust[ac1][j - 1];

        dust[ac1][1] = 0;
        // 시계
        for (int i = ac + 1; i < R - 1; i++) dust[i][0] = dust[i + 1][0];

        for (int j = 0; j < C - 1; j++) dust[R - 1][j] = dust[R - 1][j + 1];

        for (int i = R - 1; i > ac; i--) dust[i][C - 1] = dust[i - 1][C - 1];

        for (int j = C - 1; j > 1; j--) dust[ac][j] = dust[ac][j - 1];

        dust[ac][1] = 0;
    }
}