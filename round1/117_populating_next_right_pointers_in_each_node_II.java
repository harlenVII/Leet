/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        while (root != null){
            TreeLinkNode temp = root;
            while (temp != null){
                if (temp.left != null)
                    temp.left.next = temp.right == null ? findNext(temp.next) : temp.right;
                if (temp.right != null)
                    temp.right.next = findNext(temp.next);
                temp = temp.next;
            }
            root = findNext(root);
        }
    }
    private TreeLinkNode findNext(TreeLinkNode node){
        if (node == null)
            return null;
        if (node.left != null)
            return node.left;
        if (node.right != null)
            return node.right;
        return findNext(node.next);
    }
}
