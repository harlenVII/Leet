/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumby = new ListNode(0);
        dumby.next = head;
        ListNode first = dumby;
        ListNode second = head;
        for (int i = 0; i < n; i++)
            if (second != null)
                second = second.next;
            else
                return null;
        while (second != null) {
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return dumby.next;
    }
}
