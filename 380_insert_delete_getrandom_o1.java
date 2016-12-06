public class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        if (map.get(val) != list.size() - 1) {
            // swap
            int swapVal = list.get(list.size() - 1);
            map.put(swapVal, map.get(val));
            list.set(map.get(val), swapVal);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
