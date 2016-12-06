/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dumby = new ListNode(0);
        dumby.next = head;
        ListNode tail = dumby;
        for (int i = 1; i < m; i++)
            tail = tail.next;
        head = tail.next;
        ListNode reverseTail = head;
        ListNode reverseHead = null;
        for (int i = 0; i < n - m + 1; i++) {
            ListNode tmp = head;
            head = head.next;
            tmp.next = reverseHead;
            reverseHead = tmp;
        }
        tail.next = reverseHead;
        reverseTail.next = head;
        return dumby.next;
    }
}
