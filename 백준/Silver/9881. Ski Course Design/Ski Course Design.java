//  Ski Course Design

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            min = Math.min(min, a);
            max = Math.max(max, a);
            graph[i] = a;
        }
        calc(min, max);
    }

    public static void calc(int min, int max) {
        int answer = Integer.MAX_VALUE;
        for (int low = min; low <= max - 17; low++) {
            int high = low + 17;
            int cost = 0;
            for (int i = 0; i < N; i++) {
                if (graph[i] < low) {
                    cost += (int) Math.pow(low - graph[i], 2);
                } else if (graph[i] > high) {
                    cost += (int) Math.pow(graph[i] - high, 2);
                }
            }
            answer = Math.min(answer, cost);
        }
        System.out.println(answer);
    }
}