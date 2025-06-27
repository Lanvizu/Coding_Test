//  등산 마니아

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        parent = new int[N + 1];
        int total = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
//        for (int i = 1; i <= N; i++) {
//            System.out.println(graph.get(i));
//        }
        calcGraph(graph);
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int lca = getLCA(i, j);
                total += arr[i] + arr[j] - arr[lca];
            }
        }
        System.out.println(total);
    }

    public static int getLCA(int a, int b) {
        while (arr[a] > arr[b]) a = parent[a];
        while (arr[b] > arr[a]) b = parent[b];

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    public static void calcGraph(List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    arr[next] = arr[cur] + 1;
                    parent[next] = cur;
                }
            }
        }
    }
}

// 다익스트라로 1에서 다른 모든 최소 거리 계산
// a-> b 가는 경우의 수 = 1->a + 1->b - 1->중간값
// 중간값을 어떻게 구할까...