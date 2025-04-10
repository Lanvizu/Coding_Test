import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String result = "";
        int i=0;
        while(result.length()<t*m){
            result += Integer.toString(i, n).toUpperCase();
            i++;
        }
        while(answer.length()<t){
            answer += result.charAt(p-1);
            p+=m;
        }
        return answer;
    }
}
// 0 1 1 0 1 1 1 00
// 10 A, 11 B, 12 C, 13 D, 14 E, 15 F
// 0 1 2 3 4 5 6 7 8 9 A B C D E F