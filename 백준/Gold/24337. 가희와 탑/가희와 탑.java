//  가희와 탑

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int a = Integer.parseInt(s[1]);
        int b = Integer.parseInt(s[2]);

        if (a + b > N + 1) {
            System.out.println(-1);
        } else {
            int[] result = new int[N];
            Arrays.fill(result, 1);
            int maxH = Math.max(a, b);
            int cnt = 1;
            for (int i = N - 1; i > N - b; i--) {
                result[i] = cnt++;
            }
            if (a == 1) {
                result[0] = maxH;
            } else {
                result[N - b] = maxH;
            }
            // N-b-1 부터 내려오면서 a-1개
            cnt = a - 1;
            for (int i = N - b - 1; i > N - b - a; i--) {
                result[i] = cnt--;
            }
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < N; i++) {
                answer.append(result[i]).append(" ");
            }
            System.out.println(answer.toString());
        }
    }
}