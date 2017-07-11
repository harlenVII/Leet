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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        helper(root, res, new ArrayList<String>());
        return res;
    }
    private void helper(TreeNode root, List<String> res, List<String> cur) {
        cur.add(String.valueOf(root.val));
        if (root.left == null && root.right == null) {
            res.add(String.join("->", cur));
            return;
        }
        List<String> snapshot = new ArrayList<>(cur);
        if (root.left != null)
            helper(root.left, res, cur);
        if (root.right != null)
            helper(root.right, res, snapshot);
    }
}
