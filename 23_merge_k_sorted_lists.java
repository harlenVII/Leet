/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
        new Comparator(){
            public int compare(Object o1, Object o2) {
                return ((ListNode)o1).val - ((ListNode)o2).val;
            }    
        });
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null)
                queue.offer(lists[i]);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null)
                queue.offer(tail.next);
        }
        tail.next = null;
        return dummy.next;
    }
}
