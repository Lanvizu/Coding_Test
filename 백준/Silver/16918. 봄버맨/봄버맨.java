//  봄버맨

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[][] dxy = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int R = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        int N = Integer.parseInt(s[2]);

        char[][] graph1 = new char[R][C];
        char[][] graph2 = new char[R][C];
        char[][] graph3 = new char[R][C];
        char[][] graph4 = new char[R][C];
        for (int i = 0; i < R; i++) {
            graph1[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < C; j++) {
                graph2[i][j] = 'O';
                graph3[i][j] = 'O';
                graph4[i][j] = 'O';
            }
        }
        calc(R, C, N, graph1, graph3);
        calc(R, C, N, graph3, graph4);
        if (N == 1) {
            printGraph(R, C, graph1);
        } else if (N % 2 == 0) {
            printGraph(R, C, graph2);
        } else {
            if (N % 4 == 1) {
                printGraph(R, C, graph4);
            } else {
                printGraph(R, C, graph3);
            }
        }

    }

    public static void printGraph(int R, int C, char[][] graph) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    public static void calc(int R, int C, int N, char[][] graph, char[][] graph3) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph[i][j] == 'O') {
                    graph3[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dxy[k][0];
                        int ny = j + dxy[k][1];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            graph3[nx][ny] = '.';
                        }
                    }
                }
            }
        }
    }
}