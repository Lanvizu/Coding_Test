//  치킨 배달

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static List<int[]> hList = new ArrayList<>();
    static List<int[]> cList = new ArrayList<>();
    static int totalDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    hList.add(new int[]{i, j});
                } else if (a == 2) {
                    cList.add(new int[]{i, j});
                }
            }
        }
        calcM(-1, new ArrayList<>());
        System.out.println(totalDist);
    }

    // cList.size()에서 중복없이 M개 뽑아내기
    public static void calcM(int now, List<Integer> result) {
        if (result.size() == M) {
            calcHouse(result);
            return;
        }
        for (int i = now + 1; i < cList.size(); i++) {
            result.add(i);
            calcM(i, result);
            result.remove(result.indexOf(i));
        }
    }

    public static void calcHouse(List<Integer> nowC) {
        int result = 0;
        for (int[] nowH : hList) {
            int d = Integer.MAX_VALUE;
            for (int i : nowC) {
                int[] ch = cList.get(i);
                d = Math.min(d, Math.abs(ch[0] - nowH[0]) + Math.abs(ch[1] - nowH[1]));
            }
            result += d;
        }
        totalDist = Math.min(totalDist, result);
    }
}