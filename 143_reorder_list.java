/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        ListNode mid = findMid(head);
        ListNode secondHalf = mid.next;
        mid.next = null;
        ListNode secondHead = null;
        while (secondHalf != null) {
            ListNode tmp = secondHalf;
            secondHalf = secondHalf.next;
            tmp.next = secondHead;
            secondHead = tmp;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head != null && secondHead != null) {
            tail.next = head;
            tail = tail.next;
            head = head.next;

            tail.next = secondHead;
            tail = tail.next;
            secondHead = secondHead.next;
        }
        if (head != null) {
            tail.next = head;
        }
        head = dummy.next;
    }
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
