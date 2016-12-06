public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        for (int i = 0; i < matrix.length; i++)
            if (matrix[i] == null || matrix[i].length == 0)
                return false;
        int start = 0, end = matrix.length * matrix[0].length - 1;
        while (start <= end){
            int middle = start + (end - start) / 2;
            int row = middle / matrix[0].length;
            int column = middle % matrix[0].length;
            if (matrix[row][column] == target)
                return true;
            else if (matrix[row][column] > target){
                end = middle - 1;
            }else
                start = middle + 1;
        }
        return false;
    }
}
