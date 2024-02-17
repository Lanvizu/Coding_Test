import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        bfs();
    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int now = poll[0];
            int count = poll[1];
            if (now == K) {
                System.out.println(count);
                break;
            }
            if (now >= 0 && now + 1 < 100001) {
                if (visited[now + 1] == 0) {
                    visited[now + 1] = count + 1;
                    q.add(new int[]{now + 1, count + 1});
                }
            }
            if (now - 1 >= 0 && now - 1 < 100001) {
                if (visited[now - 1] == 0) {
                    visited[now - 1] = count + 1;
                    q.add(new int[]{now - 1, count + 1});
                }
            }
            if (now >= 0 && now * 2 < 100001) {
                if (visited[now * 2] == 0) {
                    visited[now * 2] = count + 1;
                    q.add(new int[]{now * 2, count + 1});
                }
            }
        }
    }
}
