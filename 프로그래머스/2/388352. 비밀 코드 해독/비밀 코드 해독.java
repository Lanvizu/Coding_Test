class Solution {
    int answer = 0;
    int[][] Q;
    int[] A;
    public int solution(int n, int[][] q, int[] ans) {
        boolean[] visited = new boolean[n+1];
        Q = q;
        A = ans;
        dfs(1,5,visited);
        return answer;
    }
    public void dfs(int start, int r, boolean[] visited){
        if(r==0){
            calc(visited);
            return;
        }
        for(int i=start; i<visited.length; i++){
            visited[i] = true;
            dfs(i+1, r-1, visited);
            visited[i] = false;
        }
    }
    public void calc(boolean[] visited){
        for(int i=0; i<Q.length; i++){
            int cnt = 0;
            for(int q:Q[i]){
                if(visited[q]) cnt++;
                if(A[i]<cnt) return;
            }
            if(A[i]!=cnt) return;
        }
        answer++;
    }
}