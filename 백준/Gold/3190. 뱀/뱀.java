//  뱀

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static boolean[][] apples;
    static boolean[][] sk;
    static Queue<int[]> q = new LinkedList<>();
    static HashMap<Integer, String> hs = new HashMap<>();
    // 시계방향
    static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        apples = new boolean[N+1][N+1];
        sk = new boolean[N+1][N+1];
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            apples[a][b] = true;
        }
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            hs.put(a, s[1]);
        }
        sk[1][1] = true;
        q.add(new int[]{1, 1});
        calc(1, 1, 0, 0);
    }

    public static void calc(int x, int y, int time, int d) {
        time++;
        int nx = x + dir[d][0];
        int ny = y + dir[d][1];
        if (nx <= 0 || ny <= 0 || nx > N || ny > N || sk[nx][ny]) {
            System.out.println(time);
            return;
        }
        sk[nx][ny] = true;
        q.add(new int[]{nx, ny});
        if (apples[nx][ny]) {
            apples[nx][ny] = false;
        } else {
            int[] tail = q.poll();
            sk[tail[0]][tail[1]] = false;
        }
        if (hs.containsKey(time)) {
            if (hs.get(time).equals("D")) {
                d = (d + 1) % 4;
            } else {
                d = (d + 3) % 4;
            }
        }
        calc(nx, ny, time, d);
    }
}