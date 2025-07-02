//  주사위 굴리기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M, x, y;
    static int[][] graph;
    static int[] move;
    static int[][] dir = new int[][]{{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    // 상하좌우 다음 예상
    static int[][] dice = new int[4][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        move = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        calc(0, x, y);
    }

    public static void calc(int v, int nx, int ny) {
        if (v >= move.length) return;
        int nextX = nx + dir[move[v]][0];
        int nextY = ny + dir[move[v]][1];
        if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
            calc(v + 1, nx, ny);
            return;
        }
        int[] nd = dice[move[v] - 1];

        if (graph[nextX][nextY] == 0) {
            graph[nextX][nextY] = nd[0];
        } else {
            nd[0] = graph[nextX][nextY];
            graph[nextX][nextY] = 0;
        }
        calcDice(nd);
        System.out.println(nd[5]);
        calc(v + 1, nextX, nextY);
    }

    public static void calcDice(int[] now) {
        //우
        dice[0] = new int[]{now[2], now[1], now[5], now[0], now[4], now[3]};
        //좌
        dice[1] = new int[]{now[3], now[1], now[0], now[5], now[4], now[2]};
        //상
        dice[2] = new int[]{now[1], now[5], now[2], now[3], now[0], now[4]};
        //하
        dice[3] = new int[]{now[4], now[0], now[2], now[3], now[5], now[1]};
    }
}