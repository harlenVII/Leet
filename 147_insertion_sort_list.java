/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dumby = new ListNode(0);
        dumby.next = null;
        while (head != null) {
            ListNode tmp = head;
            head = head.next;
            ListNode i = dumby;
            while (i.next != null && tmp.val > i.next.val)
                i = i.next;
            tmp.next = i.next;
            i.next = tmp;
        }
        return dumby.next;
    }
}
