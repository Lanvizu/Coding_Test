//  컨베이어 벨트 위의 로봇

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] belt;
    static boolean[] robot;
    static int N, K, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        belt = new int[2 * N];
        robot = new boolean[N];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(input[i]);
        }
        int answer = solve();
        System.out.println(answer);
    }

    public static int solve() {
        int stage = 0;
        // 로봇 이동
        while (cnt < K) {
            stage++;
            // 1. 회전
            rotate();

            // 2. 로봇 이동
            for (int i = N - 2; i > 0; i--) {
                if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                    robot[i] = false;
                    robot[i + 1] = true;
                    belt[i + 1]--;
                    if (belt[i + 1] == 0) cnt++;
                }
            }

            //3. 로봇 내리기
            robot[N - 1] = false;

            //4. 로봇 올리기
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
                if (belt[0] == 0) cnt++;
            }
        }
        return stage;
    }

    private static void rotate() {
        int last = belt[2 * N - 1];
        for (int i = 2 * N - 1; i >= 1; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = last;

        for (int i = N - 1; i >= 1; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;

        robot[N - 1] = false;
    }
}