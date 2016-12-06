/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode tmp = head.next;
        head.next = null;
        ListNode newHead = head;
        while (tmp != null) {
            head = tmp;
            tmp = tmp.next;
            head.next = newHead;
            newHead = head;
        }
        return newHead;
    }
}
