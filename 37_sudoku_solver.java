public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        helper(board);
    }
    private boolean helper(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (valid(board, i, j, k)) {
                            board[i][j] = k;
                            if (helper(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean valid(char[][] board, int i, int j, char k) {
        for (int m = 0; m < 9; m++) {
            if (board[i][m] == k)
                return false;
            if (board[m][j] == k)
                return false;
            if (board[i/3*3+m/3][j/3*3+m%3] == k)
                return false;
        }
        return true;
    }
}
