public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] res = new int[m][n];
        int[][] reach = new int[m][n];
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        int buildingNum = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1)
                    continue;
                buildingNum++;
                Queue<Integer> queue = new LinkedList<>();
                boolean[][] visited = new boolean[m][n];
                queue.offer(i * n + j);
                int distance = 0;
                while (!queue.isEmpty()) {
                    distance++;
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int temp = queue.poll();
                        int x = temp / n;
                        int y = temp % n;
                        for (int l = 0; l < 4; l++) {
                            int newx = x + dx[l];
                            int newy = y + dy[l];
                            if (newx < 0 || newx == m || newy < 0 || newy == n || visited[newx][newy])
                                continue;
                            if (grid[newx][newy] == 0) {
                                res[newx][newy] += distance;
                                queue.offer(newx * n + newy);
                                visited[newx][newy] = true;
                                reach[newx][newy]++;
                            }
                        }
                    }
                }
            }
        }
        
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildingNum)
                    min = Math.min(res[i][j], min);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
