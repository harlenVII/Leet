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
        List<String> list = new ArrayList<>();
        if (root == null)
            return list;
        helper(root, list, new StringBuilder());
        return list;
    }
    private void helper(TreeNode node, List<String> list, StringBuilder s){
        if (node == null)
            return;
        if (node.left == null && node.right == null){
            s.append(node.val);
            list.add(s.toString());
        }else {
            s.append(String.valueOf(node.val) + "->");
            StringBuilder s1 = new StringBuilder(s.toString());
            helper(node.left, list, s);
            helper(node.right, list, s1);
        }
    }
}
