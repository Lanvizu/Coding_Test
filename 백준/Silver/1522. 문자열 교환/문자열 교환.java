//  문자열 교환

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();
        int lengthA = input.replaceAll("b", "").length();
        int minCnt = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            String now;
            if (i + lengthA > n) {
                now = input.substring(i, n) + input.substring(0, i + lengthA - n);
            } else {
                now = input.substring(i, i + lengthA);
            }
            int result = now.replaceAll("a", "").length();
            minCnt = Math.min(minCnt, result);
        }
        System.out.println(minCnt);
    }
}