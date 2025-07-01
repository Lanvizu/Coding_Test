//  시험 감독

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] students = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        String[] s = br.readLine().split(" ");
        int B = Integer.parseInt(s[0]);
        int C = Integer.parseInt(s[1]);
        long answer = 0;

        for(int st: students) {
            st = st - B;
            if (st <= 0) {
                answer++;
                continue;
            }
            if (st % C > 0) {
                answer += st / C + 2;
            } else {
                answer += st / C + 1;
            }
        }
        System.out.println(answer);
    }
}