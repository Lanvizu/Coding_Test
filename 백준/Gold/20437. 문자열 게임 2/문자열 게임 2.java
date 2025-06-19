//  문자열 게임 2

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            calc(W, K);
        }
    }

    public static void calc(String W, int K) {
        char[] arr = W.toCharArray();
        List<Integer> result = new LinkedList<>();
        HashMap<Character, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
//            System.out.println(ch);
            if (map.containsKey(ch)) {
                int size = map.get(ch).size();
                for (int j = 0; j < size; j++) {
                    map.get(ch).get(j)[1]++;
//                    System.out.println(map.get(ch).get(j)[0] + " " + map.get(ch).get(j)[1]);
                }
            } else {
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(new int[]{i, 1});
            int size = map.get(ch).size();
            for (int j = 0; j < size; j++) {
                if (map.get(ch).get(j)[1] == K) {
                    result.add(i - map.get(ch).get(j)[0] + 1);
                }
            }
        }
//        System.out.println(result);
        printResult(result);
    }

    private static void printResult(List<Integer> result) {
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            System.out.println(result.get(0) + " " + result.get(result.size() - 1));
        }
    }
}