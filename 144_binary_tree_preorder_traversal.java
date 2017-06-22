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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            if (temp != null) {
                res.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            } else {
                temp = stack.pop();
                temp = temp.right;
            }
        }
        return res;
    }
}
