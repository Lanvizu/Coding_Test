import java.util.ArrayList;


class Solution {
static int cnt;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i < graph[x].size(); i++) {
            int now = graph[x].get(i);
            if (visited[now]) continue;
            cnt++;
            dfs(now);
        }
    }
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int len = wires.length;

        for (int i = 0; i < len; i++) {
            graph = new ArrayList[n + 1];
            for (int p = 0; p < n + 1; p++) {
                graph[p] = new ArrayList<>();
            }
            int x = 0;
            for (int j = 0; j < len; j++) {
                if (j == i) continue;

                int a = wires[j][0];
                int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
                x = a;
            }
            cnt = 1;
            visited = new boolean[n + 1];
            dfs(x);

            answer = Math.min(answer, Math.abs(2 * cnt - n));
        }

        return answer;
    }
}