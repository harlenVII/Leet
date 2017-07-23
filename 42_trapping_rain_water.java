public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (leftMax[i] > height[i] && rightMax[i] > height[i])
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}
