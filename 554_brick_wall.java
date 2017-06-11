public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        // check input
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        if (map.size() == 0)
            return wall.size();
        return wall.size() - Collections.max(map.values());
    }
}
