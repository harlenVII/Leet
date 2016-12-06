/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = null;
        RandomListNode tmp = head;
        RandomListNode tail = dummy;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (tmp != null) {
            RandomListNode cur = new RandomListNode(tmp.label);
            map.put(tmp, cur);
            tail.next = cur;
            tail = cur;
            tmp = tmp.next;
        }
        tail.next = null;
        tmp = head;
        RandomListNode tmpNew = dummy.next;
        while (tmp != null) {
            tmpNew.random = map.get(tmp.random);
            tmp = tmp.next;
            tmpNew = tmpNew.next;
        }
        return dummy.next;
    }
}
