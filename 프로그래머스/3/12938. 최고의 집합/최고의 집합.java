class Solution {
    public int[] solution(int n, int s) {
        if(n>s){
            return new int[] {-1};
        }
        int[] answer = new int[n];
        int a = s/n;
        int b = s%n;
        for(int i=0; i<n; i++){
            answer[i] = a;
        }
        for(int i=0; i<b; i++){
            answer[n-1-i]++;
        }
        return answer;
    }
}