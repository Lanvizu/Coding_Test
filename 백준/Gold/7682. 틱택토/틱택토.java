//  틱택토

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            flag = false;
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            if (!calc1(input)) {
                printAnswer(false);
                continue;
            }
            char[] ca = input.toCharArray();
            boolean[] bX = new boolean[9];
            boolean[] bO = new boolean[9];
            char[] bb = new char[9];
            for (int i = 0; i < 9; i++) {
                bb[i] = 'a';
                if (ca[i] == 'X') {
                    bX[i] = true;
                } else if (ca[i] == 'O') {
                    bO[i] = true;
                }
            }
            // X와 O를 번갈아가며 체크 -> 한번이라도 XO 깔끔하게 순서대로 성공 시 flag=true
            dfs(bb, bX, bO, true);
            // 전체 채웠지만 빙고 없으면서 .이 없는 경우
            if (!flag && input.indexOf(".") == -1 && !check(ca)) {
                flag = true;
            }
            printAnswer(flag);
        }
    }

    //    개수로 체크
    public static boolean calc1(String input) {
        int lengthX = input.replaceAll("[^X]", "").length();
        int lengthO = input.replaceAll("[^O]", "").length();
        if (lengthX >= lengthO && lengthO >= lengthX - 1) {
            return true;
        }
        return false;
    }

    public static void dfs(char[] bb, boolean[] bX, boolean[] bO, boolean isX) {
        if (flag) return;
        if (check(bb)) {
            for (int i = 0; i < 9; i++) {
                if (bX[i] || bO[i]) return;
            }
            flag = true;
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (isX && bX[i]) {
                bX[i] = false;
                bb[i] = 'X';
                dfs(bb, bX, bO, false);
                bX[i] = true;
                bb[i] = 'a';
            } else if (!isX && bO[i]) {
                bO[i] = false;
                bb[i] = 'O';
                dfs(bb, bX, bO, true);
                bO[i] = true;
                bb[i] = 'a';
            }
        }
    }

    public static boolean check(char[] bb) {
        if (bb[0] != 'a' && bb[0] == bb[1] && bb[1] == bb[2]) return true;
        if (bb[0] != 'a' && bb[0] == bb[3] && bb[3] == bb[6]) return true;
        if (bb[0] != 'a' && bb[0] == bb[4] && bb[4] == bb[8]) return true;
        if (bb[1] != 'a' && bb[1] == bb[4] && bb[4] == bb[7]) return true;
        if (bb[2] != 'a' && bb[2] == bb[5] && bb[5] == bb[8]) return true;
        if (bb[2] != 'a' && bb[2] == bb[4] && bb[4] == bb[6]) return true;
        if (bb[3] != 'a' && bb[3] == bb[4] && bb[4] == bb[5]) return true;
        if (bb[6] != 'a' && bb[6] == bb[7] && bb[7] == bb[8]) return true;
        return false;
    }

    public static void printAnswer(boolean answer) {
        if (answer) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }
}