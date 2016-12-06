/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        if (k == 0)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        int size = 0;
        int i = 0;
        for (; i < k; i++) {
            size++;
            if (fast.next == null)
                break;
            else
                fast = fast.next;
        }
        if (i != k) {
            fast = head;
            if (k % size == 0)
                return head;
            for (i = 0; i < k % size; i++) 
                fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
