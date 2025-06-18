import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[][] result;

    static class Tower {
        int height;
        int index;

        Tower(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        result = new int[N][2];

        process(false); // 오른쪽 보기
        process(true);  // 왼쪽 보기

        printResult();
    }

    public static void process(boolean isLeft) {
        Stack<Tower> stack = new Stack<>();

        int start = isLeft ? N - 1 : 0;
        int end = isLeft ? -1 : N;
        int step = isLeft ? -1 : 1;

        for (int i = start; i != end; i += step) {
            while (!stack.isEmpty() && stack.peek().height <= arr[i]) {
                stack.pop();
            }

            result[i][0] += stack.size();

            if (!stack.isEmpty()) {
                int nearestIdx = stack.peek().index;
                if (result[i][1] == 0 || Math.abs(i - nearestIdx) < Math.abs(i - (result[i][1] - 1))) {
                    result[i][1] = nearestIdx + 1;
                }
            }

            stack.push(new Tower(arr[i], i));
        }
    }

    public static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (result[i][0] == 0) {
                sb.append("0\n");
            } else {
                sb.append(result[i][0]).append(" ").append(result[i][1]).append("\n");
            }
        }
        System.out.print(sb);
    }
}
