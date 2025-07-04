//  이차원 배열과 연산

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int r, c, k, maxX, maxY;
    static int[][] arr = new int[100][100];
    static HashMap<Integer, Integer> map = new HashMap<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[1] != b[1]) {
            return Integer.compare(a[1], b[1]);
        }
        return Integer.compare(a[0], b[0]);
    });


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());
        maxX = 3;
        maxY = 3;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }
        calc();
    }

    public static void calc() {
        int t = 0;
        while (t < 101 && arr[r][c] != k) {
            t++;
            calcArr();
        }
        System.out.println(t > 100 ? -1 : t);
    }

    public static void calcArr() {
        if (maxX >= maxY) {
            // R연산
            int newMaxY = 0;
            for (int i = 0; i < maxX; i++) {
                pq.clear();
                map.clear();
                for (int j = 0; j < maxY; j++) {
                    if (arr[i][j] == 0) continue;
                    map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                }
                for (int key : map.keySet()) {
                    pq.add(new int[]{key, map.get(key)});
                }
                int cnt = 0;
                Arrays.fill(arr[i], 0);
                while (!pq.isEmpty() && cnt < 98) {
                    int[] t = pq.poll();
                    arr[i][cnt++] = t[0];
                    arr[i][cnt++] = t[1];
                }
                newMaxY = Math.max(newMaxY, cnt);
            }
            maxY = newMaxY;
        } else {
            // C연산
            int newMaxX = 0;
            for (int j = 0; j < maxY; j++) {
                pq.clear();
                map.clear();
                for (int i = 0; i < maxX; i++) {
                    if (arr[i][j] == 0) continue;
                    map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                }
                for (int key : map.keySet()) {
                    pq.add(new int[]{key, map.get(key)});
                }
                for (int i = 0; i < maxX; i++) {
                    arr[i][j] = 0;
                }
                int cnt = 0;
                while (!pq.isEmpty()) {
                    int[] t = pq.poll();
                    arr[cnt++][j] = t[0];
                    arr[cnt++][j] = t[1];
                }
                newMaxX = Math.max(newMaxX, cnt);
            }
            maxX = newMaxX;
        }
    }
}