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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> tree = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.empty()){
            while (temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            
            if (!stack.empty()){
                temp = stack.pop();
                tree.add(temp.val);
                temp = temp.right;
            }
        }
        return tree;
    }
}
