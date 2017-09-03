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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        TreeNode last = null;
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                if (last == p) {
                    return temp;
                }
                last = temp;
                temp = temp.right;
                
            }
        }
        return null;
    }
}
