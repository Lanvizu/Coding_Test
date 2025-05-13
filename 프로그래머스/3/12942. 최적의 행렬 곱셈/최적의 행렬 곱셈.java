import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int[][] m) {
        int n = m.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n-1; i++){
            dp[i][i+1] = m[i][0] * m[i][1] * m[i+1][1];
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i; j++){
                int a = j;
                int b = j+i;
                for(int k=a; k<b; k++){
                    int result = dp[a][k] + dp[k+1][b] + (m[a][0] * m[k][1] * m[b][1]);
                    if(dp[a][b] == 0){
                        dp[a][b] = result;
                    }else{
                        dp[a][b] = Math.min(dp[a][b], result);
                    }
                    
                }
            }
        }
        
        return dp[0][n-1];
    }
}


// 5 3 / 3 10 / 10 6
// 5 3 10 / 10 6
// 8 10 / 10 8 / 8 1
// 180 + 136 / 720 + 180
// 가장 큰 수를 먼저 진행한다?
// 아니면 가운데 수가 큰 수에 대해서 진행한다?
// 2 5 / 5 4 / 4 

// 1 2 / 2 3 / 3 4
// 4 3 / 3 2 / 2 1
// 
// 6 + 12 / 24 + 8
// 10 5 5 3 2 8
//[4, 5], [5, 10] [10, 7], [7, 3]
// (12)3 / 1(23)
// (123)4 / 1(234)

// (1((23)4))
// 200 / 350 / 210

// 4 5 7 3
// 140 / 105
// 4 7 3
// 350 + 140 + 84


