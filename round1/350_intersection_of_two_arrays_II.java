public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1)
            map1.put(num, map1.containsKey(num) ? map1.get(num) + 1 : 1);
        for (int num : nums2)
            map2.put(num, map2.containsKey(num) ? map2.get(num) + 1 : 1);
        
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int key = entry.getKey().intValue();
            if (map2.containsKey(key)) {
                int count = Math.min(entry.getValue().intValue(), map2.get(key).intValue());
                for (int i = 0; i < count; i++)
                    res.add(key);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
