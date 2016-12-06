/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode tmp = head;
        ListNode newList = null;
        while (tmp != null) {
            ListNode newNode = new ListNode(tmp.val);
            newNode.next = newList;
            newList = newNode;
            tmp = tmp.next;
        }
        while (head != null && head.val == newList.val) {
            head = head.next;
            newList = newList.next;
        }
        return head == null ? true : false;
    }
}
// O(1) place idea: reverse the latter half part; compare with the former half part; reverse the latter half part.
