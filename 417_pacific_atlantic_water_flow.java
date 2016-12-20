public class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            bfs(matrix, pac, i, 0);
            bfs(matrix, atl, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            bfs(matrix, pac, 0, j);
            bfs(matrix, atl, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
    private void bfs(int[][] matrix, boolean[][] flag, int i, int j) {
        if (flag[i][j])
            return;
        flag[i][j] = true;
        for (int m = 0; m < 4; m++) {
            int x = i + dx[m];
            int y = j + dy[m];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
                continue;
            if (matrix[x][y] >= matrix[i][j])
                bfs(matrix, flag, x, y);
        }
    }
}
