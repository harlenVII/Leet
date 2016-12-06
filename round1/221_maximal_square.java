public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
            result = Math.max(dp[i][0], result);
        }
        for (int i = 0; i < col; i++) {
            dp[0][i] = matrix[0][i] - '0';
            result = Math.max(dp[0][i], result);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '0')
                    dp[i][j] = 0;
                else {
                    int up = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    if (up != left)
                        dp[i][j] = Math.min(up, left) + 1;
                    else
                        dp[i][j] = matrix[i - up][j - up] == '0' ? up : up + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }
}
