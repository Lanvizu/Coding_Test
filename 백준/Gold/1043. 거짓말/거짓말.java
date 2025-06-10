    //  거짓말

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int answer = 0;
        HashSet<Integer> trues = new HashSet<>();
        boolean[][] partys = new boolean[M + 1][N + 1];

        int[] tt = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (tt[0] != 0) {
            for (int i = 1; i <= tt[0]; i++) {
                trues.add(tt[i]);
            }
        }

        for (int i = 1; i <= M; i++) {
            int[] party = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 1; j <= party[0]; j++) {
                int a = party[j];
                partys[i][a] = true;
            }
        }
        
        bfs(M, N, partys, trues);

        if (tt[0] == 0) {
            System.out.println(M);
        } else {
            for (int i = 1; i <= M; i++) {
                if (!partys[i][0]) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    public static void bfs(int M, int N, boolean[][] partys, HashSet<Integer> trues) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        for (int t : trues) {
            q.add(t);
            visited[t] = true;
        }
        while (!q.isEmpty()) {
            int t = q.poll();
            for(int i=1; i<=M; i++) {
                if (!partys[i][t] || partys[i][0]) continue;
                for(int j=1; j<=N; j++) {
                    if (!visited[j] && partys[i][j]) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
                partys[i][0] = true;
            }
        }
    }
}