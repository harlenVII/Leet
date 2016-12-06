/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dumbyOdd = new ListNode(0);
        ListNode dumbyEven = new ListNode(0);
        ListNode oddTail = dumbyOdd;
        ListNode evenTail = dumbyEven;
        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                oddTail.next = head;
                oddTail = head;
            }else {
                evenTail.next = head;
                evenTail = head;
            }
            count++;
            head = head.next;
        }
        oddTail.next = dumbyEven.next;
        evenTail.next = null;
        return dumbyOdd.next;
    }
}
