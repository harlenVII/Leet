/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);
        ListNode secondHalf = mid.next;
        mid.next = null;
        ListNode firstHalf = sortList(head);
        secondHalf = sortList(secondHalf);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val < secondHalf.val) {
                tail.next = firstHalf;
                tail = firstHalf;
                firstHalf = firstHalf.next;
            } else {
                tail.next = secondHalf;
                tail = secondHalf;
                secondHalf = secondHalf.next;
            }
        }
        while (firstHalf != null) {
            tail.next = firstHalf;
            tail = firstHalf;
            firstHalf = firstHalf.next;
        }
        while (secondHalf != null) {
            tail.next = secondHalf;
            tail = secondHalf;
            secondHalf = secondHalf.next;
        }
        tail.next = null;
        return dummy.next;
    }
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
