class Solution {
    public int solution(String[][] board, int h, int w) {
        
        int width = board[0].length;
        int height = board.length;
        String color = board[h][w];
        int count = 0;
        if (w < width-1) {
            if (color.equals(board[h][w + 1])) {
                count++;
            }
        }
        if (h < height-1) {

            if (color.equals(board[h + 1][w])) {
                count++;
            }
        }
        if (w > 0) {

            if (color.equals(board[h][w-1])) {
                count++;
            }
        }
        if (h > 0) {

            if (color.equals(board[h-1][w])) {
                count++;
            }
        }
        return count;

        // int n = board.length; 
        // int count = 0; 
        // int[] dh = { 0, 1, -1, 0}; int[] dw = {1,0,0,-1};

        // for(int i = 0; i < 4; i++){
        //     int h_check = h + dh[i]; 
        //     int w_check = w + dw[i];
        //     if(h_check >= 0 && h_check < n && w_check >= 0 && w_check < n){
        //         if(board[h][w].equals(board[h_check][w_check])){
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
}
