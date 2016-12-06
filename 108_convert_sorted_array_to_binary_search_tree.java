/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int[] leftNums = new int[nums.length / 2];
        int[] rightNums = new int[nums.length - nums.length / 2 - 1];
        for (int i = 0; i < nums.length / 2; i++)
            leftNums[i] = nums[i];
        for (int i = 0; i < nums.length - nums.length / 2 - 1; i++)
            rightNums[i] = nums[i + nums.length / 2 + 1];
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        root.left = sortedArrayToBST(leftNums);
        root.right = sortedArrayToBST(rightNums);
        return root;
    }
}
