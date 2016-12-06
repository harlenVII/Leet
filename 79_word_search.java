public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                result = result || helper(board, used, word, i, j);
        }
        return result;
    }
    private boolean helper(char[][] board, boolean[][] used, String word, int i, int j) {
        if (used[i][j] == true || board[i][j] != word.charAt(0))
            return false;
        if (word.length() == 1 && board[i][j] == word.charAt(0))
            return true;
        used[i][j] = true;
        boolean result = false;
        String sub = word.substring(1);
        if (i - 1 >= 0)
            result = result || helper(board, used, sub, i - 1, j);
        if (j - 1 >= 0)
            result = result || helper(board, used, sub, i, j - 1);
        if (i + 1 < board.length)
            result = result || helper(board, used, sub, i + 1, j);
        if (j + 1 < board[0].length)
            result = result || helper(board, used, sub, i, j + 1);
        used[i][j] = false;
        return result;
    }
}
