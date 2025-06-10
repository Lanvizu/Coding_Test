//  트럭

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int w = Integer.parseInt(s[1]);
        int L = Integer.parseInt(s[2]);

        int[] ts = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int i = 0;
        int t = 0;
        int m = 0;
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        while (true) {
            if (q.isEmpty() && i >= n) {
                answer = t;
                break;
            }
            if (!q.isEmpty()) {
                int[] cur = q.peek();
                if (w <= t - cur[0]) {
                    q.poll();
                    m -= cur[1];
                }
            }
            // 일단 내부 무게 vs 다음 트럭 무게 && 내부 트럭 개수 vs w
            if (i < n && L - m >= ts[i] && w > q.size()) {
                q.offer(new int[]{t, ts[i]});
                m += ts[i++];
            }
            t++;
        }
        System.out.println(answer);
    }
}