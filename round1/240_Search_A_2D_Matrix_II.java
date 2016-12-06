public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i] == null || matrix[i].length == 0)
                return false;
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j <= matrix[0].length - 1){
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                i--;
            else
                j++;
        }
        return false;
    }
}
