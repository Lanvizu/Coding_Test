//  탑 보기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] arr;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        result = new int[N][2];
        calcRight();
        calcLeft();
        printResult();
    }

    public static void calcLeft() {
        Stack<int[]> st2 = new Stack<>();
        st2.add(new int[]{arr[N - 1], 0, N - 1});
        for (int i = N - 2; i >= 0; i--) {
            int now = arr[i];
            int cnt = 0;
            while (!st2.isEmpty() && now >= st2.peek()[0]) {
                int[] pre = st2.pop();
                // 큰 개수 구하기
                result[pre[2]][0] += pre[1];
            }
            if (!st2.isEmpty()) {
                cnt = st2.peek()[1] + 1;
                // 역방향이므로 더 가까운 경우 계산 필요
                if (result[i][1] != 0) {
                    if (Math.abs(result[i][1] - i - 1) > Math.abs(st2.peek()[2] - i)) {
                        result[i][1] = st2.peek()[2] + 1;
                    }
                } else {
                    result[i][1] = st2.peek()[2] + 1;
                }
            }
            st2.push(new int[]{now, cnt, i});
        }
        while (!st2.isEmpty()) {
            int[] pre = st2.pop();
            result[pre[2]][0] += pre[1];
        }
    }

    public static void calcRight() {
        Stack<int[]> st = new Stack<>();
        st.add(new int[]{arr[0], 0, 0});
        for (int i = 1; i < N; i++) {
            int now = arr[i];
            int cnt = 0;
            while (!st.isEmpty() && now >= st.peek()[0]) {
                int[] pre = st.pop();
                // 큰 개수 구하기
                result[pre[2]][0] += pre[1];
            }
            if (!st.isEmpty()) {
                cnt = st.peek()[1] + 1;
                // 정방향이므로 처음
                result[i][1] = st.peek()[2] + 1;
            }
            st.push(new int[]{now, cnt, i});
        }
        while (!st.isEmpty()) {
            int[] pre = st.pop();
            result[pre[2]][0] += pre[1];
        }
    }

    public static void printResult() {
        for (int i = 0; i < N; i++) {
            if (result[i][0] == 0) {
                System.out.println("0");
            } else {
                System.out.println(result[i][0] + " " + result[i][1]);
            }
        }
    }
}
// N이 10만개인데 for문 한번으로 처리해야할듯?
// 3 5 7 9 -> 7(9) / 5(79) / 3(579) -> 즉 a b 에 대해서 b가 볼 수 있는건 a도 볼 수 있다. -> 반대 방향도 마찬가지
// 3 7 1 6 3 5 1 7
// 왼쪽 3보다 작은 값 0
// (3, 0) -> 7,1 -> (7,1), 1 -> (7,6) , 1 -> (7,6,3) 1 -> (7,6,5), 1 -> (7,6,5,1)