import java.util.*;
class Solution {
    int total = 0;
    int m;
    int[][] Q;
    int[] A;
    public int solution(int n, int[][] q, int[] ans) {
        m = q.length;
        Q = q;
        A = ans;
        int[] result = new int[n+1];
        for(int i=1; i<n+1; i++){
            result[i] = i;
        }
        boolean[] visited = new boolean[n+1];
        comb(n, visited, 1, 5);
        return total;
    }
    
    public void comb(int n, boolean[] visited, int start, int r){
        if(r==0){
            calc(visited);
            return;
        }
        for(int i=start; i<=n; i++){
            visited[i] = true;
            comb(n,visited,i+1,r-1);
            visited[i] = false;
        }
    }
    
    public void calc(boolean[] visited){
        for(int i=0; i<m; i++){
            int ans = A[i];
            int cnt = 0;
            for(int qq:Q[i]){
                if(visited[qq]) cnt++;
                if(cnt > ans) return;
            }
            if(cnt != ans) return;
        }
        total++;
    }
}
