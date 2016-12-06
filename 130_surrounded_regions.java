// //when the matrix is big, bfs will stackoverflow
// public class Solution {
//     public void solve(char[][] board) {
//         if (board == null || board.length == 0)
//             return;
//         int row = board.length;
//         int col = board[0].length;
        
//         for (int i = 0; i < row; i++) {
//             if (board[i][0] == 'O')
//                 bfs(board, i, 0);
//             if (board[i][col - 1] == 'O')
//                 bfs(board, i, col - 1);
//         }
//         for (int j = 0; j < col; j++) {
//             if (board[0][j] == 'O')
//                 bfs(board, 0, j);
//             if (board[row - 1][j] == 'O')
//                 bfs(board, row - 1, j);
//         }
        
//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 if (board[i][j] == 'O')
//                     board[i][j] = 'X';
//                 else if (board[i][j] == '1')
//                     board[i][j] = 'O';
//             }
//         }
//     }
//     private void bfs(char[][] board, int x, int y) {
//         board[x][y] = '1';
//         if (x - 1 >= 0 && board[x - 1][y] == 'O')
//             bfs(board, x - 1, y);
//         if (y - 1 >= 0 && board[x][y - 1] == 'O')
//             bfs(board, x, y - 1);
//         if (x + 1 < board.length && board[x + 1][y] == 'O')
//             bfs(board, x + 1, y);
//         if (y + 1 < board[0].length && board[x][y + 1] == 'O')
//             bfs(board, x, y + 1);
//     }
// }

public class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        Queue<Point> queue = new LinkedList<>();
        int row = board.length;
        int col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                board[i][0] = '1';
                queue.offer(new Point(i, 0));
            }
            if (board[i][col - 1] == 'O') {
                board[i][col - 1] = '1';
                queue.offer(new Point(i, col - 1));
            }
        }
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') {
                board[0][j] = '1';
                queue.offer(new Point(0, j));
            }
            if (board[row - 1][j] == 'O') {
                board[row - 1][j] = '1';
                queue.offer(new Point(row - 1, j));
            }
        }
        
        while (!queue.isEmpty()){
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                board[x - 1][y] = '1';
                queue.offer(new Point(x - 1, y));
            }
            if (y - 1 >= 0 && board[x][y - 1] == 'O') {
                board[x][y - 1] = '1';
                queue.offer(new Point(x, y - 1));
            }
            if (x + 1 < board.length && board[x + 1][y] == 'O') {
                board[x + 1][y] = '1';
                queue.offer(new Point(x + 1, y));
            }
            if (y + 1 < board[0].length && board[x][y + 1] == 'O') {
                board[x][y + 1] = '1';
                queue.offer(new Point(x, y + 1));
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '1')
                    board[i][j] = 'O';
            }
        }
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
