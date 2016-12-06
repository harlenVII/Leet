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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return helper(root, sum, 0);
    }
    private boolean helper(TreeNode root, int sum, int cur){
        if (root.left == null && root.right == null) // leaf
            return sum == cur + root.val;
        if (root.left == null)
            return helper(root.right, sum, cur + root.val);
        if (root.right == null)
            return helper(root.left, sum, cur + root.val);
        return helper(root.left, sum, cur + root.val) || helper(root.right, sum, cur + root.val);
    }
}
