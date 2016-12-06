/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int res = l1.val + l2.val + carry;
            if (res >= 10) {
                res -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode temp = new ListNode(res);
            tail.next = temp;
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int res = l1.val + carry;
            if (res >= 10) {
                res -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode temp = new ListNode(res);
            tail.next = temp;
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int res = l2.val + carry;
            if (res >= 10) {
                res -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode temp = new ListNode(res);
            tail.next = temp;
            tail = tail.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            tail.next = temp;
            tail = tail.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
