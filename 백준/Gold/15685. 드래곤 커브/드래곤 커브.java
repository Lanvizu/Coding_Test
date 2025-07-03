//  드래곤 커브

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean[][] graph = new boolean[101][101];
    // x,y (↓)(←)(↑)(→)
    static int[][] dir = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int[] dc = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            calcDC(dc);
        }
        calcSq();
    }

    public static void calcSq() {
        int total = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(!graph[i][j]) continue;
                if (graph[i][j] && graph[i + 1][j] && graph[i][j + 1] && graph[i + 1][j + 1]) {
                    total++;
                }
            }
        }
        System.out.println(total);
    }

    public static void calcDC(int[] dc) {
        int x = dc[0];
        int y = dc[1];
        int nDir = dc[2];
        int stage = dc[3];
        List<Integer> seq = new ArrayList<>();
        graph[x][y] = true;
        x += dir[nDir][0];
        y += dir[nDir][1];
        graph[x][y] = true;
        seq.add(nDir);
        for (int i = 1; i <= stage; i++) {
            // i만큼 회전한 다음 순서
            Queue<Integer> q = calcNext(seq);
            while (!q.isEmpty()) {
                int next = q.poll();
                seq.add(next);
                x += dir[next][0];
                y += dir[next][1];
                graph[x][y] = true;
            }
        }
    }

    public static Queue<Integer> calcNext(List<Integer> seq) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = seq.size() - 1; i >= 0; i--) {
            int nn = seq.get(i);
            nn = (nn + 2) % 4 -1;
            if (nn < 0) nn += 4;
            q.add(nn);
        }
        return q;
    }
}