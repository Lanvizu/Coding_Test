import java.util.*;

class Solution {    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {        
        StringBuilder sb = new StringBuilder(k);
        int[][] cmds = {
            {1,0},
            {0,-1},
            {0,1},
            {-1,0}
        };
        String[] cmdStrs = {"d","l","r","u"};

        int curX = x;
        int curY = y;
        int remainK = k;

        boolean canComplete = true;
        while(remainK > 0 && canComplete){
            canComplete = false;

            for(int i = 0; i < cmds.length; i++){
                int[] cmd = cmds[i];
                String cmdStr = cmdStrs[i];

                int nextX = curX + cmd[0];
                int nextY = curY + cmd[1];

                if(!(1 <= nextX && nextX <= n && 1 <= nextY && nextY <= n)){
                    continue;
                }

                int dist = Math.abs(nextX - r) + Math.abs(nextY - c);

                if(remainK > 1){
                    dist += 1;
                }

                if(remainK >= dist){
                    remainK -= 1;
                    curX = nextX;
                    curY = nextY;
                    sb.append(cmdStr);
                    canComplete = true;
                    break;
                }
            }
        }

        if(curX == r && curY == c){
            return sb.toString();
        }else{
            return "impossible";
        }
    }
}