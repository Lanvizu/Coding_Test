//  근손실

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int result = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nk = sc.nextLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        int[] kits = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        backtrack(500, 0, K, kits, new boolean[N]);
        System.out.println(result);
    }

    public static void backtrack(int current, int depth, int K, int[] kits, boolean[] visited){
        if(depth == kits.length){
            result++;
//            System.out.println(Arrays.toString(visited));
            return;
        }
        for (int i = 0; i < kits.length; i++) {
            if (!visited[i]) {
                int next = current + kits[i] - K;
                if (next >= 500) {
                    visited[i] = true;
                    backtrack(next, depth + 1, K, kits, visited);
                    visited[i] = false;
                }
            }
        }
    }
}