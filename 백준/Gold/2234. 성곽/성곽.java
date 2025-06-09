//  성곽

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] visited;
    static boolean[][] linkedMap;
    static int cnt = 0;
    static int[][] dxy = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        M = Integer.parseInt(s[0]);
        N = Integer.parseInt(s[1]);

        int[][] graph = new int[N][M];
        HashMap<Integer, Integer> map = new HashMap<>();
        visited = new int[N][M];
        linkedMap = new boolean[N*M+1][N*M+1];
        int answer2 = 0;
        int answer3 = 0;

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int target = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    dfs(target, graph, i, j);
                    map.put(target++, cnt);
                    answer2 = Math.max(cnt, answer2);
                    cnt = 0;
                }
            }
        }
        
        int answer1 = map.size();
        for (int i = 1; i < target; i++) {
            for (int j = 1; j < target; j++) {
                if (i != j && linkedMap[i][j]) {
                    answer3 = Math.max(map.get(i) + map.get(j), answer3);
                }
            }
        }
        System.out.println(answer1);
        System.out.println(answer2);
        System.out.println(answer3);
    }

    public static void dfs(int tg, int[][] graph, int a, int b) {
        cnt++;
        visited[a][b] = tg;
        boolean[] d = calcD(graph[a][b]);
        for (int i = 0; i < 4; i++) {
            int nx = a + dxy[i][0];
            int ny = b + dxy[i][1];
            if(d[i] && nx >=0 && ny >=0 && nx < N && ny < M && visited[nx][ny] != 0) {
                linkedMap[tg][visited[nx][ny]] = true;
                continue;
            }
            if(d[i]) continue;
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (visited[nx][ny] == 0) {
                dfs(tg, graph, nx, ny);
            }
        }
    }

    public static boolean[] calcD(int a) {
        boolean[] result = new boolean[4];
        while (a > 0) {
            if (a >= 8) {
                result[3] = true;
                a -= 8;
            } else if (a >= 4) {
                result[2] = true;
                a -= 4;
            } else if (a >= 2) {
                result[1] = true;
                a -= 2;
            } else {
                result[0] = true;
                a -= 1;
            }
        }
        return result;
    }
}