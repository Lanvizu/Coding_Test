//  Olympiad Pizza

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] graph = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] result = new int[N];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            q.add(i);
        }
        int cnt = 1;
        while(!q.isEmpty()){
            int u = q.poll();
            int a = graph[u] - 1;
            if (a == 0) {
                result[u] = cnt;
            } else {
                graph[u] = a;
                q.offer(u);
            }
            cnt++;
        }
        for(int i = 0; i < N; i++){
            System.out.print(result[i] + " ");
        }
    }
}