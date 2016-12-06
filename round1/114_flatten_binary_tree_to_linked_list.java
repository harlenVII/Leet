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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        combineLeftAndRight(root);
    }
    private void combineLeftAndRight(TreeNode root){
        TreeNode temp = root.left;
        if (temp == null)
            return;
        while (temp.right != null)
            temp = temp.right;
        temp.right = root.right;
        root.right = root.left;
        root.left = null;
    }
}
