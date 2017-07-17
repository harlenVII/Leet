public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null)
            return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, new boolean[board.length][board[0].length], word, i, j))
                    return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, boolean[][] visited, String word, int x, int y) {
        if (word.isEmpty())
            return true;
        if (x < 0 || x == board.length || y < 0 || y == board[0].length)
            return false;
        if (word.charAt(0) != board[x][y] || visited[x][y])
            return false;
        visited[x][y] = true;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            if (helper(board, visited, word.substring(1), newx, newy))
                return true;
        }
        visited[x][y] = false;
        return false;
    }
}
