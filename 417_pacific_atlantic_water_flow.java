public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] pacific = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++)
            queue.offer(new int[]{i, 0});
        for (int j = 1; j < n; j++)
            queue.offer(new int[]{0, j});
        bfs(matrix, queue, pacific);

        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++)
            queue.offer(new int[]{i, n - 1});
        for (int j = 0; j < n - 1; j++)
            queue.offer(new int[]{m - 1, j});
        bfs(matrix, queue, atlantic);
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (atlantic[i][j] && pacific[i][j])
                    res.add(new int[]{i, j});
        return res;
        
    }
    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] flag) {
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            flag[temp[0]][temp[1]] = true;
            int[] dx = new int[]{1, -1, 0, 0};
            int[] dy = new int[]{0, 0, 1, -1};
            for (int i = 0; i < 4; i++) {
                int newx = temp[0] + dx[i];
                int newy = temp[1] + dy[i];
                if (newx < 0 || newx == matrix.length || newy < 0 || newy == matrix[0].length || flag[newx][newy])
                    continue;
                if (matrix[temp[0]][temp[1]] <= matrix[newx][newy])
                    queue.offer(new int[]{newx, newy});
            }
        }
    }
}
