public class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, cache));
            }
        }
        return max;
    }
    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0)
            return cache[i][j];
        int max = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
                continue;
            if (matrix[x][y] > matrix[i][j])
                max = Math.max(max, dfs(matrix, x, y, cache) + 1);
        }
        cache[i][j] = max;
        return max;
    }
}
