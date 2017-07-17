public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0)
                    queue.offer(i * n + j);
            }
        }
        
        int distance = 0;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                int x = temp / n;
                int y = temp % n;
                for (int j = 0; j < 4; j++) {
                    int newx = x + dx[j];
                    int newy = y + dy[j];
                    if (newx < 0 || newx == m || newy < 0 || newy == n)
                        continue;
                    if (rooms[newx][newy] > distance) {
                        rooms[newx][newy] = distance;
                        queue.offer(newx * n + newy);
                    }
                }
            }
        }
    }
}
