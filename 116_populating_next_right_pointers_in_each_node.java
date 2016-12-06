/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public void connect(TreeLinkNode root) {
    //     LinkedList<TreeLinkNode> list = new LinkedList<>();
    //     if (root == null)
    //         return;
    //     list.offer(root);
    //     while (!list.isEmpty()){
    //         int size = list.size();
    //         TreeLinkNode temp = null;
    //         for (int i = 0; i < size; i++){
    //             temp = list.poll();
    //             if (i < size -1)
    //                 temp.next = list.peek(); 
    //             if (temp.left != null)
    //                 list.offer(temp.left);
    //             if (temp.right != null)
    //                 list.offer(temp.right);
    //         }
    //     }
    // }
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        while (root.left != null){
            TreeLinkNode temp = root;
            while (temp != null){
                temp.left.next = temp.right;
                if (temp.next != null)
                    temp.right.next = temp.next.left;
                temp = temp.next;
            }
            root = root.left;
        }
    }
}
