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
    }
}