class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(0,0,numbers,target);
        return answer;
    }
    
    public void dfs(int sum, int x, int[] numbers, int target){
        if(x == numbers.length && sum == target){
            answer ++;
            return;
        }
        if(x >= numbers.length){
            return;
        }
        dfs(sum + numbers[x], x+1, numbers, target);
        dfs(sum - numbers[x], x+1, numbers, target);
    }
}

// class Solution {
//     int answer = 0;
//     public int solution(int[] numbers, int target) {
//         dfs(0, 0, numbers, target);
//         return answer;
//     }

//     private void dfs(int sum, int x, int[] numbers, int target) {
//         if (x == numbers.length && sum == target) {
//             answer++;
//             return;
//         }

//         if (x >= numbers.length) {
//             return;
//         }
//         dfs(sum + numbers[x], x + 1, numbers, target);
//         dfs(sum - numbers[x], x + 1, numbers, target);
//     }
// }