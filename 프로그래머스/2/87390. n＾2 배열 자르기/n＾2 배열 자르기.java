import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right-left+1);
        int[] answer = new int[size];
        int idx = 0;
        for (long num = left; num <= right; num++) {
            long row = num / n;
            long col = num % n;
            answer[idx++] = (int)(Math.max(row, col) + 1);
        }
        return answer;
    }
}