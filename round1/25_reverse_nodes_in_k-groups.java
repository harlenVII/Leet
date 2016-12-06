/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode tail = dummy;
        while (head != null) {
            ListNode thisHead = head;
            for (int i = 0; i < k - 1; i++)
                if (head != null)
                    head = head.next;
            if (head == null) {
                tail.next = thisHead;
                return dummy.next;
            }
            head = head.next;
            ListNode tmpHead = null;
            ListNode i = thisHead;
            while (i != head) {
                ListNode tmp = i;
                i = i.next;
                tmp.next = tmpHead;
                tmpHead = tmp;
            }
            tail.next = tmpHead;
            tail = thisHead;
        }
        return dummy.next;
    }
}
