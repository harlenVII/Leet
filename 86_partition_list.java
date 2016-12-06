/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dumbyLess = new ListNode(0);
        ListNode dumbyGreater = new ListNode(0);
        ListNode tailLess = dumbyLess;
        ListNode tailGreater = dumbyGreater;
        while (head != null) {
            if (head.val < x) {
                tailLess.next = head;
                tailLess = head;
            } else {
                tailGreater.next = head;
                tailGreater = head;
            }
            head = head.next;
        }
        tailLess.next = dumbyGreater.next;
        tailGreater.next = null;
        return dumbyLess.next;
    }
}
