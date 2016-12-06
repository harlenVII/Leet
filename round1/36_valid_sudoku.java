public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        int[] map = new int[10];
        for (char[] row : board) {// row
            for (char point : row) {
                if (point == '.')
                    continue;
                if (map[point - '0'] == 1)
                    return false;
                map[point - '0'] = 1;
            }
            setZero(map);
        }
        for (int i = 0; i < board[0].length; i++) {// column
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.')
                    continue;
                if (map[board[j][i] - '0'] == 1)
                    return false;
                map[board[j][i] - '0'] = 1;
            }
            setZero(map);
        }
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[0].length; j += 3) {
                for (int m = i; m < i + 3; m++) {
                    for (int n = j; n < j + 3; n++) {
                        if (board[m][n] == '.')
                            continue;
                        if (map[board[m][n] - '0'] == 1)
                            return false;
                        map[board[m][n] - '0'] = 1;
                    }
                }
                setZero(map);
            }
        }
        return true;
    }
    private void setZero(int [] nums) {
        for (int i = 0; i < nums.length; i++)
            nums[i] = 0;
    }
}
