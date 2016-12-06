/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dumby = new ListNode(0);
        dumby.next = head;
        ListNode pre = dumby;
        while (head.next != null) {
            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head.next = head.next.next;
                }
                pre.next = head.next;
                head = head.next;
                if (head == null)
                    return dumby.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return dumby.next;
    }
}
