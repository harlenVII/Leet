class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int o = B[0].length;
        int[][] res = new int[m][o];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < o; k++) {
                        if (B[j][k] != 0)
                            res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return res;
    }
}
