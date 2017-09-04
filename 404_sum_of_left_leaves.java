/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        helper(root, false);
        return sum;
    }
    private void helper(TreeNode node, boolean isLeft) {
        if (node.left == null && node.right == null) {
            if (isLeft)
                sum += node.val;
            return;
        }
        if (node.left != null) helper(node.left, true);
        if (node.right != null) helper(node.right, false);
    }
}
