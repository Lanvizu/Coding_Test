//  비슷한 단어

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int n = sc.nextInt();
        HashMap<Character, Integer> hm = new HashMap<>();
        String target = sc.next();
        createHashMap(hm, target);
        for (int i = 0; i < n - 1; i++) {
            HashMap<Character, Integer> hm2 = new HashMap<>();
            String s = sc.next();
            createHashMap(hm2, s);
            if (calc(hm, hm2)) answer++;
        }
        System.out.println(answer);
    }

    public static boolean calc(HashMap<Character, Integer> hm, HashMap<Character, Integer> hm2) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (char nkey : hm.keySet()) {
            if (cnt1 > 1) return false;
            int v1 = hm.get(nkey);
            int v2 = hm2.getOrDefault(nkey, 0);
            if (v1 == v2) {
                hm2.remove(nkey);
            } else if (v1 > v2) {
                if (v1 - v2 > 1) return false;
                // 1에는 있지만 2에는 부족하거나 없는 상황
                //abbc, abcc
                hm2.remove(nkey);
                cnt1 += v1 - v2;
            }
        }
        for (char nkey2 : hm2.keySet()) {
            if (cnt2 > 1) return false;
            int v1 = hm.getOrDefault(nkey2, 0);
            int v2 = hm2.get(nkey2);
            //같은 경우는 위에서 이미 처리
            if (v1 < v2) {
                if (v2 - v1 > 1) return false;
                cnt2 += v2 - v1;
            }
        }
        if (cnt1 > 1 || cnt2 > 1) return false;
        return true;
    }

    public static void createHashMap(HashMap<Character, Integer> hm, String input) {
        for (char c : input.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
    }
}