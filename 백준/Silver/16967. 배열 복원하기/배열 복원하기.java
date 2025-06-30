//  배열 복원하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int H, W, X, Y;
    static int[][] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        H = Integer.parseInt(s[0]);
        W = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);
        Y = Integer.parseInt(s[3]);

        B = new int[H + X][W + Y];
        for (int i = 0; i < H + X; i++) {
            B[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        calc();
        printB();
    }

    public static void calc() {
        for (int i = X; i < H; i++) {
            for(int j = Y; j < W; j++) {
                B[i][j] = B[i][j] - B[i - X][j - Y];
            }
        }
    }

    public static void printB() {
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                System.out.print(B[i][j] + " ");
            }
            System.out.println();
        }
    }
}