//  이차원 배열과 연산

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int r, c, k, maxX, maxY;
    static int[][] arr = new int[100][100];

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
            arr = calcArr();
        }
        if (t > 100) t = -1;
        System.out.println(t);
    }

    public static int[][] calcArr() {
        int[][] newArr = new int[100][100];
        if (maxX >= maxY) {
            // R연산
            for (int i = 0; i < maxX; i++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int t : arr[i]) {
                    if (t == 0) continue;
                    map.put(t, map.getOrDefault(t, 0) + 1);
                }
                for (int key : map.keySet()) {
                    pq.add(new int[]{key, map.get(key)});
                }
                int cnt = 0;
                while (!pq.isEmpty()) {
                    int[] t = pq.poll();
                    newArr[i][cnt++] = t[0];
                    newArr[i][cnt++] = t[1];
                }
                maxY = Math.max(cnt, maxY);
            }
        } else {
            // C연산
            for (int j = 0; j < maxY; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int i = 0; i < maxX; i++) {
                    if (arr[i][j] == 0) continue;
                    map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
                }
                for (int key : map.keySet()) {
                    pq.add(new int[]{key, map.get(key)});
                }
                int cnt = 0;
                while (!pq.isEmpty()) {
                    int[] t = pq.poll();
                    newArr[cnt++][j] = t[0];
                    newArr[cnt++][j] = t[1];
                }
                maxX = Math.max(cnt, maxX);
            }
        }
        return newArr;
    }
}