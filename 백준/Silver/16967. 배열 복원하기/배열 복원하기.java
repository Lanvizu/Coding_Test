//  배열 복원하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int H, W, X, Y;
    static int[][] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        H = Integer.parseInt(s[0]);
        W = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);
        Y = Integer.parseInt(s[3]);

        A = new int[H][W];
        B = new int[H + X][W + Y];
        for (int i = 0; i < H + X; i++) {
            B[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        calc1();
        calc2();
        printA();
    }

    public static void calc1() {
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = B[i][j];
            }
        }
        for (int i = H; i < H + X; i++) {
            for (int j = Y; j < W + Y; j++) {
                A[i-X][j-Y] = B[i][j];
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < Y; j++) {
                A[i][j] = B[i][j];
            }
        }
        for (int i = X; i < H + X; i++) {
            for (int j = W; j < W + Y; j++) {
                A[i-X][j-Y] = B[i][j];
            }
        }
    }

    public static void calc2() {
        for (int i = X; i < H - X; i++) {
            for(int j = Y; j < W - Y; j++) {
                A[i][j] = B[i][j] - A[i - X][j - Y];
            }
        }
    }

    public static void printA() {
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}