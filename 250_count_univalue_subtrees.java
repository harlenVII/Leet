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
    int result = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null)
            return 0;
        helper(root);
        return result;
    }
    private boolean helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            result++;
            return true;
        } else if (root.left == null) {
            if (helper(root.right) && root.val == root.right.val) {
                result++;
                return true;
            }
            return false;
        } else if (root.right == null) {
            if (helper(root.left) && root.val == root.left.val) {
                result++;
                return true;
            }
            return false;
        } else {
            boolean left = helper(root.left);
            boolean right = helper(root.right);
            if (left && right && root.val == root.left.val && root.val == root.right.val) {
                result++;
                return true;
            }
            return false;
        }
    }
}
