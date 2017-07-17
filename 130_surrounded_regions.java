public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '1';
                queue.offer(i*n);
            }
            if (board[i][n - 1] == 'O') {
                board[i][n - 1] = '1';
                queue.offer(i * n + n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '1';
                queue.offer(j);
            }
            if (board[m - 1][j] == 'O') {
                board[m - 1][j] = '1';
                queue.offer((m - 1) * n + j);
            }
        }
        
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            int x = temp / n;
            int y = temp % n;
            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];
                if (newx < 0 || newx == m || newy < 0 || newy == n)
                    continue;
                if (board[newx][newy] == 'O') {
                    board[newx][newy] = '1';
                    queue.offer(newx * n + newy);
                }
            }
        }
        
        for (int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        for (int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1')
                    board[i][j] = 'O';
            }
        }
    }
}
