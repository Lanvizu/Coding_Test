import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        Arrays.sort(bill);
        Arrays.sort(wallet);
        while (wallet[0] < bill[0] || wallet[1] < bill[1]){
            if (bill[0] > bill[1]){
                bill[0] /= 2;
            }else{
                bill[1] /= 2;
            }
            answer += 1;
            Arrays.sort(bill);
        }
        return answer;
    }
}