public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums == null || nums.length == 0)
            return null;
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int index = a >= 0 ? nums.length - 1 : 0;
        while (i <= j) {
            if (a >= 0) {
                res[index--] = getRes(nums[i], a, b, c) > getRes(nums[j], a, b, c) ? getRes(nums[i++], a, b, c) : getRes(nums[j--], a, b, c);
            } else {
                res[index++] = getRes(nums[i], a, b, c) < getRes(nums[j], a, b, c) ? getRes(nums[i++], a, b, c) : getRes(nums[j--], a, b, c);
            }
        }
        return res;
    }
    private int getRes(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
