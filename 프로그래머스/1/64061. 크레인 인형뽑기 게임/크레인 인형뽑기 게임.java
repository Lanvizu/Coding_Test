import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int m = board[0].length;
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int now:moves){
            for(int i=0; i<n; i++){
                int t = board[i][now-1];
                if(t != 0){
                    if(!st.empty() && st.peek() == t){
                        st.pop();
                        answer+=2;
                    }else{
                        st.add(board[i][now-1]);
                    }
                    board[i][now-1] = 0;
                    break;
                }
            }
            // System.out.println(st);
        }
        return answer;
    }
}