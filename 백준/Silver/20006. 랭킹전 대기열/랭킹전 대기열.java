//  랭킹전 대기열

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int p, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        p = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        LinkedList<List<String[]>> map = new LinkedList<>();
//        <각 방<각 사람들<각 정보들>>>
        for (int i = 0; i < p; i++) {
//            System.out.println(map);
            String[] s1 = br.readLine().split(" ");
            int l = Integer.parseInt(s1[0]);
            String n = s1[1];
            if (map.size() < 1) {
                addRoom(map, l, n);
            } else {
                boolean check = false;
                for (int j = 0; j < map.size(); j++) {
                    if (map.get(j).size() >= m) continue;
                    int key = Integer.parseInt(map.get(j).get(0)[1]);
                    if (key - 10 <= l && l <= key + 10) {
                        check = true;
                        String[] innerString = new String[2];
                        innerString[0] = n;
                        innerString[1] = l+"";
                        map.get(j).add(innerString);
                        break;
                    }
                }
                if (!check) addRoom(map, l, n);
            }
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).size() >= m) {
                printWord("Started!", map.get(i));
            } else {
                printWord("Waiting!", map.get(i));
            }
        }
    }

    public static void printWord(String word, List<String[]> list) {
        System.out.println(word);
        list.sort((o1, o2) -> o1[0].compareTo(o2[0]));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[1] + " "+ list.get(i)[0]);
        }
    }

    public static void addRoom(LinkedList<List<String[]>> map, int l, String n) {
        List<String[]> list = new ArrayList<>();
        String[] innerString = new String[2];
        innerString[0] = n;
        innerString[1] = l + "";
        list.add(innerString);
        map.add(list);
    }
}