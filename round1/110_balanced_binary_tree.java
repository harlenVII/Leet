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
    public boolean isBalanced(TreeNode root) {
        int result = height(root);
        return result != -1;
    }
    private int height(TreeNode root){
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1)//subtree is not balanced
            return -1;
        if (Math.abs(left - right) <= 1)
            return Math.max(left, right) + 1;//balanced
        else 
            return -1;//not balanced
    }
}
