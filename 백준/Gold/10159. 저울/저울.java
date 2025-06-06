//  저울

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<List<HashSet<Integer>>> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N+1; i++) {
            result.add(new ArrayList<>());
            result.get(i).add(new HashSet<>());
            result.get(i).add(new HashSet<>());
        }
        int M = Integer.parseInt(sc.nextLine());
        boolean[][] visited = new boolean[N+1][N+1];
        for(int i = 0; i < M; i++) {
            String[] inputs = sc.nextLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            calc(a, b, visited);
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            cnt += result.get(i).get(0).size();
            cnt += result.get(i).get(1).size();
            System.out.println(N - cnt - 1);
        }
    }

    public static void calc(int a, int b, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a,b});
        visited[a][b] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int A = cur[0];
            int B = cur[1];

            result.get(A).get(1).add(B);
            result.get(B).get(0).add(A);

            for (int next1 : result.get(A).get(0)) {
                if(!visited[next1][B]) {
                    visited[next1][B] = true;
                    q.add(new int[]{next1,B});
                }
            }
            for (int next2 : result.get(B).get(1)) {
                if(!visited[A][next2]) {
                    visited[A][next2] = true;
                    q.add(new int[]{A, next2});
                }
            }
        }
    }
}