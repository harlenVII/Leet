/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null) {//only one item
            TreeNode leaf = new TreeNode(head.val);
            leaf.left = leaf.right = null;
            return leaf;
        }
        ListNode premid = findPreMid(head);//return the first item if only two items
        ListNode rootNode = premid.next;
        TreeNode root = new TreeNode(rootNode.val);
        premid.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(rootNode.next);
        return root;
    }
    private ListNode findPreMid(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, pre = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }
}
