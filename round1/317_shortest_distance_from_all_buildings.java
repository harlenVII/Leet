public class Solution {
    public int shortestDistance(int[][] grid) {
        // check input
        int buildingNum = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] distSum = new int[m][n];
        int[][] reach = new int[m][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1)
                    continue;
                buildingNum++;
                // bfs from each building
                boolean[][] visited = new boolean[m][n];
                Set<int[]> set = new HashSet<>();
                set.add(new int[]{i, j});
                int dist = 0;
                while (!set.isEmpty()) {
                    Set<int[]> temp = new HashSet<>();
                    dist++;
                    for (int[] point : set) {
                        for (int k = 0; k < 4; k++) {
                            int x = point[0] + dx[k];
                            int y = point[1] + dy[k];
                            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && !visited[x][y]) {
                                visited[x][y] = true;
                                reach[x][y]++;
                                distSum[x][y] += dist;
                                temp.add(new int[]{x, y});
                            }
                        }
                    }
                    set = temp;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum) {
                    res = Math.min(res, distSum[i][j]);
                }        
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
