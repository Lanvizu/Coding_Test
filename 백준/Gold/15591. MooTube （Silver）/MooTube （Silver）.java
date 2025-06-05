//  MooTube (Silver)

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int Q = Integer.parseInt(s[1]);
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int[] input = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int a = input[0];
            int b = input[1];
            int c = input[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        for (int i = 0; i < Q; i++) {
            int[] inputs = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            int k = inputs[0];
            int t = inputs[1];
            int cnt = 0;
            q.add(t);
            visited[t] = true;
            while (!q.isEmpty()) {
                Integer poll = q.poll();
                for (int[] a : graph.get(poll)) {
                    if (!visited[a[0]]) {
                        if (a[1] >= k) {
                            q.add(a[0]);
                            cnt++;
                            visited[a[0]] = true;
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}