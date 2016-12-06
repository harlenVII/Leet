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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    private TreeNode build(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        int root = preorder[ps];
        TreeNode rootNode = new TreeNode(root);
        int index = 0;
        for (int i = is; i < ie; i++)
            if (inorder[i] == root){
                index = i;
                break;
            }
        rootNode.left = index == is ? null : build(preorder, ps + 1, ps + 1 + index - is, inorder, is, index);
        rootNode.right = index == ie - 1 ? null : build(preorder, ps + 1 + index - is, pe, inorder, index + 1, ie);
        return rootNode;
    }
}
