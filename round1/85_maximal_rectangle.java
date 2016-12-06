public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int[] line = new int[matrix[0].length];
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            getLine(matrix, line, i);
            result = Math.max(result, maxArea(line));
        }
        return result;
    }
    private void getLine(char[][] matrix, int[] line, int index) {
        for (int i = 0; i < matrix[index].length; i++) {
            if (matrix[index][i] == '1')
                line[i]++;
            else
                line[i] = 0;
        }
    }
    private int maxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(res, heights[top] * width);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            res = Math.max(res, heights[top] * width);
        }
        return res;
    }
}
