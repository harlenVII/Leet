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
public boolean isValidSudoku(char[][] board) {
        // check input
        boolean[][] check1 = new boolean[9][9], check2 = new boolean[9][9], check3 = new boolean[9][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int k = i / 3 * 3 + j / 3;
                    if (check1[i][num] || check2[j][num] || check3[k][num]) 
                        return false;
                    check1[i][num] = check2[j][num] = check3[k][num] = true;
                }
            }
        }
        return true;
    }
