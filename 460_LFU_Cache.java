public class LFUCache {
    private Map<Integer, Integer> kvs; // key -> value
    private Map<Integer, Integer> freqs; // key -> frequency
    private TreeMap<Integer, Set<Integer>> ftk; // frequency to keys
    private int capacity;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        kvs = new HashMap<>();
        freqs = new HashMap<>();
        ftk = new TreeMap<>();
    }
    
    public int get(int key) {
        if (!kvs.containsKey(key))
            return -1;
        int freq = freqs.get(key);
        freqs.put(key, freq + 1);
        ftk.get(freq).remove(key);
        if (ftk.get(freq).size() == 0)
            ftk.remove(freq);
        ftk.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
        return kvs.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (kvs.containsKey(key)) {
            // same key
            kvs.put(key, value);
            int freq = freqs.get(key);
            freqs.put(key, freq + 1);
            ftk.get(freq).remove(key);
            if (ftk.get(freq).size() == 0)
                ftk.remove(freq);
            ftk.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
            return;
        }
        if (kvs.size() == capacity) {
            // evit one key
            int evict = ftk.firstEntry().getValue().iterator().next();
            kvs.remove(evict);
            freqs.remove(evict);
            ftk.firstEntry().getValue().remove(evict);
            if (ftk.firstEntry().getValue().size() == 0) {
                ftk.remove(ftk.firstKey());
            }
        } 
        kvs.put(key, value);
        freqs.put(key, 0);
        ftk.computeIfAbsent(0, k -> new LinkedHashSet<>()).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
