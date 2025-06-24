//  List of Unique Numbers

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] tokens = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        int[] freq = new int[100001];
        long count = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            int num = arr[right];
            freq[num]++;

            while (freq[num] > 1) {
                freq[arr[left]]--;
                left++;
            }

            count += (right - left + 1);
        }

        System.out.println(count);
    }
}