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
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        helper(root.left, root.val, 1);
        helper(root.right, root.val, 1);
        return max;
    }
    private void helper(TreeNode node, int parent, int length) {
        if (node == null)
            return;
        if (node.val == parent + 1) {
            length += 1;
        } else {
            length = 1;
        }
        max = Math.max(max, length);
        helper(node.left, node.val, length);
        helper(node.right, node.val, length);
    }
}
