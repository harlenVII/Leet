public class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    Map<Integer, Node> map;
    Node dummy;
    Node tail;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        dummy = new Node(0, 0);
        tail = new Node(0, 0);
        this.capacity = capacity;
        dummy.next = tail;
        tail.pre = dummy;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        // remove node
        Node temp = map.get(key);
        temp.pre.next = temp.next;
        temp.next.pre = temp.pre;
        
        // add this node to tail
        tail.pre.next = temp;
        temp.pre = tail.pre;
        temp.next = tail;
        tail.pre = temp;
        
        return temp.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            temp.value = value;
            // remove node
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;

            // add this node to tail
            tail.pre.next = temp;
            temp.pre = tail.pre;
            temp.next = tail;
            tail.pre = temp;
            return;
        }
        if (map.size() == capacity) {
            // evict 
            Node temp = dummy.next;
            map.remove(temp.key);
            dummy.next = temp.next;
            temp.next.pre = temp.pre;
        }
        Node temp = new Node(key, value);
        tail.pre.next = temp;
        temp.pre = tail.pre;
        temp.next = tail;
        tail.pre = temp;
        map.put(key, temp);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
