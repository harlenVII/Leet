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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if (isValidBST(root.left) && isValidBST(root.right)){
            //find the rightest key in left subtree
            TreeNode left = root.left;
            if (left != null)
                while (left.right != null)
                    left = left.right;
            long leftVal = left == null ? Long.MIN_VALUE : left.val;
            //find the leftest key in right subtree
            TreeNode right = root.right;
            if (right != null)
                while (right.left != null)
                    right = right.left;
            long rightVal = right == null ? Long.MAX_VALUE : right.val;
            
            if (leftVal < root.val && root.val < rightVal)
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
