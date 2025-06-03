//  마라톤 1

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] graph = new int[n][2];
        for(int i=0; i<n; i++){
            int[] input = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph[i] = input;
        }
        int result = 0;
        int pre = Math.abs(graph[1][0] - graph[0][0]) + Math.abs(graph[1][1] - graph[0][1]);
        int total = pre;
        for(int i=2; i<n; i++){
            int now = Math.abs(graph[i][0] - graph[i-1][0]) + Math.abs(graph[i][1] - graph[i-1][1]);
            int second = Math.abs(graph[i][0] - graph[i-2][0]) + Math.abs(graph[i][1] - graph[i-2][1]);
            result = Math.max(result, Math.abs(pre + now - second));
            total += now;
            pre = now;
        }
        System.out.println(total-result);
    }
}