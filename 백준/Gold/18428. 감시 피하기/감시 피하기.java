//  감시 피하기

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static String[][] map;
    static List<int[]> teachers = new ArrayList<>();
    static List<int[]> spaces = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        map = new String[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (map[i][j].equals("T")) {
                    teachers.add(new int[]{i, j});
                } else if (map[i][j].equals("X")) {
                    spaces.add(new int[]{i, j});
                }
            }
        }

//        System.out.println(Arrays.deepToString(map));
//        System.out.println(Arrays.deepToString(spaces.toArray()));
//        System.out.println(Arrays.deepToString(teachers.toArray()));
        if (checkAll()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean checkAll() {
        int size = spaces.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    String[][] copyMap = copyMap(map);
                    int[] o1 = spaces.get(i);
                    int[] o2 = spaces.get(j);
                    int[] o3 = spaces.get(k);
                    copyMap[o1[0]][o1[1]] = "O";
                    copyMap[o2[0]][o2[1]] = "O";
                    copyMap[o3[0]][o3[1]] = "O";
                    if(isSafe(copyMap)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isSafe(String[][] copyMap) {
        for (int[] t : teachers) {
            for (int dir = 0; dir < 4; dir++) {
                if (watch(t[0], t[1], dx[dir], dy[dir], copyMap)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean watch(int x, int y, int dx, int dy, String[][] copyMap) {
        while (true) {
            x += dx;
            y += dy;
            if (x < 0 || y < 0 || x >= N || y >= N) break;
            if (copyMap[x][y].equals("O")) break;
            if (copyMap[x][y].equals("S")) return true;
        }
        return false;
    }

    public static String[][] copyMap(String[][] original) {
        String[][] copy = new String[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = Arrays.copyOf(original[i], N);
        }
        return copy;
    }
}