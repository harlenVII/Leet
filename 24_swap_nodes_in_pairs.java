/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dumby = new ListNode(0);
        ListNode tail = dumby;
        while (head != null) {
            if (head.next != null) {
                ListNode one = head;
                ListNode two = head.next;
                head = head.next.next;
                tail.next = two;
                two.next = one;
                tail = one;
            }else {
                tail.next = head;
                return dumby.next;
            }
        }
        tail.next = null;
        return dumby.next;
    }
}
