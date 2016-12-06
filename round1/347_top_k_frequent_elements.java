public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int value = map.containsKey(num) ? map.get(num) + 1 : 1;
            map.put(num, value);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<Integer, Integer>)o2).getValue() - ((Map.Entry<Integer, Integer>)o1).getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) 
            heap.offer(entry);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(heap.poll().getKey());
        }
        return list;
    }
}
