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
        return BST(nums, 0, nums.length - 1);
    }
    private TreeNode BST(int[] nums, int i, int j) {
        if (i > j)
            return null;
        int mid = i + (j - i) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums, i, mid - 1);
        root.right = BST(nums, mid + 1, j);
        return root;
    }
}
