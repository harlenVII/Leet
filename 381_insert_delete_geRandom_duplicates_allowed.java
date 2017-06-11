public class RandomizedCollection {
    List<Integer> list = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    Random r = new Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = false;
        if (!map.containsKey(val))
            res = true;
        list.add(val);
        map.computeIfAbsent(val, i -> new ArrayList<Integer>()).add(list.size() - 1);
        return res;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        List<Integer> indexs = map.get(val);
        int index = indexs.get(indexs.size() - 1);
        int lastVal = list.get(list.size() - 1);
        if (index != list.size() - 1) {
            list.set(index, lastVal);
            List<Integer> tmp = map.get(lastVal);
            tmp.remove(new Integer(list.size() - 1));
            tmp.add(index);
        }
        // remove last element
        indexs.remove(indexs.size() - 1);
        if (indexs.size() == 0)
            map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
