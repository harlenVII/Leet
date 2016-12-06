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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (root.val > max)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < min)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
