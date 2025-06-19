//  문자열 게임 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            calc(W, K);
        }
    }

    public static void calc(String W, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int cnt = -1;
        Map<String, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < W.length(); i++) {
            String s = W.substring(i, i + 1);
            Queue<Integer> q = map.get(s);
            if (q == null) {
                q = new LinkedList<>();
                q.offer(i);
                map.putIfAbsent(s, q);
            } else {
                q.offer(i);
            }
            if (q.size() == K) {
                min = Math.min(min, i - q.peek() + 1);
                max = Math.max(max, i - q.peek() + 1);
                q.poll();
                cnt++;
            }
        }
        printResult(min, max, cnt);
    }

    private static void printResult(int min, int max, int cnt) {
        if (cnt == -1) {
            System.out.println(-1);
        } else {
            System.out.println(min + " " + max);
        }
    }
}