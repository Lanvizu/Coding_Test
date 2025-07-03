//  주사위 굴리기 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    //북동남서
    static int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int N, M, K;
    static int total = 0;
    static int[][] map;
    static int[][] scores;
    static int[][] dice = new int[4][7];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        scores = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String line = "0 " + br.readLine();
            map[i] = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        calcScores();
        // 다이소 초기 위치
        calcNextDice(new int[]{0, 1, 2, 3, 4, 5, 6});
        moveDice(1, 1, 1, 0);

        System.out.println(total);

    }

    public static void moveDice(int x, int y, int nDir, int cnt) {
        if (cnt >= K) {
            return;
        }
        int nx = x + dir[nDir][0];
        int ny = y + dir[nDir][1];
        if (nx <= 0 || ny <= 0 || nx > N || ny > M) {
            nDir = (nDir + 2) % 4;
            nx = x + dir[nDir][0];
            ny = y + dir[nDir][1];
        }
        // 해당 칸의 점수 획득
        total += scores[nx][ny];
        // 해당 방향으로 이동한 다이스 설계도
        int[] nowDice = dice[nDir];
        if(nowDice[6] > map[nx][ny]) {
            nDir = (nDir + 1) % 4;
        }else if(nowDice[6] < map[nx][ny]) {
            nDir = (nDir + 3) % 4;
        }
        calcNextDice(nowDice);
        moveDice(nx, ny, nDir, cnt+1);
    }

    public static void calcNextDice(int[] d) {
        // 북
        dice[0] = new int[]{0, d[5], d[1], d[3], d[4], d[6], d[2]};
        // 동
        dice[1] = new int[]{0, d[4], d[2], d[1], d[6], d[5], d[3]};
        // 남
        dice[2] = new int[]{0, d[2], d[6], d[3], d[4], d[1], d[5]};
        // 서
        dice[3] = new int[]{0, d[3], d[2], d[6], d[1], d[5], d[4]};
    }

    // bfs로 각 칸의 점수 미리 저장
    public static void calcScores() {
        boolean[][] visited = new boolean[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (visited[i][j]) continue;
                int cnt = 1;
                int target = map[i][j];
                // bfs용 큐
                Queue<int[]> q = new LinkedList<>();
                // 점수 업데이트용 큐
                Queue<int[]> q2 = new LinkedList<>();
                q.offer(new int[]{i, j});
                q2.offer(new int[]{i, j});
                visited[i][j] = true;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur[0] + dir[k][0];
                        int ny = cur[1] + dir[k][1];
                        if (nx <= 0 || ny <= 0 || nx > N || ny > M || visited[nx][ny]) continue;
                        if (target != map[nx][ny]) continue;
                        visited[nx][ny] = true;
                        cnt++;
                        q.offer(new int[]{nx, ny});
                        q2.offer(new int[]{nx, ny});
                    }
                }
                int score = target * cnt;
                while (!q2.isEmpty()) {
                    int[] cur = q2.poll();
                    scores[cur[0]][cur[1]] = score;
                }
            }
        }
    }
}