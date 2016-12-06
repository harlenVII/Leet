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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0)
            return null;
        return build(postorder, 0, postorder.length, inorder, 0, inorder.length);
    }
    private TreeNode build(int[] postorder, int ps, int pe, int[] inorder, int is, int ie) {
        int root = postorder[pe - 1];
        TreeNode rootNode = new TreeNode(root);
        int index = 0;
        for (int i = is; i < ie; i++)
            if (inorder[i] == root){
                index = i;
                break;
            }
        rootNode.left = index == is ? null : build(postorder, ps, ps + index - is, inorder, is, index);
        rootNode.right = index == ie - 1 ? null : build(postorder, ps + index - is, pe - 1, inorder, index + 1, ie);
        return rootNode;
    }
}
