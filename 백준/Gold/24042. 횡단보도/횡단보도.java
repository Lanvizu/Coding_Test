//  횡단보도

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph.get(a).add(new int[]{b, i});
            graph.get(b).add(new int[]{a, i});
        }

        calc(graph);
    }

    public static void calc(List<List<int[]>> graph) {
        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        boolean[] visited = new boolean[N + 1];
        visited[1] = true;

        Queue<long[]> q = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int[] node : graph.get(1)) {
            int a = node[0];
            int t = node[1];
            dist[a] = t;
            // 현재 시간, 다음 노드, 횡단보도 시간
            q.add(new long[]{t, a, t});
        }
        // 바로 갈 수 있는 경우
        if (dist[N] < M) {
            System.out.println(dist[N]);
            return;
        }

        while (!q.isEmpty()) {
            long[] node = q.poll();
            long rt = node[0];
            int a = (int) node[1];
            int t = (int) node[2];
            if (a == N) {
                System.out.println(rt);
                return;
            }
            if (visited[a]) continue;
            visited[a] = true;

            for (int[] neighbor : graph.get(a)) {
                int b = neighbor[0];
                int nt = neighbor[1];
                if (visited[b]) continue;
                long time = nt - rt % M; // 횡단보도 기다리는 시간 (현재 시간에서 기다려야 하는 시간)
                if (time < 0) time += M;
                if (time + rt < dist[b]) {
                    dist[b] = time + rt;
                    q.add(new long[]{time + rt, b, nt});
                }
            }
        }
    }
}