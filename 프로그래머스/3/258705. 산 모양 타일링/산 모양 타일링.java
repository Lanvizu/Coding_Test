import java.util.*;
class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        Queue<int[]> q = new ArrayDeque<>();
        if(tops[0] == 1){
            q.add(new int[] {3,4});
        }else{
            q.add(new int[] {2,3});
        }
        for(int i=1; i<n; i++){
            int[] bf = q.poll();
            if(tops[i] == 1){
                q.add(new int[] {(bf[0]+bf[1]*2)%10007, (bf[0]+bf[1]*3)%10007});
            }else{
                q.add(new int[] {(bf[0]+bf[1])%10007, (bf[0]+bf[1]*2)%10007});
            }
        }
        int[] result = q.poll();
        answer = result[1] % 10007;
        
        return answer;
    }
}
// 1:1 / 2:2 / 3:3 / 3+:4
// (2,3) 5, 8, 11
// (3,4) 7, 11, 15