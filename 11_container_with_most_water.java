public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1)
            return 0;
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, (j - i) * height[i]);
                i++;
            } else {
                max = Math.max(max, (j - i) * height[j]);
                j--;
            }
        }
        return max;
    }
}
