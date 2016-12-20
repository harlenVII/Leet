public class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    bfs(rooms, i, j, 0);
                }
            }
        }
    }
    private void bfs(int[][] rooms, int i, int j, int distance) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length)
            return;
        if (rooms[i][j] == -1)
            return;
        if (distance > rooms[i][j])
            return;
        rooms[i][j] = distance;
        bfs(rooms, i + 1, j, distance + 1);
        bfs(rooms, i - 1, j, distance + 1);
        bfs(rooms, i, j + 1, distance + 1);
        bfs(rooms, i, j - 1, distance + 1);
    }
}
