public class NumMatrix {
    private int[][] bit;
    private int[][] nums;
    public NumMatrix(int[][] matrix) {
        // check input
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        this.bit = new int[m + 1][n + 1];
        this.nums = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                update(i, j, matrix[i][j]);
    }

    public void update(int row, int col, int val) {
        int diff = val - nums[row][col];
        nums[row][col] = val;
        for (int i = row + 1; i <= nums.length; i += i & (-i)) {
            for (int j = col + 1; j <= nums[0].length; j += j & (-j)) {
                bit[i][j] += diff;
            }
        }
    }
    private int getSum(int row, int col) {
        int sum = 0;
        for (int i = row + 1; i > 0; i -= i & (-i))
            for (int j = col + 1; j > 0; j -= j & (-j))
                sum += bit[i][j];
        return sum;
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) + getSum(row1 - 1, col1 - 1) - getSum(row1 - 1, col2) - getSum(row2, col1 - 1);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);
